// Generated from C:/Users/kimjongun/IdeaProjects/triok/src\TheRealDealLang.g4 by ANTLR 4.9.1
package nl.saxion.cos;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TheRealDealLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TheRealDealLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TheRealDealLangParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(TheRealDealLangParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(TheRealDealLangParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStmt(TheRealDealLangParser.VarDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initStmt}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitStmt(TheRealDealLangParser.InitStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignVarStmt}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVarStmt(TheRealDealLangParser.AssignVarStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printCallStatement}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintCallStatement(TheRealDealLangParser.PrintCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(TheRealDealLangParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(TheRealDealLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(TheRealDealLangParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link TheRealDealLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(TheRealDealLangParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheRealDealLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(TheRealDealLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exMulExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExMulExpr(TheRealDealLangParser.ExMulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleExpr(TheRealDealLangParser.DoubleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(TheRealDealLangParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(TheRealDealLangParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextExpr(TheRealDealLangParser.TextExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(TheRealDealLangParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpr(TheRealDealLangParser.LogicalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addsubExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddsubExpr(TheRealDealLangParser.AddsubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(TheRealDealLangParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(TheRealDealLangParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scannerExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScannerExpr(TheRealDealLangParser.ScannerExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(TheRealDealLangParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link TheRealDealLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(TheRealDealLangParser.EqualExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheRealDealLangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(TheRealDealLangParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheRealDealLangParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(TheRealDealLangParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheRealDealLangParser#argument_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_list(TheRealDealLangParser.Argument_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheRealDealLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(TheRealDealLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TheRealDealLangParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(TheRealDealLangParser.Expression_listContext ctx);
}