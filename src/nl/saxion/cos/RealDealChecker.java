package nl.saxion.cos;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;


import static nl.saxion.cos.DataType.*;

public class RealDealChecker extends TheRealDealLangBaseVisitor<DataType> {

    private boolean failed = false;
    private final ParseTreeProperty<DataType> dataTypes;
    private SymbolTable symbolTable;
    private final ParseTreeProperty<SymbolTable> scope;

    public boolean isFailed() {
        return failed;
    }

    public RealDealChecker(ParseTreeProperty<DataType> dataTypes, SymbolTable symbolTable, ParseTreeProperty<SymbolTable> scope) {
        this.dataTypes = dataTypes;
        this.symbolTable = symbolTable;
        this.scope = scope;
    }


    @Override
    public DataType visitBooleanExpr(TheRealDealLangParser.BooleanExprContext ctx) {
        return addType(ctx, BOOLEAN);
    }

    @Override
    public DataType visitTextExpr(TheRealDealLangParser.TextExprContext ctx) {
        return addType(ctx, TEXT);
    }

    @Override
    public DataType visitDoubleExpr(TheRealDealLangParser.DoubleExprContext ctx) {
        return addType(ctx, DOUBLE);
    }

    @Override
    public DataType visitIntExpr(TheRealDealLangParser.IntExprContext ctx) {
        return addType(ctx, INT);
    }




    @Override
    public DataType visitVariableExpr(TheRealDealLangParser.VariableExprContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = symbolTable.lookUp(name);
        if (symbol == null) {
            throw new CompilerException("Use of variable " + name + " before declaration");
        }
        System.out.println(ctx.IDENTIFIER().getText() + "hey3123213");
        dataTypes.put(ctx, symbol.getType());
        scope.put(ctx, symbolTable);
        return symbol.getType();
    }

    @Override
    public DataType visitAssignVarStmt(TheRealDealLangParser.AssignVarStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = symbolTable.lookUpLocal(name);
        DataType type = symbolTable.getTypeEnum(ctx.IDENTIFIER().getText());
        System.out.println("NOTWORKING"+type);
        if (symbol != null) {
            throw  new CompilerException("Variable " + name + "already defined.");
        }


        String exprText = ctx.expr().getText();
        System.out.println(ctx.getText());
        System.out.println("got hit here");

        switch (ctx.expr().getText()) {
            case "scanInt()":
                if (symbol.getType() != INT) {
                    throw new CompilerException("Incompatiple datatypes");
                } else {
                    System.out.println(ctx.getText());
                    visit(ctx.expr());
                }
                break;
            case "scanText()":
                if (symbol.getType() != TEXT) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                break;
            case "scanBoolean()":
                if (symbol.getType() != BOOLEAN) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                break;
            case "scanDouble()":
                if (symbol.getType() != DataType.DOUBLE) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                break;
            default:
                if (!symbol.getType().equals(visit(ctx.expr()))) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                break;
        }
        if (symbolTable.getParentScope() == null) {
            // Global variable, i.e. static data member of class Main.
            symbolTable.addGlobal(name, type);
        } else {
            // Local variable, so assign a slot.
            symbolTable.add(name, type);
        }

        System.out.println(ctx.getText());
        dataTypes.put(ctx, symbol.getType());
        scope.put(ctx, symbolTable);
        return symbol.getType();
    }

    @Override
    public DataType visitCompareExpr(TheRealDealLangParser.CompareExprContext ctx) {
        DataType leftType = visit(ctx.left);
        DataType rightType = visit(ctx.right);

        if (leftType != rightType) {
            throw new CompilerException("Left and right type are not the same!");
        }
        if (!(leftType == DataType.DOUBLE || leftType == INT)) {
            throw new CompilerException("Not double or int");
        }
        System.out.println(ctx.getText() + "here2");
        dataTypes.put(ctx, BOOLEAN);
        scope.put(ctx, symbolTable);
        return addType(ctx, BOOLEAN);
    }

    @Override
    public DataType visitEqualExpr(TheRealDealLangParser.EqualExprContext ctx) {
        DataType leftType = visit(ctx.left);
        DataType rightType = visit(ctx.right);

        if (leftType != rightType) {
            throw new CompilerException("Left and right type are not the same!");
        }
        if (!(leftType == DataType.DOUBLE || leftType == INT)) {
            throw new CompilerException("Not double or int");
        }
        System.out.println(ctx.getText() + "here2");
        dataTypes.put(ctx, BOOLEAN);
        scope.put(ctx, symbolTable);
        return addType(ctx, BOOLEAN);
    }

    @Override
    public DataType visitLogicalExpr(TheRealDealLangParser.LogicalExprContext ctx) {
        DataType leftType = visit(ctx.left);
        DataType rightType = visit(ctx.right);
        System.out.println("compare");
        if (leftType != BOOLEAN && rightType != BOOLEAN) {
            throw new CompilerException("Left or right not boolean");
        }
        if (leftType != rightType) {
            throw new CompilerException("Left and right type are not the same!");
        }

        System.out.println(ctx.getText());
        scope.put(ctx, symbolTable);
        return addType(ctx, BOOLEAN);
    }

    @Override
    public DataType visitVarDeclStmt(TheRealDealLangParser.VarDeclStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = symbolTable.lookUp(name);
        if (symbol != null) {
            throw new CompilerException("Use of variable " + name + " Is already in use");
        }

//        if (ctx.expr() != null) {
//            String type = ctx.TYPE().getText().toUpperCase();
//            DataType tp2 = visit(ctx.expr());
//            if (!tp2.toString().equals(type)) {
//                throw new CompilerException("Incompatiple datatypes");
//            }
//        }
        if (ctx.type.getText().equals("int")) {
            symbolTable.add(name, INT);
        } else if (ctx.type.getText().equals("Text")) {
            symbolTable.add(name, TEXT);
        } else if (ctx.type.getText().equals("boolean")) {
            symbolTable.add(name, BOOLEAN);
        } else if (ctx.type.getText().equals("double")) {
            symbolTable.add(name, DataType.DOUBLE);
        } else {
            System.out.println("got hit here");
            throw new CompilerException("Incompatiple datatypes");
        }
        dataTypes.put(ctx, symbolTable.lookUp(name).getType());
        scope.put(ctx, symbolTable);
        return symbolTable.lookUp(name).getType();
    }




    @Override
    public DataType visitInitStmt(TheRealDealLangParser.InitStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = symbolTable.lookUp(name);
        if (symbol != null) {
            throw new CompilerException("Use of variable " + name + " Is already in use");
        }
        if (ctx.expr() != null) {
            String type = ctx.TYPE().getText().toUpperCase();
            for (int i = 0; i < ctx.expr().size(); i++) {
                DataType tp2 = visit(ctx.expr().get(i));
                if (!tp2.toString().equals(type)) {
                    throw new CompilerException("Incompatiple datatypes");
                }
            }
        }

        if (ctx.type.getText().equals("int")) {
            symbolTable.add(name, INT);
        } else if (ctx.type.getText().equals("Text")) {
            symbolTable.add(name, TEXT);
        } else if (ctx.type.getText().equals("boolean")) {
            symbolTable.add(name, BOOLEAN);
        } else if (ctx.type.getText().equals("double")) {
            symbolTable.add(name, DataType.DOUBLE);
        } else {
            throw new CompilerException("Incompatiple datatypes");
        }
        dataTypes.put(ctx, symbolTable.lookUp(name).getType());
        scope.put(ctx, symbolTable);
        return symbolTable.lookUp(name).getType();
    }

    @Override
    public DataType visitAddsubExpr(TheRealDealLangParser.AddsubExprContext ctx) {
        if (!visit(ctx.left).equals(visit(ctx.right))) {
            throw new CompilerException("Incompatible datatypes");
        }
        dataTypes.put(ctx, visit(ctx.left));
        scope.put(ctx, symbolTable);
        return visit(ctx.left);
    }

    @Override
    public DataType visitParensExpr(TheRealDealLangParser.ParensExprContext ctx) {
        return visit(ctx.expr());
    }


    @Override
    public DataType visitExMulExpr(TheRealDealLangParser.ExMulExprContext ctx) {
        DataType leftType = visit(ctx.left);
        DataType rightType = visit(ctx.right);
        if (leftType != rightType)
            throw new CompilerException("Left and right type are not the same!");
        dataTypes.put(ctx, visit(ctx.right));
        scope.put(ctx, symbolTable);
        return addType(ctx, leftType);
    }

    @Override
    public DataType visitPrintCallStatement(TheRealDealLangParser.PrintCallStatementContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public DataType visitBlock(TheRealDealLangParser.BlockContext ctx) {
        System.out.println("got hit3213213");
        scope.put(ctx, symbolTable);
        symbolTable = symbolTable.openScope();
        visitChildren(ctx);
        symbolTable = symbolTable.getParentScope();
        return null;

    }


    @Override
    public DataType visitScannerExpr(TheRealDealLangParser.ScannerExprContext ctx) {
        DataType dataType = extractDataType(ctx.SCANNER().getText());
        System.out.println(ctx.getText() + "kek123");
        dataTypes.put(ctx, dataType);
        symbolTable.add(ctx.SCANNER().getText(), dataType);
        scope.put(ctx, symbolTable);
        return visit(ctx.SCANNER());
    }

    @Override
    public DataType visitFunction_definition(TheRealDealLangParser.Function_definitionContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        DataType type = symbolTable.getTypeEnum(ctx.TYPE().getText());

        // Decorate the function name with argument types and return type. Do this prior to visiting the arguments
        // themselves as this will enter them in the symbol table of the new scope. Start with the arguments.
        name += '@';

        if (ctx.argument_list() != null) {
            for (ParseTree decl : ctx.argument_list().children) {

                // Skip the comma that separates argument declarations.+
                if (!(",".equals(decl.getText()))) {
                    System.out.println(symbolTable.getTypeLetter2(decl.getChild(0).getText()) + " groto");
                    name += symbolTable.getTypeLetter2(decl.getChild(0).getText());
                }
            }
        }
        System.out.println(name + "  name123 ");


        // Store the function name in the current scope.
        symbolTable.add(name, type);

        // Associate the this node with the current scope.
        scope.put(ctx,symbolTable);

        // Visit the arguments and body in the new scope and restore the current scope afterwards.
        symbolTable = symbolTable.openFunctionScope();
        visitChildren(ctx);
        symbolTable = symbolTable.closeScope();

        return type;
    }

    @Override
    public DataType visitFunction_call(TheRealDealLangParser.Function_callContext ctx) {
        String identifier = ctx.IDENTIFIER().getText();
        System.out.println(identifier+"id");
        // Decorate the function name with argument types and return type. Do this prior to visiting the arguments
        // themselves as this will enter them in the symbol table of the new scope. Start with the arguments
        String name = identifier + '@';

        if (ctx.expression_list() != null) {
            // Evaluate the arguments in the call first.
            visitChildren(ctx.expression_list());

            // Now that each of the expression types is known, check them against the function signature.
            for (ParseTree expr : ctx.expression_list().children) {
                // Skip the comma that separates expressions.
                if (!(",".equals(expr.getText()))) {
                    System.out.println(expr.getText() + " kek");
                    System.out.println(dataTypes.get(expr) + "SMEK");
                    System.out.println(symbolTable.getTypeLetter(dataTypes.get(expr))+" asdjkl");
                    name += symbolTable.getTypeLetter(dataTypes.get(expr));
                }
            }
        }

        Symbol symbol = symbolTable.lookUp(name);

        if (symbol == null) {
            String typeDescritors = name.substring(name.indexOf('@')+1);
            String message = "function " + identifier + "(";

            boolean firstArg = true;
            for(char c : typeDescritors.toCharArray()) {
                if (firstArg) {
                    firstArg = false;
                } else {
                    message += ',';
                }

                message += symbolTable.getTypeName(c);
            }

            message += ") is undefined.";
            throw new CompilerException(message);
        }

        scope.put(ctx, symbolTable);

        // If the name exists, then this also means that the types of the arguments are correct. Just return the type
        // of the function.
        return symbol.getType();

    }

    @Override
    public DataType visitFuncExpr(TheRealDealLangParser.FuncExprContext ctx) {
        String identifier = ctx.IDENTIFIER().getText();
        System.out.println(identifier+"ïd");
        // Decorate the function name with argument types and return type. Do this prior to visiting the arguments

        // themselves as this will enter them in the symbol table of the new scope. Start with the arguments
        String name = identifier + '@';

        if (ctx.expr() != null) {
            System.out.println(ctx.func.getText() + "func123");
            // Evaluate the arguments in the call first.
//            visitChildren(ctx.expression_list());
            // Now that each of the expression types is known, check them against the function signature.
            for (ParseTree expr : ctx.expr()) {

                System.out.println(expr.getChild(0) + "GERE");
                // Skip the comma that separates expressions.
                System.out.println(expr.getText() + "ek");
//                System.out.println(dataTypes.get(expr.getChild(0)) + "sas");
                System.out.println(symbolTable.getTypeLetter2(expr.getText())+ " asdio[p ");
//                    symbolTable.getTypeLetter2()
//                    name += symbolTable.getTypeLetter2(dataTypes.get(expr));

            }
        }

        Symbol symbol = symbolTable.lookUp(name);

        if (symbol == null) {
            String typeDescritors = name.substring(name.indexOf('@') + 1);
            String message = "function " + identifier + "(";

            boolean firstArg = true;
            for (char c : typeDescritors.toCharArray()) {
                if (firstArg) {
                    firstArg = false;
                } else {
                    message += ',';
                }

                message += symbolTable.getTypeName(c);
            }

            message += ") is undefined.";
            throw new CompilerException(message);
        }

        scope.put(ctx, symbolTable);

        // If the name exists, then this also means that the types of the arguments are correct. Just return the type
        // of the function.
        return symbol.getType();
    }

    @Override
    public DataType visitIfStatement(TheRealDealLangParser.IfStatementContext ctx) {
        System.out.println(ctx.condition().getText());
        for (int i = 0; i < ctx.condition().expr().size(); i++) {
            DataType type1 = visit(ctx.condition().expr(i));
            if (type1 != BOOLEAN) {
                throw new CompilerException("no type of boolean");
            }
        }

        if (ctx.falseBlock == null) {
            dataTypes.put(ctx, BOOLEAN);
            symbolTable.add("if", BOOLEAN);
            scope.put(ctx, symbolTable);
            return visit(ctx.condition());
        } else {
            DataType type2 = visit(ctx.falseBlock);
            if (type2 != BOOLEAN) {
                throw new CompilerException("no type of boolean");
            }
        }

        dataTypes.put(ctx.trueBlock, BOOLEAN);
        symbolTable.add("if", BOOLEAN);
        scope.put(ctx.trueBlock, symbolTable);


        dataTypes.put(ctx.falseBlock, BOOLEAN);
        symbolTable.add("else", BOOLEAN);
        scope.put(ctx.falseBlock, symbolTable);
        return null;
    }

    @Override
    public DataType visitExprStmt(TheRealDealLangParser.ExprStmtContext ctx) {
        return visit(ctx.expr());
    }

    private DataType addType(ParseTree node, DataType type) {
        dataTypes.put(node, type);
        return type;
    }

    public DataType extractDataType(String command) {
        String type = command.substring(4, (command.length() - 2));
        switch (type) {
            case "Int":
                return INT;
            case "Text":
                return TEXT;
            case "Boolean":
                return BOOLEAN;
            case "Double":
                return DOUBLE;
            default:
                throw new CompilerException("Incompatible datatypes");
        }
    }


    @Override
    public DataType visitWhileStmt(TheRealDealLangParser.WhileStmtContext ctx) {
        System.out.println(ctx.block() + "hey");
        System.out.println(visit(ctx.condition().expr(0)) + "typ[e123");
        for (int i = 0; i < ctx.condition().expr().size(); i++) {
            DataType type = visit(ctx.condition().expr(i));
            if (type != BOOLEAN) {
                throw new CompilerException("no type of boolean");
            }
        }
        visit(ctx.condition());
        visit(ctx.block());
        return null;
    }
}
