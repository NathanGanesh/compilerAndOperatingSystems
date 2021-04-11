package nl.saxion.cos;

public enum DataType {
    DOUBLE, INT, TEXT, BOOLEAN, VOID, UNKNOWN;

    public static String getFunctionDescriptor(String type) {
        switch (type.toLowerCase()) {
            case "int": {
                return "I";
            }
            case "double": {
                return "D";
            }
            case "text": {
                return "Ljava/lang/String;";
            }
            case "boolean": {
                return "Z";
            }
            case "void": {
                return "V";
            }
            default:
                return "UNKNOWN";
        }
    }

    public static String getFunctionReturn(String type) {
        switch (type.toLowerCase()) {
            case "double": {
                return "d";
            }
            case "text": {
                return "a";
            }
            case "void": {
                return "";
            }
            default:
                return "i";
        }
    }
}