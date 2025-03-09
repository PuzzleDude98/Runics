package net.pd98.types.data_types;

public enum DestructionType {
    BREAK("break"),
    NONE("none"),
    DESTROY("destroy");

    private final String value;

    DestructionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DestructionType fromString(String str) {
        for (DestructionType type : values()) {
            if (type.value.equalsIgnoreCase(str)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown destruction type: " + str);
    }
}