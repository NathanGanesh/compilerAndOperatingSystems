package nl.saxion.cos;

import java.util.HashMap;

public class SymbolTable {

    private int nextIndex;
    private SymbolTable parentScope;

    private final HashMap<String,Symbol> symbols;

    public SymbolTable(int offset) {
        this.nextIndex = offset;
        this.symbols = new HashMap<>();
    }

    public SymbolTable getParentScope() {
        return parentScope;
    }

    public Symbol lookUpLocal(String name) {
        return symbols.get(name);
    }

    public Symbol lookUp(String name) {
        Symbol symbol = symbols.get(name);
        if (symbol == null && parentScope != null) {
            symbol = parentScope.lookUp(name);
        }
        return symbol;
    }

    public void add(String name, DataType type) {
        symbols.put(name,new Symbol(name,type,nextIndex));

        if (type == DataType.DOUBLE ) {
            nextIndex += 2;
        } else {
            nextIndex++;
        }
    }

    public void add2(String name, DataType type) {
        symbols.put(name,new Symbol(name,type,nextIndex-1));

        if (type == DataType.DOUBLE ) {
            nextIndex += 2;
        } else {
            nextIndex++;
            System.out.println(name+ " sdfjhk");
        }
    }



    // The addGlobal() method assigns a slot of -1, since it is a static attribute of class Main and has no slot.
    public void addGlobal(String name, DataType type) {
        symbols.put(name,new Symbol(name,type,-1));
    }

    // openScope(), 'openFunctionScope()' and 'openFunctionScope()' are convenience methods.

    // Opens a new scope for a function, i.e. static method. So it starts counting arguments
    // and variables at 0.
    public SymbolTable openFunctionScope() {
        return createScope(0);
    }

    // Opens a new scope for a method, i.e. static method. So it starts counting arguments
    // and variables at 1. this takes the 'this' into account.
    public SymbolTable openMethodScope() {
        return createScope(1);
    }

    // Opens a scope other than a function or method, say an if or while block. It doesn't
    // reset the counting but keeps on counting.
    public SymbolTable openScope() {
        return createScope(nextIndex);
    }

    private SymbolTable createScope(int offset) {
        SymbolTable childScope = new SymbolTable(offset);
        childScope.parentScope = this;

        return childScope;
    }

    public char getTypeLetter2(String type) {
        System.out.println(type);
        switch (type) {
            case "int":
                return 'i';
            case "double":
                return 'd';
            case "bool":
                return 'b';
            case "Text":
                return 't';
            case "void":
                return 'v';
            default:
                return '?';
        }
    }

    public char getTypeLetter(DataType type) {
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

    public DataType getTypeEnum(String type) {
        switch (type.toLowerCase()) {
            case "int":
                return DataType.INT;
            case "double":
                return DataType.DOUBLE;
            case "boolean":
                return DataType.BOOLEAN;
            case "text":
                return DataType.TEXT;
            case "void":
                return DataType.VOID;
            default:
                return DataType.UNKNOWN;
        }
    }

    public String getTypeName(char c) {
        switch (c) {
            case 'i':
                return "int";
            case 'f':
                return "float";
            case 'b':
                return "bool";
            case 't':
                return "Text";
            case 'v':
                return "void";
            default:
                return "unknown";
        }
    }

    public SymbolTable closeScope() {
        return parentScope;
    }

    public HashMap<String, Symbol> getSymbols() {
        return symbols;
    }
}
