package test;

public class DemoClass {
    String stringValue;
    DemoEnum enumValue;

    public DemoClass(String stringValue, DemoEnum enumValue) {
        this.stringValue = stringValue;
        this.enumValue = enumValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public DemoEnum getEnumValue() {
        return enumValue;
    }
}
