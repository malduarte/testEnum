# SPARK-33330 example code
Demonstrate the need to add support for Enums on CatalystTypeConverters

using JDK-11, execute

`./gradlew run`

Output:
```
Exception in thread "main" java.lang.IllegalArgumentException: The value (ENUM_VALUE) of the type (test.DemoEnum) cannot be converted to the string type
```