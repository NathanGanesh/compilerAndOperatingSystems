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

    public static char getTypeLetter(DataType type) {
        System.out.println(type + "123");
        switch (type) {
            case INT:
                return 'i';
            case DOUBLE:
                return 'd';
            case BOOLEAN:
                return 'b';
            case TEXT:
                return 'T';
            case VOID:
                return 'v';
            default:
                return '?';
        }
    }

    public static char getTypeLetter2(DataType type) {
        System.out.println(type + "123");
        switch (type) {
            case INT:
                return 'I';
            case DOUBLE:
                return 'D';
            case BOOLEAN:
                return 'B';
            case TEXT:
                return 'T';
            case VOID:
                return 'V';
            default:
                return '?';
        }
    }
}
