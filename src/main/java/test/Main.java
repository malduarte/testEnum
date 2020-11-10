package test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.random.RandomRDDs;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var conf = new SparkConf()
                .setAppName("randomGenerator")
                .setMaster("local[*]")
                .set("spark.ui.enabled", "false");

        var spark = SparkSession.builder().config(conf).getOrCreate();



        var data = List.of(new DemoClass("data", DemoEnum.ENUM_VALUE));

        var dataFrame = spark.createDataFrame(data, DemoClass.class);

        dataFrame.createOrReplaceTempView("test");

        var rows = spark.sql("select enumValue from test").collectAsList();
        String enumValue = rows.get(0).getAs("enumValue");
        if(enumValue.equals("ENUM_VALUE")) {
            System.out.println("All good");
        } else {
            System.out.println("Enum not handled properly");
        }

    }
}
