// Generated from D:/Prog/COS/Practical/Base/src\TheRealDealLang.g4 by ANTLR 4.8
package nl.saxion.cos;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ExampleLangVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class ExampleLangBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ExampleLangVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProgram(ExampleLangParser.ProgramContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStatement(ExampleLangParser.StatementContext ctx) { return visitChildren(ctx); }
}