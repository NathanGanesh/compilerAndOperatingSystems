// Generated from C:/Users/kimjongun/IdeaProjects/04/src\TheRealDealLang.g4 by ANTLR 4.9.1
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
		RULE_condition = 4, RULE_function_definition = 5, RULE_declaration = 6, 
		RULE_argument_list = 7, RULE_function_call = 8, RULE_expression_list = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "statement", "block", "expr", "condition", "function_definition", 
			"declaration", "argument_list", "function_call", "expression_list"
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
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << START_BLOCK) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << TYPE) | (1L << WHILE) | (1L << IF_KEYWORD) | (1L << RETURN_KEYWORD) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
				{
				{
				setState(20);
				statement();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
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
	public static class FunctionCallStatementContext extends StatementContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(TheRealDealLangParser.SEMICOLON, 0); }
		public FunctionCallStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
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
	public static class FunctionDefinitionStamenetContext extends StatementContext {
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public FunctionDefinitionStamenetContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitFunctionDefinitionStamenet(this);
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
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				block();
				}
				break;
			case 2:
				_localctx = new FunctionDefinitionStamenetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				function_definition();
				}
				break;
			case 3:
				_localctx = new FunctionCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				function_call();
				setState(31);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				((VarDeclStmtContext)_localctx).type = match(TYPE);
				setState(34);
				((VarDeclStmtContext)_localctx).name = match(IDENTIFIER);
				setState(35);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new InitStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				((InitStmtContext)_localctx).type = match(TYPE);
				setState(37);
				((InitStmtContext)_localctx).name = match(IDENTIFIER);
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(38);
						match(ASSIGN);
						setState(39);
						expr(0);
						}
						} 
					}
					setState(44);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(45);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				match(IDENTIFIER);
				setState(47);
				match(ASSIGN);
				setState(48);
				expr(0);
				setState(49);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new PrintCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(51);
				match(PRINT);
				setState(52);
				match(T__0);
				setState(53);
				expr(0);
				setState(54);
				match(T__1);
				setState(55);
				match(SEMICOLON);
				}
				break;
			case 8:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(57);
				match(RETURN_KEYWORD);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
					{
					setState(58);
					expr(0);
					}
				}

				setState(61);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(62);
				match(IF_KEYWORD);
				setState(63);
				((IfStatementContext)_localctx).ifCondition = condition();
				setState(64);
				((IfStatementContext)_localctx).trueBlock = block();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE_KEYWORD) {
					{
					setState(65);
					match(ELSE_KEYWORD);
					setState(66);
					((IfStatementContext)_localctx).falseBlock = block();
					}
				}

				}
				break;
			case 10:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(69);
				match(WHILE);
				setState(70);
				condition();
				setState(71);
				block();
				}
				break;
			case 11:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(73);
				((ExprStmtContext)_localctx).stmtExpr = expr(0);
				setState(74);
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
			setState(78);
			match(START_BLOCK);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << START_BLOCK) | (1L << PRINT) | (1L << TRUE) | (1L << FALSE) | (1L << TYPE) | (1L << WHILE) | (1L << IF_KEYWORD) | (1L << RETURN_KEYWORD) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
				{
				{
				setState(79);
				statement();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
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
		public Token func;
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
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
	public static class FunctionCallExprContext extends ExprContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
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
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(88);
				((IntExprContext)_localctx).value = match(INT);
				}
				break;
			case 2:
				{
				_localctx = new DoubleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				((DoubleExprContext)_localctx).value = match(DOUBLE);
				}
				break;
			case 3:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
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
				setState(91);
				((VariableExprContext)_localctx).value = match(IDENTIFIER);
				}
				break;
			case 5:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				((FuncExprContext)_localctx).func = match(IDENTIFIER);
				setState(93);
				match(T__0);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
					{
					setState(94);
					expr(0);
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(95);
						match(COMMA);
						setState(96);
						expr(0);
						}
						}
						setState(101);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(104);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				function_call();
				}
				break;
			case 7:
				{
				_localctx = new TextExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(TEXT_VALUE);
				}
				break;
			case 8:
				{
				_localctx = new ScannerExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(SCANNER);
				}
				break;
			case 9:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(T__0);
				setState(109);
				expr(0);
				setState(110);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExMulExprContext(new ExprContext(_parentctx, _parentState));
						((ExMulExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(115);
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
						setState(116);
						((ExMulExprContext)_localctx).right = expr(11);
						}
						break;
					case 2:
						{
						_localctx = new AddsubExprContext(new ExprContext(_parentctx, _parentState));
						((AddsubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(118);
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
						setState(119);
						((AddsubExprContext)_localctx).right = expr(10);
						}
						break;
					case 3:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(121);
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
						setState(122);
						((CompareExprContext)_localctx).right = expr(9);
						}
						break;
					case 4:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(124);
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
						setState(125);
						((EqualExprContext)_localctx).right = expr(8);
						}
						break;
					case 5:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(127);
						((LogicalExprContext)_localctx).op = match(AND);
						setState(128);
						((LogicalExprContext)_localctx).right = expr(7);
						}
						break;
					case 6:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(130);
						((LogicalExprContext)_localctx).op = match(OR);
						setState(131);
						((LogicalExprContext)_localctx).right = expr(6);
						}
						break;
					}
					} 
				}
				setState(136);
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
			setState(137);
			match(T__0);
			setState(139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(138);
				expr(0);
				}
				}
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0) );
			setState(143);
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
			setState(145);
			match(TYPE);
			setState(146);
			match(IDENTIFIER);
			setState(147);
			match(T__0);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(148);
				argument_list();
				}
			}

			setState(151);
			match(T__1);
			setState(152);
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
		enterRule(_localctx, 12, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(TYPE);
			setState(155);
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
		enterRule(_localctx, 14, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			declaration();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(158);
				match(COMMA);
				setState(159);
				declaration();
				}
				}
				setState(164);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TheRealDealLangParser.IDENTIFIER, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TheRealDealLangVisitor ) return ((TheRealDealLangVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(IDENTIFIER);
			setState(166);
			match(T__0);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SCANNER) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << INT) | (1L << TEXT_VALUE) | (1L << DOUBLE))) != 0)) {
				{
				setState(167);
				expression_list();
				}
			}

			setState(170);
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
		enterRule(_localctx, 18, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			expr(0);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173);
				match(COMMA);
				setState(174);
				expr(0);
				}
				}
				setState(179);
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
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00b7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"F\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3O\n\3\3\4\3\4\7\4S\n\4\f\4\16\4V"+
		"\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5d\n\5\f\5\16"+
		"\5g\13\5\5\5i\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5s\n\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0087"+
		"\n\5\f\5\16\5\u008a\13\5\3\6\3\6\6\6\u008e\n\6\r\6\16\6\u008f\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\5\7\u0098\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\7\t"+
		"\u00a3\n\t\f\t\16\t\u00a6\13\t\3\n\3\n\3\n\5\n\u00ab\n\n\3\n\3\n\3\13"+
		"\3\13\3\13\7\13\u00b2\n\13\f\13\16\13\u00b5\13\13\3\13\3,\3\b\f\2\4\6"+
		"\b\n\f\16\20\22\24\2\7\3\2\30\31\4\2\5\5\r\r\3\2\6\7\5\2\b\t\16\16\20"+
		"\20\4\2\n\n\f\f\2\u00d0\2\31\3\2\2\2\4N\3\2\2\2\6P\3\2\2\2\br\3\2\2\2"+
		"\n\u008b\3\2\2\2\f\u0093\3\2\2\2\16\u009c\3\2\2\2\20\u009f\3\2\2\2\22"+
		"\u00a7\3\2\2\2\24\u00ae\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2\30\33\3\2"+
		"\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34\35\7\2"+
		"\2\3\35\3\3\2\2\2\36O\5\6\4\2\37O\5\f\7\2 !\5\22\n\2!\"\7\23\2\2\"O\3"+
		"\2\2\2#$\7\35\2\2$%\7&\2\2%O\7\23\2\2&\'\7\35\2\2\',\7&\2\2()\7\13\2\2"+
		")+\5\b\5\2*(\3\2\2\2+.\3\2\2\2,-\3\2\2\2,*\3\2\2\2-/\3\2\2\2.,\3\2\2\2"+
		"/O\7\23\2\2\60\61\7&\2\2\61\62\7\13\2\2\62\63\5\b\5\2\63\64\7\23\2\2\64"+
		"O\3\2\2\2\65\66\7\27\2\2\66\67\7\3\2\2\678\5\b\5\289\7\4\2\29:\7\23\2"+
		"\2:O\3\2\2\2;=\7%\2\2<>\5\b\5\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?O\7\23\2"+
		"\2@A\7\37\2\2AB\5\n\6\2BE\5\6\4\2CD\7 \2\2DF\5\6\4\2EC\3\2\2\2EF\3\2\2"+
		"\2FO\3\2\2\2GH\7\36\2\2HI\5\n\6\2IJ\5\6\4\2JO\3\2\2\2KL\5\b\5\2LM\7\23"+
		"\2\2MO\3\2\2\2N\36\3\2\2\2N\37\3\2\2\2N \3\2\2\2N#\3\2\2\2N&\3\2\2\2N"+
		"\60\3\2\2\2N\65\3\2\2\2N;\3\2\2\2N@\3\2\2\2NG\3\2\2\2NK\3\2\2\2O\5\3\2"+
		"\2\2PT\7\25\2\2QS\5\4\3\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3"+
		"\2\2\2VT\3\2\2\2WX\7\26\2\2X\7\3\2\2\2YZ\b\5\1\2Zs\7\'\2\2[s\7)\2\2\\"+
		"s\t\2\2\2]s\7&\2\2^_\7&\2\2_h\7\3\2\2`e\5\b\5\2ab\7\22\2\2bd\5\b\5\2c"+
		"a\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h`\3\2\2\2"+
		"hi\3\2\2\2ij\3\2\2\2js\7\4\2\2ks\5\22\n\2ls\7(\2\2ms\7\24\2\2no\7\3\2"+
		"\2op\5\b\5\2pq\7\4\2\2qs\3\2\2\2rY\3\2\2\2r[\3\2\2\2r\\\3\2\2\2r]\3\2"+
		"\2\2r^\3\2\2\2rk\3\2\2\2rl\3\2\2\2rm\3\2\2\2rn\3\2\2\2s\u0088\3\2\2\2"+
		"tu\f\f\2\2uv\t\3\2\2v\u0087\5\b\5\rwx\f\13\2\2xy\t\4\2\2y\u0087\5\b\5"+
		"\fz{\f\n\2\2{|\t\5\2\2|\u0087\5\b\5\13}~\f\t\2\2~\177\t\6\2\2\177\u0087"+
		"\5\b\5\n\u0080\u0081\f\b\2\2\u0081\u0082\7\21\2\2\u0082\u0087\5\b\5\t"+
		"\u0083\u0084\f\7\2\2\u0084\u0085\7\17\2\2\u0085\u0087\5\b\5\b\u0086t\3"+
		"\2\2\2\u0086w\3\2\2\2\u0086z\3\2\2\2\u0086}\3\2\2\2\u0086\u0080\3\2\2"+
		"\2\u0086\u0083\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\t\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d\7\3\2\2\u008c"+
		"\u008e\5\b\5\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\4\2\2\u0092"+
		"\13\3\2\2\2\u0093\u0094\7\35\2\2\u0094\u0095\7&\2\2\u0095\u0097\7\3\2"+
		"\2\u0096\u0098\5\20\t\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\7\4\2\2\u009a\u009b\5\6\4\2\u009b\r\3\2\2\2"+
		"\u009c\u009d\7\35\2\2\u009d\u009e\7&\2\2\u009e\17\3\2\2\2\u009f\u00a4"+
		"\5\16\b\2\u00a0\u00a1\7\22\2\2\u00a1\u00a3\5\16\b\2\u00a2\u00a0\3\2\2"+
		"\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\21"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7&\2\2\u00a8\u00aa\7\3\2\2\u00a9"+
		"\u00ab\5\24\13\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3"+
		"\2\2\2\u00ac\u00ad\7\4\2\2\u00ad\23\3\2\2\2\u00ae\u00b3\5\b\5\2\u00af"+
		"\u00b0\7\22\2\2\u00b0\u00b2\5\b\5\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\25\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\22\31,=ENTehr\u0086\u0088\u008f\u0097\u00a4\u00aa\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}