package nl.saxion.cos;

public class Symbol {
    private String name;
    private DataType type;
    private int localSlot;

    public Symbol( String name, DataType type, int localSlot ) {
        this.name = name;
        this.type = type;
        this.localSlot = localSlot;
    }

    public String getName() {
        return name;
    }

    public DataType getType() {
        return type;
    }

    public int getLocalSlot() {
        return localSlot;
    }
}
