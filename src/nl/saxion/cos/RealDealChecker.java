package nl.saxion.cos;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import javax.xml.crypto.Data;

import static nl.saxion.cos.DataType.*;

public class RealDealChecker extends TheRealDealLangBaseVisitor<DataType> {

    private final ParseTreeProperty<DataType> dataTypes;
    private final ParseTreeProperty<SymbolTable> scope;
    private boolean failed = false;
    private SymbolTable symbolTable;

    public RealDealChecker(ParseTreeProperty<DataType> dataTypes, SymbolTable symbolTable, ParseTreeProperty<SymbolTable> scope) {
        this.dataTypes = dataTypes;
        this.symbolTable = symbolTable;
        this.scope = scope;
    }

    public boolean isFailed() {
        return failed;
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
        dataTypes.put(ctx, symbol.getType());
        scope.put(ctx, symbolTable);
        return symbol.getType();
    }


    @Override
    public DataType visitAssignVarStmt(TheRealDealLangParser.AssignVarStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = symbolTable.lookUp(name);
        switch (ctx.expr().getText()) {
            case "scanInt()":
                if (symbol.getType() != INT) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                visit(ctx.expr());
                break;
            case "scanText()":
                if (symbol.getType() != TEXT) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                visit(ctx.expr());
                break;
            case "scanBoolean()":
                if (symbol.getType() != BOOLEAN) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                visit(ctx.expr());
                break;
            case "scanDouble()":
                if (symbol.getType() != DataType.DOUBLE) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                visit(ctx.expr());
                break;
            default:
                if (!symbol.getType().equals(visit(ctx.expr()))) {
                    throw new CompilerException("Incompatiple datatypes");
                }
                visit(ctx.expr());
                break;
        }
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
        System.out.println(leftType);
        if (!(leftType == DataType.DOUBLE || leftType == INT)) {
            throw new CompilerException("Not double or int");
        }
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

        switch (ctx.type.getText()) {
            case "int":
                symbolTable.add(name, INT);
                break;
            case "Text":
                symbolTable.add(name, TEXT);
                break;
            case "boolean":
                symbolTable.add(name, BOOLEAN);
                break;
            case "double":
                symbolTable.add(name, DataType.DOUBLE);
                break;
            default:
                throw new CompilerException("Incompatiple datatypes");
        }
        System.out.println(ctx.getText() + "got added");
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
        //check if datatypes are the same on the lefts and right side
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
        scope.put(ctx, symbolTable);
        symbolTable = symbolTable.openScope();
        visitChildren(ctx);
        symbolTable = symbolTable.getParentScope();
        return null;
    }


    @Override
    public DataType visitScannerExpr(TheRealDealLangParser.ScannerExprContext ctx) {
        DataType dataType = extractDataType(ctx.SCANNER().getText());
        dataTypes.put(ctx, dataType);
        symbolTable.add(ctx.SCANNER().getText(), dataType);
        scope.put(ctx, symbolTable);
        return dataType;
    }

    @Override
    public DataType visitDeclaration(TheRealDealLangParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public DataType visitFunction_definition(TheRealDealLangParser.Function_definitionContext ctx) {
        StringBuilder name = new StringBuilder(ctx.IDENTIFIER().getText());
        DataType type = symbolTable.getTypeEnum(ctx.TYPE().getText());

        // Decorate the function name with argument types and return type. Do this prior to visiting the arguments
        // themselves as this will enter them in the symbol table of the new scope. Start with the arguments.
        name.append('@');

        if (ctx.argument_list() != null) {
            for (ParseTree decl : ctx.argument_list().children) {
                // Skip the comma that separates argument declarations.+
                if (!(",".equals(decl.getText()))) {
                    name.append(symbolTable.getTypeLetter2(decl.getChild(0).getText()));
//                    System.out.println(symbolTable.getTypeEnum(decl.getChild(0).getText()) + " kl;sdf");
//                    System.out.println(decl.getText() + " asdhjk");
                    System.out.println(symbolTable.getTypeEnum(decl.getChild(0).getText())+ " jkl;");
                    DataType datatype = symbolTable.getTypeEnum(decl.getChild(0).getText());
                    symbolTable.add(decl.getText(), datatype);

                    dataTypes.put(decl, datatype);
                    scope.put(decl, symbolTable);
                }
            }
        }

        System.out.println("name:" + name);

        // Store the function name in the current scope.
        symbolTable.addGlobal(name.toString(), type);

        // Associate the this node with the current scope.
        scope.put(ctx, symbolTable);

        // Visit the arguments and body in the new scope and restore the current scope afterwards.
        symbolTable = symbolTable.openFunctionScope();

        visitChildren(ctx);
        symbolTable = symbolTable.closeScope();

        return type;
    }

    /**Copy pasted from seminars
     * @param ctx
     * @return
     */
    @Override
    public DataType visitFuncExpr(TheRealDealLangParser.FuncExprContext ctx) {
        String identifier = ctx.IDENTIFIER().getText();
        // Decorate the function name with argument types and return type. Do this prior to visiting the arguments
        // themselves as this will enter them in the symbol table of the new scope. Start with the arguments
        StringBuilder name = new StringBuilder(identifier + '@');

        if (ctx.expression_list() != null) {
            // Evaluate the arguments in the call first.
            visitChildren(ctx.expression_list());

            // Now that each of the expression types is known, check them against the function signature.
            for (ParseTree expr : ctx.expression_list().children) {
                System.out.println(expr);
                // Skip the comma that separates expressions.
                if (!(",".equals(expr.getText()))) {
                    name.append(symbolTable.getTypeLetter(dataTypes.get(expr)));
                }
            }
        }

        System.out.println("name2: " + name);
        Symbol symbol = symbolTable.lookUp(name.toString());

        System.out.println(symbolTable.toString());
        if (symbol == null) {
            String typeDescritors = name.substring(name.toString().indexOf('@') + 1);
            StringBuilder message = new StringBuilder("function " + identifier + "(");

            boolean firstArg = true;
            for (char c : typeDescritors.toCharArray()) {
                if (firstArg) {
                    firstArg = false;
                } else {
                    message.append(',');
                }
                message.append(symbolTable.getTypeName(c));
            }

            message.append(") is undefined.");
            throw new CompilerException(message.toString());
        }

        scope.put(ctx, symbolTable);

        // If the name exists, then this also means that the types of the arguments are correct. Just return the type
        // of the function.
        return symbol.getType();
    }

    @Override
    public DataType visitIfStatement(TheRealDealLangParser.IfStatementContext ctx) {
        //check if everything is boolean
        for (int i = 0; i < ctx.condition().expr().size(); i++) {
            DataType type = visit(ctx.condition().expr(i));
            if (type != BOOLEAN) {
                throw new CompilerException("no type of boolean");
            }
        }
        //if only statement
        if (ctx.falseBlock == null) {
            visit(ctx.trueBlock);
            scope.put(ctx, symbolTable);
        } else {
            //else statement and if statement
            visit(ctx.trueBlock);
            visit(ctx.falseBlock);
            dataTypes.put(ctx.trueBlock, BOOLEAN);
            scope.put(ctx.trueBlock, symbolTable);

            dataTypes.put(ctx.falseBlock, BOOLEAN);
            scope.put(ctx.falseBlock, symbolTable);
        }
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

    /**
     * Removes the scan
     *
     * @param command The scanner to get the dataype of
     * @return the datatype of the scanner.
     */
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
        //check if all the conditions are boolean
        for (int i = 0; i < ctx.condition().expr().size(); i++) {
            DataType type = visit(ctx.condition().expr(i));
            if (type != BOOLEAN) {
                throw new CompilerException("no type of boolean");
            }
        }
        //visit the condition and the block
        visit(ctx.condition());
        visit(ctx.block());
        return null;
    }
}
