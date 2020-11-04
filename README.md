# SPARK-33330 example code
Demonstrate the need to add support for Enums on CatalystTypeConverters

using JDK-11, execute

`./gradlew run`

Output:
```
Printing schema
root
 |-- enumValue: string (nullable = true)
 |-- stringValue: string (nullable = true)

20/11/04 11:13:00 ERROR Executor: Exception in task 0.0 in stage 1.0 (TID 1)
java.lang.IllegalArgumentException: The value (ENUM_VALUE) of the type (test.DemoEnum) cannot be converted to the string type
        at org.apache.spark.sql.catalyst.CatalystTypeConverters$StringConverter$.toCatalystImpl(CatalystTypeConverters.scala:296)
        at org.apache.spark.sql.catalyst.CatalystTypeConverters$StringConverter$.toCatalystImpl(CatalystTypeConverters.scala:289)

```