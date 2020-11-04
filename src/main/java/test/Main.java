package test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.random.RandomRDDs;
import org.apache.spark.sql.SparkSession;

public class Main {
    public static void main(String[] args) {
        var conf = new SparkConf()
                .setAppName("randomGenerator")
                .setMaster("local[*]")
                .set("spark.ui.enabled", "false");

        var spark = SparkSession.builder().config(conf).getOrCreate();


        var rdd = RandomRDDs.normalJavaRDD(new JavaSparkContext(spark.sparkContext()), 1)
                .map(d -> new DemoClass(d.toString(), DemoEnum.ENUM_VALUE));


        var dataFrame = spark.createDataFrame(rdd, DemoClass.class);

        /* Enum values take the string value on the schema
         root
         |-- enumValue: string (nullable = true)
         |-- stringValue: string (nullable = true)
         */
        System.out.println("Printing schema");
        dataFrame.printSchema();

        // This will fail because catalyst is unable to convert enums to their string representation
        // java.lang.IllegalArgumentException: The value (ENUM_VALUE) of the type (test.DemoEnum) cannot be converted to the string type
        dataFrame.show();

    }
}
