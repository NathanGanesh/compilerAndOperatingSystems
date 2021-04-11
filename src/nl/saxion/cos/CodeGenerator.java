package nl.saxion.cos;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class CodeGenerator extends TheRealDealLangBaseVisitor<Void> {

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
//
//    @Override
//    public Void visitFunction_definition(TheRealDealLangParser.Function_definitionContext ctx) {
//        sym
//
//        jasminCode.add(".method public static " + ctx.IDENTIFIER().getText() + "(" +
//                getArgumentSequence() + ")" + getTypeDescriptor(getDataType()))
//                .add(".limit stack 99")
//                .add(".limit locals 99");
//
//        visitChildren(ctx.argument_list());
//        return null;
//    }

    @Override
    public Void visitFuncExpr(TheRealDealLangParser.FuncExprContext ctx) {
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
    public Void visitAssignVarStmt(TheRealDealLangParser.AssignVarStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = scope.get(ctx).lookUp(name);
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
        //visit any expressions before storing anything
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

    @Override
    public Void visitVarDeclStmt(TheRealDealLangParser.VarDeclStmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Symbol symbol = scope.get(ctx).lookUp(name);

        switch (types.get(ctx)) {
            case INT:
                jasminCode.add("ldc 0");
                jasminCode.add("istore " + symbol.getLocalSlot());
                break;
            case DOUBLE:
                jasminCode.add("ldc2_w 0.00");
                jasminCode.add("dstore " + symbol.getLocalSlot());
                break;
            case BOOLEAN:
                jasminCode.add("iconst_0");
                jasminCode.add("istore " + symbol.getLocalSlot());
                break;
            case TEXT:
                jasminCode.add("ldc empty");
                jasminCode.add("astore " + symbol.getLocalSlot());
                break;
            default:
                throw new CompilerException("Unknown type in print");
        }
//        if ((ctx.expr()) != null) {
//            return visit(ctx.expr());
//        }
//        visit(ctx.expr());
        return null;
    }

    @Override
    public Void visitScannerExpr(TheRealDealLangParser.ScannerExprContext ctx) {
        //scanner symbol
        String scannerText = ctx.SCANNER().getText();
        Symbol symbol = scope.get(ctx).lookUp(scannerText);
    //if scanner doesnt exist add a scanner isnt scoped.
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

        visit(ctx.condition());

        jasminCode.add("ifne " + trueLabel);

        if (ctx.falseBlock != null) {
            visit(ctx.falseBlock);
        }

        jasminCode.add("goto " + falseLabel);
        jasminCode.add(trueLabel + ":");
        visit(ctx.trueBlock);
        jasminCode.add(falseLabel + ":");

        return null;
    }

    @Override
    public Void visitWhileStmt(TheRealDealLangParser.WhileStmtContext ctx) {
        String endLabel = "end" + ctx.hashCode();
        jasminCode.add("begin:");
        for (int i = 0; i < ctx.condition().expr().size(); i++) {
            visit(ctx.condition().expr(i));
        }
        jasminCode.add("iconst_1");
        jasminCode.add("if_icmpne " + endLabel);
        for (int i = 0; i < ctx.block().statement().size(); i++) {
            visit(ctx.block().statement(i));
        }
        jasminCode.add("goto begin");
        jasminCode.add(endLabel + ":");
        return null;
    }


    @Override
    public Void visitCompareExpr(TheRealDealLangParser.CompareExprContext ctx) {
        visit(ctx.left);
        visit(ctx.right);
        String stopLabel = "stopLabel_" + ctx.hashCode();
        String trueLabel = "trueLabel_" + ctx.hashCode();
        final String comparison = ctx.cpr.getText();

        if (types.get(ctx.left) == DataType.DOUBLE) {
            boolean lessThan = comparison.equals("<");
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
            jasminCode.add("dcmp" + (equals ? "g" : "l"));
            jasminCode.add("if" + (equals ? "le " : "gt ") + trueLabel);
        } else {
            String a = types.get(ctx.left) == DataType.INT ? "i" : "a";
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
