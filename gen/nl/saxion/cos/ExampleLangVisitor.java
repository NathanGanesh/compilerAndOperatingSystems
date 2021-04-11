// Generated from D:/Prog/COS/Practical/Base/src\TheRealDealLang.g4 by ANTLR 4.8
package nl.saxion.cos;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExampleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExampleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExampleLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExampleLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExampleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ExampleLangParser.StatementContext ctx);
}