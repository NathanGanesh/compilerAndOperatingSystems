// Generated from C:/Users/kimjongun/IdeaProjects/triok/src\TheRealDealLang.g4 by ANTLR 4.9.1
package nl.saxion.cos;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TheRealDealLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, MUL=3, ADD=4, SUB=5, BIGGER_THEN=6, SMALLER_THEN=7, EQUALS=8, 
		ASSIGN=9, NOT_EQUALS=10, DIVIDE=11, GREATER_THAN_AND_EQUAL=12, OR=13, 
		LOWER_THAN_AND_EQUAL=14, AND=15, COMMA=16, SEMICOLON=17, SCANNER=18, START_BLOCK=19, 
		END_BLOCK=20, PRINT=21, TRUE=22, FALSE=23, QUOTE=24, DOUBLE_SEP=25, VOID_KEYWORD=26, 
		TYPE=27, WHILE=28, IF_KEYWORD=29, ELSE_KEYWORD=30, INT_KEYWORD=31, DOUBLE_KEYWORD=32, 
		BOOLEAN_KEYWORD=33, TEXT_KEYWORD=34, RETURN_KEYWORD=35, IDENTIFIER=36, 
		INT=37, TEXT_VALUE=38, DOUBLE=39, LINE_COMMENT=40, WS=41;
	public static final int
		RULE_compileUnit = 0, RULE_statement = 1, RULE_block = 2, RULE_expr = 3, 
		RULE_condition = 4, RULE_function_definition = 5, RULE_argument_list = 6, 
		RULE_declaration = 7, RULE_expression_list = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "statement", "block", "expr", "condition", "function_definition", 
			"argument_list", "declaration", "expression_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'*'", "'+'", "'-'", "'>'", "'<'", "'=='", "'='", 
			"'!='", "'/'", "'>='", "'||'", "'<='", "'&&'", "','", "';'", null, "'{'", 
			"'}'", "'print'", "'true'", "'false'", "'\"'", "'.'", "'void'", null, 
			"'while'", "'if'", "'else'", "'int'", "'double'", "'boolean'", "'Text'", 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "MUL", "ADD", "SUB", "BIGGER_THEN", "SMALLER_THEN", 
			"EQUALS", "ASSIGN", "NOT_EQUALS", "DIVIDE", "GREATER_THAN_AND_EQUAL", 
			"OR", "LOWER_THAN_AND_EQUAL", "AND", "COMMA", "SEMICOLON", "SCANNER", 
			"START_BLOCK", "END_BLOCK", "PRINT", "TRUE", "FALSE", "QUOTE", "DOUBLE_SEP", 
			"VOID_KEYWORD", "TYPE", "WHILE", "IF_KEYWORD", "ELSE_KEYWORD", "INT_KEYWORD", 
			"DOUBLE_KEYWORD", "BOOLEAN_KEYWORD", "TEXT_KEYWORD", "RETURN_KEYWORD", 
			"IDENTIFIER", "INT", "TEXT_VALUE", "DOUBLE", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TheRealDealLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TheRealDealLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompileUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TheRealDealLangParser.EOF, 0); }
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitCompileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << START_BLOCK) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << TYPE) | (1L << WHILE) | (1L << IF_KEYWORD) | (1L << RETURN_KEYWORD) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
				{
				setState(20);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(18);
					function_definition();
					}
					break;
				case 2:
					{
					setState(19);
					statement();
					}
					break;
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprStmtContext extends StatementContext {
		public ExprContext stmtExpr;
		public TerminalNode SEMICOLON() { return getToken(TheRealDealLangParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(TheRealDealLangParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignVarStmtContext extends StatementContext {
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(TheRealDealLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(TheRealDealLangParser.SEMICOLON, 0); }
		public AssignVarStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitAssignVarStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmtContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InitStmtContext extends StatementContext {
		public Token type;
		public Token name;
		public TerminalNode SEMICOLON() { return getToken(TheRealDealLangParser.SEMICOLON, 0); }
		public TerminalNode TYPE() { return getToken(TheRealDealLangParser.TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(TheRealDealLangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(TheRealDealLangParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public InitStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitInitStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintCallStatementContext extends StatementContext {
		public TerminalNode PRINT() { return getToken(TheRealDealLangParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(TheRealDealLangParser.SEMICOLON, 0); }
		public PrintCallStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitPrintCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode RETURN_KEYWORD() { return getToken(TheRealDealLangParser.RETURN_KEYWORD, 0); }
		public TerminalNode SEMICOLON() { return getToken(TheRealDealLangParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public ConditionContext ifCondition;
		public BlockContext trueBlock;
		public BlockContext falseBlock;
		public TerminalNode IF_KEYWORD() { return getToken(TheRealDealLangParser.IF_KEYWORD, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE_KEYWORD() { return getToken(TheRealDealLangParser.ELSE_KEYWORD, 0); }
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclStmtContext extends StatementContext {
		public Token type;
		public Token name;
		public TerminalNode SEMICOLON() { return getToken(TheRealDealLangParser.SEMICOLON, 0); }
		public TerminalNode TYPE() { return getToken(TheRealDealLangParser.TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public VarDeclStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitVarDeclStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				block();
				}
				break;
			case 2:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				((VarDeclStmtContext)_localctx).type = match(TYPE);
				setState(29);
				((VarDeclStmtContext)_localctx).name = match(IDENTIFIER);
				setState(30);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new InitStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				((InitStmtContext)_localctx).type = match(TYPE);
				setState(32);
				((InitStmtContext)_localctx).name = match(IDENTIFIER);
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(33);
						match(ASSIGN);
						setState(34);
						expr(0);
						}
						} 
					}
					setState(39);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(40);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				match(IDENTIFIER);
				setState(42);
				match(ASSIGN);
				setState(43);
				expr(0);
				setState(44);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new PrintCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				match(PRINT);
				setState(47);
				match(T__0);
				setState(48);
				expr(0);
				setState(49);
				match(T__1);
				setState(50);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				match(RETURN_KEYWORD);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
					{
					setState(53);
					expr(0);
					}
				}

				setState(56);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(57);
				match(IF_KEYWORD);
				setState(58);
				((IfStatementContext)_localctx).ifCondition = condition();
				setState(59);
				((IfStatementContext)_localctx).trueBlock = block();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_KEYWORD) {
					{
					setState(60);
					match(ELSE_KEYWORD);
					setState(61);
					((IfStatementContext)_localctx).falseBlock = block();
					}
				}

				}
				break;
			case 8:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(64);
				match(WHILE);
				setState(65);
				condition();
				setState(66);
				block();
				}
				break;
			case 9:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(68);
				((ExprStmtContext)_localctx).stmtExpr = expr(0);
				setState(69);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode START_BLOCK() { return getToken(TheRealDealLangParser.START_BLOCK, 0); }
		public TerminalNode END_BLOCK() { return getToken(TheRealDealLangParser.END_BLOCK, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(START_BLOCK);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << START_BLOCK) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << TYPE) | (1L << WHILE) | (1L << IF_KEYWORD) | (1L << RETURN_KEYWORD) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
				{
				{
				setState(74);
				statement();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(END_BLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExMulExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(TheRealDealLangParser.MUL, 0); }
		public TerminalNode DIVIDE() { return getToken(TheRealDealLangParser.DIVIDE, 0); }
		public ExMulExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitExMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleExprContext extends ExprContext {
		public Token value;
		public TerminalNode DOUBLE() { return getToken(TheRealDealLangParser.DOUBLE, 0); }
		public DoubleExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitDoubleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public Token value;
		public TerminalNode INT() { return getToken(TheRealDealLangParser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextExprContext extends ExprContext {
		public TerminalNode TEXT_VALUE() { return getToken(TheRealDealLangParser.TEXT_VALUE, 0); }
		public TextExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitTextExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprContext extends ExprContext {
		public Token value;
		public TerminalNode TRUE() { return getToken(TheRealDealLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TheRealDealLangParser.FALSE, 0); }
		public BooleanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(TheRealDealLangParser.AND, 0); }
		public TerminalNode OR() { return getToken(TheRealDealLangParser.OR, 0); }
		public LogicalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitLogicalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddsubExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(TheRealDealLangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(TheRealDealLangParser.SUB, 0); }
		public AddsubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitAddsubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExprContext extends ExprContext {
		public Token value;
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public VariableExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitVariableExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScannerExprContext extends ExprContext {
		public TerminalNode SCANNER() { return getToken(TheRealDealLangParser.SCANNER, 0); }
		public ScannerExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitScannerExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExprContext extends ExprContext {
		public ExprContext left;
		public Token cpr;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BIGGER_THEN() { return getToken(TheRealDealLangParser.BIGGER_THEN, 0); }
		public TerminalNode GREATER_THAN_AND_EQUAL() { return getToken(TheRealDealLangParser.GREATER_THAN_AND_EQUAL, 0); }
		public TerminalNode SMALLER_THEN() { return getToken(TheRealDealLangParser.SMALLER_THEN, 0); }
		public TerminalNode LOWER_THAN_AND_EQUAL() { return getToken(TheRealDealLangParser.LOWER_THAN_AND_EQUAL, 0); }
		public CompareExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualExprContext extends ExprContext {
		public ExprContext left;
		public Token cpr;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT_EQUALS() { return getToken(TheRealDealLangParser.NOT_EQUALS, 0); }
		public TerminalNode EQUALS() { return getToken(TheRealDealLangParser.EQUALS, 0); }
		public EqualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(83);
				((IntExprContext)_localctx).value = match(INT);
				}
				break;
			case 2:
				{
				_localctx = new DoubleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				((DoubleExprContext)_localctx).value = match(DOUBLE);
				}
				break;
			case 3:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				((BooleanExprContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
					((BooleanExprContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new VariableExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				((VariableExprContext)_localctx).value = match(IDENTIFIER);
				}
				break;
			case 5:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(IDENTIFIER);
				setState(88);
				match(T__0);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
					{
					setState(89);
					expression_list();
					}
				}

				setState(92);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new TextExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(TEXT_VALUE);
				}
				break;
			case 7:
				{
				_localctx = new ScannerExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(SCANNER);
				}
				break;
			case 8:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(T__0);
				setState(96);
				expr(0);
				setState(97);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExMulExprContext(new ExprContext(_parentctx, _parentState));
						((ExMulExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(102);
						((ExMulExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIVIDE) ) {
							((ExMulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						((ExMulExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new AddsubExprContext(new ExprContext(_parentctx, _parentState));
						((AddsubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(105);
						((AddsubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddsubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						((AddsubExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(108);
						((CompareExprContext)_localctx).cpr = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGGER_THEN) | (1L << SMALLER_THEN) | (1L << GREATER_THAN_AND_EQUAL) | (1L << LOWER_THAN_AND_EQUAL))) != 0)) ) {
							((CompareExprContext)_localctx).cpr = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						((CompareExprContext)_localctx).right = expr(8);
						}
						break;
					case 4:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(111);
						((EqualExprContext)_localctx).cpr = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOT_EQUALS) ) {
							((EqualExprContext)_localctx).cpr = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						((EqualExprContext)_localctx).right = expr(7);
						}
						break;
					case 5:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(114);
						((LogicalExprContext)_localctx).op = match(AND);
						setState(115);
						((LogicalExprContext)_localctx).right = expr(6);
						}
						break;
					case 6:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(117);
						((LogicalExprContext)_localctx).op = match(OR);
						setState(118);
						((LogicalExprContext)_localctx).right = expr(5);
						}
						break;
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__0);
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				expr(0);
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0) );
			setState(130);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(TheRealDealLangParser.TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(TYPE);
			setState(133);
			match(IDENTIFIER);
			setState(134);
			match(T__0);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(135);
				argument_list();
				}
			}

			setState(138);
			match(T__1);
			setState(139);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Argument_listContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TheRealDealLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TheRealDealLangParser.COMMA, i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitArgument_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			declaration();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(142);
				match(COMMA);
				setState(143);
				declaration();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(TheRealDealLangParser.TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(TYPE);
			setState(150);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expression_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TheRealDealLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TheRealDealLangParser.COMMA, i);
		}
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitExpression_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			expr(0);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(153);
				match(COMMA);
				setState(154);
				expr(0);
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\3&\n\3\f\3\16\3)\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3J\n\3\3\4\3\4\7\4N\n\4\f\4\16\4Q\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5f\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7"+
		"\5z\n\5\f\5\16\5}\13\5\3\6\3\6\6\6\u0081\n\6\r\6\16\6\u0082\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\5\7\u008b\n\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b\u0093\n\b\f\b"+
		"\16\b\u0096\13\b\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u009e\n\n\f\n\16\n\u00a1"+
		"\13\n\3\n\3\'\3\b\13\2\4\6\b\n\f\16\20\22\2\7\3\2\30\31\4\2\5\5\r\r\3"+
		"\2\6\7\5\2\b\t\16\16\20\20\4\2\n\n\f\f\2\u00b9\2\30\3\2\2\2\4I\3\2\2\2"+
		"\6K\3\2\2\2\be\3\2\2\2\n~\3\2\2\2\f\u0086\3\2\2\2\16\u008f\3\2\2\2\20"+
		"\u0097\3\2\2\2\22\u009a\3\2\2\2\24\27\5\f\7\2\25\27\5\4\3\2\26\24\3\2"+
		"\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2"+
		"\2\2\32\30\3\2\2\2\33\34\7\2\2\3\34\3\3\2\2\2\35J\5\6\4\2\36\37\7\35\2"+
		"\2\37 \7&\2\2 J\7\23\2\2!\"\7\35\2\2\"\'\7&\2\2#$\7\13\2\2$&\5\b\5\2%"+
		"#\3\2\2\2&)\3\2\2\2\'(\3\2\2\2\'%\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*J\7\23"+
		"\2\2+,\7&\2\2,-\7\13\2\2-.\5\b\5\2./\7\23\2\2/J\3\2\2\2\60\61\7\27\2\2"+
		"\61\62\7\3\2\2\62\63\5\b\5\2\63\64\7\4\2\2\64\65\7\23\2\2\65J\3\2\2\2"+
		"\668\7%\2\2\679\5\b\5\28\67\3\2\2\289\3\2\2\29:\3\2\2\2:J\7\23\2\2;<\7"+
		"\37\2\2<=\5\n\6\2=@\5\6\4\2>?\7 \2\2?A\5\6\4\2@>\3\2\2\2@A\3\2\2\2AJ\3"+
		"\2\2\2BC\7\36\2\2CD\5\n\6\2DE\5\6\4\2EJ\3\2\2\2FG\5\b\5\2GH\7\23\2\2H"+
		"J\3\2\2\2I\35\3\2\2\2I\36\3\2\2\2I!\3\2\2\2I+\3\2\2\2I\60\3\2\2\2I\66"+
		"\3\2\2\2I;\3\2\2\2IB\3\2\2\2IF\3\2\2\2J\5\3\2\2\2KO\7\25\2\2LN\5\4\3\2"+
		"ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\26\2"+
		"\2S\7\3\2\2\2TU\b\5\1\2Uf\7\'\2\2Vf\7)\2\2Wf\t\2\2\2Xf\7&\2\2YZ\7&\2\2"+
		"Z\\\7\3\2\2[]\5\22\n\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^f\7\4\2\2_f\7("+
		"\2\2`f\7\24\2\2ab\7\3\2\2bc\5\b\5\2cd\7\4\2\2df\3\2\2\2eT\3\2\2\2eV\3"+
		"\2\2\2eW\3\2\2\2eX\3\2\2\2eY\3\2\2\2e_\3\2\2\2e`\3\2\2\2ea\3\2\2\2f{\3"+
		"\2\2\2gh\f\13\2\2hi\t\3\2\2iz\5\b\5\fjk\f\n\2\2kl\t\4\2\2lz\5\b\5\13m"+
		"n\f\t\2\2no\t\5\2\2oz\5\b\5\npq\f\b\2\2qr\t\6\2\2rz\5\b\5\tst\f\7\2\2"+
		"tu\7\21\2\2uz\5\b\5\bvw\f\6\2\2wx\7\17\2\2xz\5\b\5\7yg\3\2\2\2yj\3\2\2"+
		"\2ym\3\2\2\2yp\3\2\2\2ys\3\2\2\2yv\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2"+
		"\2|\t\3\2\2\2}{\3\2\2\2~\u0080\7\3\2\2\177\u0081\5\b\5\2\u0080\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\7\4\2\2\u0085\13\3\2\2\2\u0086\u0087\7\35\2"+
		"\2\u0087\u0088\7&\2\2\u0088\u008a\7\3\2\2\u0089\u008b\5\16\b\2\u008a\u0089"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\4\2\2\u008d"+
		"\u008e\5\6\4\2\u008e\r\3\2\2\2\u008f\u0094\5\20\t\2\u0090\u0091\7\22\2"+
		"\2\u0091\u0093\5\20\t\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\17\3\2\2\2\u0096\u0094\3\2\2"+
		"\2\u0097\u0098\7\35\2\2\u0098\u0099\7&\2\2\u0099\21\3\2\2\2\u009a\u009f"+
		"\5\b\5\2\u009b\u009c\7\22\2\2\u009c\u009e\5\b\5\2\u009d\u009b\3\2\2\2"+
		"\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\23"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\21\26\30\'8@IO\\ey{\u0082\u008a\u0094\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}