package nl.saxion.cos;

import nl.saxion.cos.exception.CompilerException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;


import static nl.saxion.cos.DataType.*;

public class CodeGenerator extends TheRealDealLangBaseVisitor<Void> {

    final String className = "prog";
    private final JasminBytecode jasminCode;
    private final ParseTreeProperty<SymbolTable> scope;
    boolean isScanInit = false;
    private ParseTreeProperty<DataType> types;
    private boolean scanInit;

    /**
     * Constructs a code generator.
     *
     * @param scope
     * @param types A map containing the data types of certain nodes in the
     *              parse tree.
     */
    public CodeGenerator(JasminBytecode jasminCode,
                         ParseTreeProperty<SymbolTable> scope, ParseTreeProperty<DataType> types) {
        this.jasminCode = jasminCode;
        this.types = types;
        this.scope = scope;
    }

    @Override
    public Void visitCompileUnit(TheRealDealLangParser.CompileUnitContext ctx) {
        // Visit the function declaration nodes first
        ctx.function_definition().forEach(this::visit);

        // Generate the bytecode for the main method
        jasminCode.add(".method public static main([Ljava/lang/String;)V");
        jasminCode.add(".limit stack 99");
        jasminCode.add(".limit locals 99");

        ctx.statement().forEach(this::visit);
        return null;
    }

    @Override
    public Void visitIntExpr(TheRealDealLangParser.IntExprContext ctx) {
        jasminCode.add("ldc " + Integer.parseInt(ctx.INT().getText()));
        return null;
    }

    @Override
    public Void visitDoubleExpr(TheRealDealLangParser.DoubleExprContext ctx) {
        jasminCode.add("ldc2_w " + Double.parseDouble(ctx.DOUBLE().getText()));
        return null;
    }

    @Override
    public Void visitTextExpr(TheRealDealLangParser.TextExprContext ctx) {
        jasminCode.add("ldc " + ctx.TEXT_VALUE().getText());
        return null;
    }

    @Override
    public Void visitBooleanExpr(TheRealDealLangParser.BooleanExprContext ctx) {
        if (ctx.value.getType() == TheRealDealLangLexer.TRUE) {
            jasminCode.add("iconst_1");
        } else {
            jasminCode.add("iconst_0");
        }
        return null;
    }

    @Override
    public Void visitExMulExpr(TheRealDealLangParser.ExMulExprContext ctx) {
        boolean ifDouble = false;
        visit(ctx.left);
        visit(ctx.right);
        //check if double
        if (types.get(ctx.left) == DataType.DOUBLE || types.get(ctx.right) == DataType.DOUBLE) {
            ifDouble = true;
        }
        switch (ctx.op.getType()) {
            case TheRealDealLangLexer.MUL:
                if (ifDouble) {
                    jasminCode.add("dmul");
                    break;
                } else {
                    jasminCode.add("imul");
                    break;
                }
            case TheRealDealLangLexer.DIVIDE:
                if (ifDouble) {
                    jasminCode.add("ddiv");
                    break;
                } else {
                    jasminCode.add("idiv");
                    break;
                }
            default:
                return null;
        }
        return null;
    }

    @Override
    public Void visitFunction_definition(TheRealDealLangParser.Function_definitionContext ctx) {
        StringBuilder arguments = new StringBuilder();
        //get all function statements
        for (int i = 0; i < ctx.argument_list().declaration().size(); i++) {
            arguments.append(getFunctionDescriptor(ctx.argument_list().declaration().get(i).TYPE().getText()));
        }
        jasminCode.add(".method public static " + ctx.IDENTIFIER().getText() +
                "(" + arguments + ")" + getFunctionDescriptor(ctx.TYPE().getText()));
        jasminCode.add(".limit stack 99");
        jasminCode.add(".limit locals 99");

        visit(ctx.function_body());

        jasminCode.add(DataType.getFunctionReturn(ctx.TYPE().getText()) + "return");
        jasminCode.add(".end method");
        jasminCode.add("");
        return null;
    }

    @Override
    public Void visitAddsubExpr(TheRealDealLangParser.AddsubExprContext ctx) {
        boolean ifDouble = false;
        visit(ctx.left);
        visit(ctx.right);
        //check if double
        if (types.get(ctx.left) == DataType.DOUBLE || types.get(ctx.right) == DataType.DOUBLE) {
            ifDouble = true;
        }
        switch (ctx.op.getType()) {
            case TheRealDealLangLexer.ADD:
                if (ifDouble) {
                    jasminCode.add("dadd");
                    break;
                } else {
                    jasminCode.add("iadd");
                    break;
                }
            case TheRealDealLangLexer.SUB:
                if (ifDouble) {
                    jasminCode.add("dsub");
                    break;
                } else {
                    jasminCode.add("isub");
                    break;
                }
            default:
                return null;
        }
        return null;
    }


    @Override
    public Void visitBlock(TheRealDealLangParser.BlockContext ctx) {
        for (int i = 0; i < ctx.statement().size(); i++) {
            visit(ctx.statement(i));
        }
        return null;
    }

    @Override
    public Void visitFuncExpr(TheRealDealLangParser.FuncExprContext ctx) {
        String name = ctx.IDENTIFIER().getText();

        StringBuilder arguments2 = new StringBuilder();
        StringBuilder arguments = new StringBuilder();


        for (ParseTree child : ctx.expression_list().children) {
            if (!(",".equals(child.getText()))) {
                arguments.append(getTypeLetter(types.get(child)));
                arguments2.append(getTypeLetter2(types.get(child)));
                System.out.println(child.getText() + " kek");
                visit(child);
            }
        }
        Symbol symbol = scope.get(ctx).lookUp(name + "@" + arguments);
        jasminCode.add("invokestatic " + className + "/" + name + "(" +
                arguments2 + ")" + getTypeLetter2(symbol.getType()));

        return null;
    }

    @Override
    public Void visitPrintCallStatement(TheRealDealLangParser.PrintCallStatementContext ctx) {
        jasminCode.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
        visit(ctx.expr());

        System.out.println(ctx.expr());
        switch (types.get(ctx.expr())) {
            case INT:
                jasminCode.add("invokevirtual java/io/PrintStream/println(I)V");
                break;
            case DOUBLE:
                jasminCode.add("invokevirtual java/io/PrintStream/println(D)V");
                break;
            case BOOLEAN:
                jasminCode.add("invokevirtual java/io/PrintStream/println(Z)V");
                break;
            case TEXT:
                jasminCode.add("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
                break;
            default:
                break;
        }
        return null;
    }

    @Override
    public Void visitReturnStmt(TheRealDealLangParser.ReturnStmtContext ctx) {
//        if (ctx.expr().isEmpty()){
//            return VOID
//        }

        System.out.println("git hit her");
        visit(ctx.expr());
        return null;
    }

    @Override
    public Void visitAssignVarStmt(TheRealDealLangParser.AssignVarStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = scope.get(ctx).lookUp(name);
        //should be lookuplocal when function
//        Symbol symbol = scope.get(ctx).lookUpLocal()k(name);
        //first visit any expression this is because an assignment could be an expression
        if ((ctx.expr()) != null) {
            visit(ctx.expr());
        }
        switch (types.get(ctx)) {
            case INT:
                jasminCode.add("istore " + symbol.getLocalSlot());
                break;
            case DOUBLE:
                jasminCode.add("dstore " + symbol.getLocalSlot());
                break;
            case BOOLEAN:
                jasminCode.add("istore " + symbol.getLocalSlot());
                break;
            case TEXT:
                jasminCode.add("astore " + symbol.getLocalSlot());
                break;
            default:
                throw new CompilerException("Unknown type in print");
        }

        return null;
    }

    @Override
    public Void visitInitStmt(TheRealDealLangParser.InitStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = scope.get(ctx).lookUp(name);
        //visit all the expresions of the init statement before storing it
        for (int i = 0; i < ctx.expr().size(); i++) {
            visit(ctx.expr().get(i));
        }
        switch (types.get(ctx)) {
            case INT:
                jasminCode.add("istore " + symbol.getLocalSlot());
                break;
            case DOUBLE:
                jasminCode.add("dstore " + symbol.getLocalSlot());
                break;
            case BOOLEAN:
                jasminCode.add("istore " + symbol.getLocalSlot());
                break;
            case TEXT:
                jasminCode.add("astore " + symbol.getLocalSlot());
                break;
            default:
                throw new CompilerException("Unknown type in print");
        }
        return null;
    }

//    @Override
//    public Void visitVarDeclStmt(TheRealDealLangParser.VarDeclStmtContext ctx) {
//        String name = ctx.IDENTIFIER().getText();
//        Symbol symbol = scope.get(ctx).lookUp(name);
//
//        switch (types.get(ctx)) {
//            case INT:
//                jasminCode.add("ldc 0");
//                jasminCode.add("istore " + symbol.getLocalSlot());
//                break;
//            case DOUBLE:
//                jasminCode.add("ldc2_w 0.00");
//                jasminCode.add("dstore " + symbol.getLocalSlot());
//                break;
//            case BOOLEAN:
//                jasminCode.add("iconst_0");
//                jasminCode.add("istore " + symbol.getLocalSlot());
//                break;
//            case TEXT:
//                jasminCode.add("ldc \"empty\"");
//                jasminCode.add("astore " + symbol.getLocalSlot());
//                break;
//            default:
//                throw new CompilerException("Unknown type in print");
//        }
////        if ((ctx.expr()) != null) {
////            return visit(ctx.expr());
////        }
////        visit(ctx.expr());
//        return null;
//    }

    @Override
    public Void visitScannerExpr(TheRealDealLangParser.ScannerExprContext ctx) {
        //scanner symbol
        String scannerText = ctx.SCANNER().getText();
        Symbol symbol = scope.get(ctx).lookUp(scannerText);
        //if scanner doesnt exist and a scanner isnt scoped add one.
        if (!scanInit) {
            jasminCode.add("new java/util/Scanner");
            jasminCode.add("dup");
            jasminCode.add("getstatic java/lang/System/in Ljava/io/InputStream;");
            jasminCode.add("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
            jasminCode.add("astore " + symbol.getLocalSlot());
            isScanInit = true;
        }
        jasminCode.add("aload " + symbol.getLocalSlot());
        switch (ctx.SCANNER().getText()) {
            case "scanInt()":
                jasminCode.add("invokevirtual java/util/Scanner/nextInt()I");
                break;
            case "scanText()":
                jasminCode.add("invokevirtual java/util/Scanner/next()Ljava/lang/String;");
                break;
            case "scanBoolean()":
                jasminCode.add("invokevirtual java/util/Scanner/nextBoolean()Z");
                break;
            case "scanDouble()":
                jasminCode.add("invokevirtual java/util/Scanner/nextDouble()D");
                break;
            default:
                throw new CompilerException("Unknown type in print");
        }
        return null;
    }

    @Override
    public Void visitIfStatement(TheRealDealLangParser.IfStatementContext ctx) {
        String trueLabel = "trueLabel" + ctx.hashCode();
        String falseLabel = "falseLabel" + ctx.hashCode();
        //visit if condition
        visit(ctx.condition());

        jasminCode.add("ifne " + trueLabel);

        //if there is an else statement visit it
        if (ctx.falseBlock != null) {
            visit(ctx.falseBlock);
        }

        jasminCode.add("goto " + falseLabel);
        jasminCode.add(trueLabel + ":");
        visit(ctx.trueBlock);
        jasminCode.add(falseLabel + ":");

        return null;
    }

//
//    @Override
//    public Void visitWhileStmt(TheRealDealLangParser.WhileStmtContext ctx) {
//        String endLabel = "end" + ctx.hashCode();
//        jasminCode.add("begin:");
//        //visit all conditions
//        for (int i = 0; i < ctx.condition().expr().size(); i++) {
//            visit(ctx.condition().expr(i));
//        }
//        jasminCode.add("iconst_1");
//        jasminCode.add("if_icmpne " + endLabel);
//        //vist all the statement inside the while
//        for (int i = 0; i < ctx.block().statement().size(); i++) {
//            visit(ctx.block().statement(i));
//        }
//        jasminCode.add("goto begin");
//        jasminCode.add(endLabel + ":");
//        return null;
//    }


    @Override
    public Void visitCompareExpr(TheRealDealLangParser.CompareExprContext ctx) {
        visit(ctx.left);
        visit(ctx.right);
        String stopLabel = "stopLabel_" + ctx.hashCode();
        String trueLabel = "trueLabel_" + ctx.hashCode();
        final String comparison = ctx.cpr.getText();

        if (types.get(ctx.left) == DataType.DOUBLE) {
            boolean lessThan = comparison.equals("<");
            //if true <
            // else >
            jasminCode.add("dcmp" + (lessThan ? "l" : "g"));
            jasminCode.add("if" + (lessThan ? "le " : "gt ") + trueLabel);
        } else if (types.get(ctx.left) == DataType.INT) {
            jasminCode.add("if_icmp" + (comparison.equals("<") ? "lt " : "gt ") + trueLabel);
        } else {
            throw new CompilerException("Unknown type in compare");
        }
        jasminCode.add("iconst_0");
        jasminCode.add("goto " + stopLabel);
        jasminCode.add(trueLabel + ":");
        jasminCode.add("iconst_1");
        jasminCode.add("goto " + stopLabel);
        jasminCode.add(stopLabel + ":");
        return null;
    }

    @Override
    public Void visitEqualExpr(TheRealDealLangParser.EqualExprContext ctx) {
        visit(ctx.left);
        visit(ctx.right);

        String trueLabel = "true" + ctx.hashCode();
        String endLabel = "end" + ctx.hashCode();

        final String comparison = ctx.cpr.getText();
        boolean equals = comparison.equals("==");
        if (types.get(ctx.left) == DataType.DOUBLE) {
            // if true ==
            // , else !=
            jasminCode.add("dcmp" + (equals ? "g" : "l"));
            jasminCode.add("if" + (equals ? "le " : "gt ") + trueLabel);
        } else {
            String a = types.get(ctx.left) == DataType.INT ? "i" : "a";
            // if true ==
            // , else !=
            jasminCode.add("if_" + a +
                    "cmp" + (comparison.equals("==") ? "eq " : "ne ") + trueLabel);
        }
        jasminCode.add("iconst_0");
        jasminCode.add("goto " + endLabel);
        jasminCode.add(trueLabel + ":");
        jasminCode.add("iconst_1");
        jasminCode.add("goto " + endLabel);
        jasminCode.add(endLabel + ":");
        return null;
    }

    @Override
    public Void visitLogicalExpr(TheRealDealLangParser.LogicalExprContext ctx) {
        visit(ctx.left);
        visit(ctx.right);

        String trueLabel = "true" + ctx.hashCode();
        String stopLabel = "stop" + ctx.hashCode();

        if (ctx.op.getText().equals("&&")) {
            jasminCode.add("iadd");
            jasminCode.add("iconst_2");
            jasminCode.add("if_icmpeq " + trueLabel);
            jasminCode.add("iconst_0");
        } else {
            //else ||
            jasminCode.add("iadd");
            jasminCode.add("ifne " + trueLabel);
            jasminCode.add("iconst_0");
        }
        jasminCode.add("goto " + stopLabel);
        jasminCode.add(trueLabel + ":");
        jasminCode.add("iconst_1");
        jasminCode.add(stopLabel + ":");
        return null;
    }


    @Override
    public Void visitVariableExpr(TheRealDealLangParser.VariableExprContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = scope.get(ctx).lookUp(name);
        switch (types.get(ctx)) {
            case INT:
                jasminCode.add("iload " + symbol.getLocalSlot());
                break;
            case DOUBLE:
                jasminCode.add("dload " + symbol.getLocalSlot());
                break;
            case TEXT:
                jasminCode.add("aload " + symbol.getLocalSlot());
                break;
            case BOOLEAN:
                jasminCode.add("iload " + symbol.getLocalSlot());
                break;
            default:
                throw new CompilerException("Unknown type in print");
        }
        return null;
    }


    @Override
    public Void visitParensExpr(TheRealDealLangParser.ParensExprContext ctx) {
        visit(ctx.expr());
        return null;
    }

    @Override
    public Void visitExprStmt(TheRealDealLangParser.ExprStmtContext ctx) {
        visit(ctx.expr());
        return null;
    }

}
