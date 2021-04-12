package nl.saxion.cos;

import static nl.saxion.cos.DataType.getFunctionDescriptor;

public class FunctionVisitor extends TheRealDealLangBaseVisitor<Void> {

    private final JasminBytecode jasminBytecode;

    public FunctionVisitor(JasminBytecode jasminBytecode) {
        this.jasminBytecode = jasminBytecode;
    }

    @Override
    public Void visitFunction_definition(TheRealDealLangParser.Function_definitionContext ctx) {
        StringBuilder arguments = new StringBuilder();

        for (int i = 0; i < ctx.argument_list().declaration().size(); i++) {
            arguments.append(getFunctionDescriptor(ctx.argument_list().declaration().get(i).TYPE().getText()));
        }

        jasminBytecode.add(".method public static " + ctx.IDENTIFIER().getText() +
                "(" + arguments + ")" + getFunctionDescriptor(ctx.TYPE().getText()));
        jasminBytecode.add(".limit stack 99");
        jasminBytecode.add(".limit locals 99");

        visit(ctx.block());

        jasminBytecode.add(DataType.getFunctionReturn(ctx.TYPE().getText()) + "return");
        jasminBytecode.add(".end method");
        return null;
    }
}
