// Generated from E:/学习/大三上/解释器构造/KTest/src/main/java/com/cmm\CMinusMinus.g4 by ANTLR 4.7
package com.cmm;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMinusMinusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, Comment=2, LineComment=3, LPAREN=4, RPAREN=5, LBRACK=6, RBRACK=7, 
		LBRACE=8, RBRACE=9, COMMA=10, SEMICOLON=11, ADD=12, SUB=13, MUL=14, DIV=15, 
		BANG=16, OROR=17, ANDAND=18, EQEQ=19, NE=20, LT=21, GT=22, EQ=23, IF=24, 
		ELSE=25, WHILE=26, BREAK=27, READ=28, WRITE=29, INT=30, REAL=31, Integer=32, 
		RealNumber=33, ID=34;
	public static final int
		RULE_prog = 0, RULE_statementList = 1, RULE_statement = 2, RULE_ifStatement = 3, 
		RULE_whileStatement = 4, RULE_breakStatement = 5, RULE_sequenceStructure = 6, 
		RULE_selectiveStructure = 7, RULE_cycleStructure = 8, RULE_declareStatement = 9, 
		RULE_initializer = 10, RULE_arrayLiteral = 11, RULE_blockStatement = 12, 
		RULE_assignStatement = 13, RULE_readStatement = 14, RULE_writeStatement = 15, 
		RULE_expression = 16, RULE_logicalOrExpr = 17, RULE_logicalAndExpr = 18, 
		RULE_relationExpr = 19, RULE_variable = 20, RULE_arithmeticExpr = 21;
	public static final String[] ruleNames = {
		"prog", "statementList", "statement", "ifStatement", "whileStatement", 
		"breakStatement", "sequenceStructure", "selectiveStructure", "cycleStructure", 
		"declareStatement", "initializer", "arrayLiteral", "blockStatement", "assignStatement", 
		"readStatement", "writeStatement", "expression", "logicalOrExpr", "logicalAndExpr", 
		"relationExpr", "variable", "arithmeticExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", 
		"';'", "'+'", "'-'", "'*'", "'/'", "'!'", "'||'", "'&&'", "'=='", "'<>'", 
		"'<'", "'>'", "'='", "'if'", "'else'", "'while'", "'break'", "'read'", 
		"'write'", "'int'", "'real'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "Comment", "LineComment", "LPAREN", "RPAREN", "LBRACK", "RBRACK", 
		"LBRACE", "RBRACE", "COMMA", "SEMICOLON", "ADD", "SUB", "MUL", "DIV", 
		"BANG", "OROR", "ANDAND", "EQEQ", "NE", "LT", "GT", "EQ", "IF", "ELSE", 
		"WHILE", "BREAK", "READ", "WRITE", "INT", "REAL", "Integer", "RealNumber", 
		"ID"
	};
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
	public String getGrammarFileName() { return "CMinusMinus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CMinusMinusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			statementList();
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

	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				statement();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LBRACE) | (1L << BANG) | (1L << IF) | (1L << WHILE) | (1L << BREAK) | (1L << READ) | (1L << WRITE) | (1L << INT) | (1L << REAL) | (1L << Integer) | (1L << ID))) != 0) );
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
		public SelectiveStructureContext selectiveStructure() {
			return getRuleContext(SelectiveStructureContext.class,0);
		}
		public CycleStructureContext cycleStructure() {
			return getRuleContext(CycleStructureContext.class,0);
		}
		public SequenceStructureContext sequenceStructure() {
			return getRuleContext(SequenceStructureContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				selectiveStructure();
				}
				break;
			case WHILE:
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				cycleStructure();
				}
				break;
			case LPAREN:
			case LBRACE:
			case BANG:
			case READ:
			case WRITE:
			case INT:
			case REAL:
			case Integer:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				sequenceStructure();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class IfStatementContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(CMinusMinusParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(CMinusMinusParser.IF, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(CMinusMinusParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(CMinusMinusParser.LPAREN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(CMinusMinusParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(CMinusMinusParser.RPAREN, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(CMinusMinusParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(CMinusMinusParser.ELSE, i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IF);
			setState(57);
			match(LPAREN);
			setState(58);
			expression();
			setState(59);
			match(RPAREN);
			setState(60);
			statement();
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(61);
					match(ELSE);
					setState(62);
					match(IF);
					setState(63);
					match(LPAREN);
					setState(64);
					expression();
					setState(65);
					match(RPAREN);
					setState(66);
					statement();
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(73);
				match(ELSE);
				setState(74);
				statement();
				}
				break;
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CMinusMinusParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(CMinusMinusParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CMinusMinusParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(WHILE);
			setState(78);
			match(LPAREN);
			setState(79);
			expression();
			setState(80);
			match(RPAREN);
			setState(81);
			statement();
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

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(CMinusMinusParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(BREAK);
			setState(84);
			match(SEMICOLON);
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

	public static class SequenceStructureContext extends ParserRuleContext {
		public DeclareStatementContext declareStatement() {
			return getRuleContext(DeclareStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SequenceStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterSequenceStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitSequenceStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitSequenceStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceStructureContext sequenceStructure() throws RecognitionException {
		SequenceStructureContext _localctx = new SequenceStructureContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sequenceStructure);
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				declareStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				blockStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				assignStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				readStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				writeStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				expression();
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

	public static class SelectiveStructureContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public SelectiveStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectiveStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterSelectiveStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitSelectiveStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitSelectiveStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectiveStructureContext selectiveStructure() throws RecognitionException {
		SelectiveStructureContext _localctx = new SelectiveStructureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selectiveStructure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			ifStatement();
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

	public static class CycleStructureContext extends ParserRuleContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public CycleStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycleStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterCycleStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitCycleStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitCycleStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleStructureContext cycleStructure() throws RecognitionException {
		CycleStructureContext _localctx = new CycleStructureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cycleStructure);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				whileStatement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				breakStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DeclareStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CMinusMinusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CMinusMinusParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public TerminalNode INT() { return getToken(CMinusMinusParser.INT, 0); }
		public TerminalNode REAL() { return getToken(CMinusMinusParser.REAL, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(CMinusMinusParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(CMinusMinusParser.LBRACK, i);
		}
		public List<TerminalNode> Integer() { return getTokens(CMinusMinusParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(CMinusMinusParser.Integer, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(CMinusMinusParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(CMinusMinusParser.RBRACK, i);
		}
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CMinusMinusParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CMinusMinusParser.COMMA, i);
		}
		public DeclareStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterDeclareStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitDeclareStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitDeclareStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareStatementContext declareStatement() throws RecognitionException {
		DeclareStatementContext _localctx = new DeclareStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declareStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==REAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(101);
			match(ID);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(102);
				match(LBRACK);
				setState(103);
				match(Integer);
				setState(104);
				match(RBRACK);
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(110);
				initializer();
				}
			}

			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(113);
				match(COMMA);
				setState(114);
				match(ID);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(115);
					match(LBRACK);
					setState(116);
					match(Integer);
					setState(117);
					match(RBRACK);
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(123);
					initializer();
					}
				}

				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(SEMICOLON);
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

	public static class InitializerContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(CMinusMinusParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(EQ);
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case BANG:
			case REAL:
			case Integer:
			case ID:
				{
				setState(134);
				expression();
				}
				break;
			case LBRACE:
				{
				setState(135);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(CMinusMinusParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CMinusMinusParser.RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ArrayLiteralContext> arrayLiteral() {
			return getRuleContexts(ArrayLiteralContext.class);
		}
		public ArrayLiteralContext arrayLiteral(int i) {
			return getRuleContext(ArrayLiteralContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CMinusMinusParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CMinusMinusParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LBRACE);
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case BANG:
			case REAL:
			case Integer:
			case ID:
				{
				setState(139);
				expression();
				}
				break;
			case LBRACE:
				{
				setState(140);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(143);
				match(COMMA);
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
				case BANG:
				case REAL:
				case Integer:
				case ID:
					{
					setState(144);
					expression();
					}
					break;
				case LBRACE:
					{
					setState(145);
					arrayLiteral();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(RBRACE);
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

	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(CMinusMinusParser.LBRACE, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(CMinusMinusParser.RBRACE, 0); }
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blockStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LBRACE);
			setState(156);
			statementList();
			setState(157);
			match(RBRACE);
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

	public static class AssignStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public TerminalNode LBRACK() { return getToken(CMinusMinusParser.LBRACK, 0); }
		public TerminalNode Integer() { return getToken(CMinusMinusParser.Integer, 0); }
		public TerminalNode RBRACK() { return getToken(CMinusMinusParser.RBRACK, 0); }
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(ID);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(160);
				match(LBRACK);
				setState(161);
				match(Integer);
				setState(162);
				match(RBRACK);
				}
			}

			setState(165);
			initializer();
			setState(166);
			match(SEMICOLON);
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

	public static class ReadStatementContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(CMinusMinusParser.READ, 0); }
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public TerminalNode LBRACK() { return getToken(CMinusMinusParser.LBRACK, 0); }
		public TerminalNode Integer() { return getToken(CMinusMinusParser.Integer, 0); }
		public TerminalNode RBRACK() { return getToken(CMinusMinusParser.RBRACK, 0); }
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterReadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitReadStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitReadStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_readStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(READ);
			setState(169);
			match(ID);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(170);
				match(LBRACK);
				setState(171);
				match(Integer);
				setState(172);
				match(RBRACK);
				}
			}

			setState(175);
			match(SEMICOLON);
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

	public static class WriteStatementContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(CMinusMinusParser.WRITE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CMinusMinusParser.SEMICOLON, 0); }
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitWriteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_writeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(WRITE);
			setState(178);
			expression();
			setState(179);
			match(SEMICOLON);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ArithmeticExprContext arithmeticExpr() {
			return getRuleContext(ArithmeticExprContext.class,0);
		}
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				arithmeticExpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				logicalOrExpr();
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

	public static class LogicalOrExprContext extends ParserRuleContext {
		public List<LogicalAndExprContext> logicalAndExpr() {
			return getRuleContexts(LogicalAndExprContext.class);
		}
		public LogicalAndExprContext logicalAndExpr(int i) {
			return getRuleContext(LogicalAndExprContext.class,i);
		}
		public List<TerminalNode> OROR() { return getTokens(CMinusMinusParser.OROR); }
		public TerminalNode OROR(int i) {
			return getToken(CMinusMinusParser.OROR, i);
		}
		public LogicalOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterLogicalOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitLogicalOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitLogicalOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExprContext logicalOrExpr() throws RecognitionException {
		LogicalOrExprContext _localctx = new LogicalOrExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			logicalAndExpr();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OROR) {
				{
				{
				setState(186);
				match(OROR);
				setState(187);
				logicalAndExpr();
				}
				}
				setState(192);
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

	public static class LogicalAndExprContext extends ParserRuleContext {
		public List<RelationExprContext> relationExpr() {
			return getRuleContexts(RelationExprContext.class);
		}
		public RelationExprContext relationExpr(int i) {
			return getRuleContext(RelationExprContext.class,i);
		}
		public List<TerminalNode> ANDAND() { return getTokens(CMinusMinusParser.ANDAND); }
		public TerminalNode ANDAND(int i) {
			return getToken(CMinusMinusParser.ANDAND, i);
		}
		public LogicalAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterLogicalAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitLogicalAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitLogicalAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExprContext logicalAndExpr() throws RecognitionException {
		LogicalAndExprContext _localctx = new LogicalAndExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			relationExpr();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANDAND) {
				{
				{
				setState(194);
				match(ANDAND);
				setState(195);
				relationExpr();
				}
				}
				setState(200);
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

	public static class RelationExprContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode EQEQ() { return getToken(CMinusMinusParser.EQEQ, 0); }
		public TerminalNode LT() { return getToken(CMinusMinusParser.LT, 0); }
		public TerminalNode NE() { return getToken(CMinusMinusParser.NE, 0); }
		public TerminalNode GT() { return getToken(CMinusMinusParser.GT, 0); }
		public TerminalNode BANG() { return getToken(CMinusMinusParser.BANG, 0); }
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public RelationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterRelationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitRelationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitRelationExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationExprContext relationExpr() throws RecognitionException {
		RelationExprContext _localctx = new RelationExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_relationExpr);
		int _la;
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case REAL:
			case Integer:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				variable();
				setState(202);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQEQ) | (1L << NE) | (1L << LT) | (1L << GT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				variable();
				}
				break;
			case BANG:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(BANG);
				setState(206);
				relationExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CMinusMinusParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(CMinusMinusParser.LBRACK, 0); }
		public TerminalNode Integer() { return getToken(CMinusMinusParser.Integer, 0); }
		public TerminalNode RBRACK() { return getToken(CMinusMinusParser.RBRACK, 0); }
		public TerminalNode REAL() { return getToken(CMinusMinusParser.REAL, 0); }
		public TerminalNode LPAREN() { return getToken(CMinusMinusParser.LPAREN, 0); }
		public ArithmeticExprContext arithmeticExpr() {
			return getRuleContext(ArithmeticExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CMinusMinusParser.RPAREN, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variable);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(ID);
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(210);
					match(LBRACK);
					setState(211);
					match(Integer);
					setState(212);
					match(RBRACK);
					}
					break;
				}
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(Integer);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(REAL);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				match(LPAREN);
				setState(218);
				arithmeticExpr(0);
				setState(219);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ArithmeticExprContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<ArithmeticExprContext> arithmeticExpr() {
			return getRuleContexts(ArithmeticExprContext.class);
		}
		public ArithmeticExprContext arithmeticExpr(int i) {
			return getRuleContext(ArithmeticExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(CMinusMinusParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CMinusMinusParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(CMinusMinusParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(CMinusMinusParser.SUB, 0); }
		public ArithmeticExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).enterArithmeticExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMinusMinusListener ) ((CMinusMinusListener)listener).exitArithmeticExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMinusMinusVisitor ) return ((CMinusMinusVisitor<? extends T>)visitor).visitArithmeticExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExprContext arithmeticExpr() throws RecognitionException {
		return arithmeticExpr(0);
	}

	private ArithmeticExprContext arithmeticExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExprContext _localctx = new ArithmeticExprContext(_ctx, _parentState);
		ArithmeticExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_arithmeticExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(224);
			variable();
			}
			_ctx.stop = _input.LT(-1);
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(232);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpr);
						setState(226);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(227);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(228);
						arithmeticExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpr);
						setState(229);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(230);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(231);
						arithmeticExpr(3);
						}
						break;
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return arithmeticExpr_sempred((ArithmeticExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmeticExpr_sempred(ArithmeticExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00f0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\6\3\62"+
		"\n\3\r\3\16\3\63\3\4\3\4\3\4\5\49\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5G\n\5\f\5\16\5J\13\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\n"+
		"\3\n\5\ne\n\n\3\13\3\13\3\13\3\13\3\13\7\13l\n\13\f\13\16\13o\13\13\3"+
		"\13\5\13r\n\13\3\13\3\13\3\13\3\13\3\13\7\13y\n\13\f\13\16\13|\13\13\3"+
		"\13\5\13\177\n\13\7\13\u0081\n\13\f\13\16\13\u0084\13\13\3\13\3\13\3\f"+
		"\3\f\3\f\5\f\u008b\n\f\3\r\3\r\3\r\5\r\u0090\n\r\3\r\3\r\3\r\5\r\u0095"+
		"\n\r\7\r\u0097\n\r\f\r\16\r\u009a\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\5\17\u00a6\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00b0\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00ba\n"+
		"\22\3\23\3\23\3\23\7\23\u00bf\n\23\f\23\16\23\u00c2\13\23\3\24\3\24\3"+
		"\24\7\24\u00c7\n\24\f\24\16\24\u00ca\13\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\5\25\u00d2\n\25\3\26\3\26\3\26\3\26\5\26\u00d8\n\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u00e0\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u00eb\n\27\f\27\16\27\u00ee\13\27\3\27\2\3,\30\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,\2\6\3\2 !\3\2\25\30\3\2\20\21\3\2"+
		"\16\17\2\u00f9\2.\3\2\2\2\4\61\3\2\2\2\68\3\2\2\2\b:\3\2\2\2\nO\3\2\2"+
		"\2\fU\3\2\2\2\16^\3\2\2\2\20`\3\2\2\2\22d\3\2\2\2\24f\3\2\2\2\26\u0087"+
		"\3\2\2\2\30\u008c\3\2\2\2\32\u009d\3\2\2\2\34\u00a1\3\2\2\2\36\u00aa\3"+
		"\2\2\2 \u00b3\3\2\2\2\"\u00b9\3\2\2\2$\u00bb\3\2\2\2&\u00c3\3\2\2\2(\u00d1"+
		"\3\2\2\2*\u00df\3\2\2\2,\u00e1\3\2\2\2./\5\4\3\2/\3\3\2\2\2\60\62\5\6"+
		"\4\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\5\3\2"+
		"\2\2\659\5\20\t\2\669\5\22\n\2\679\5\16\b\28\65\3\2\2\28\66\3\2\2\28\67"+
		"\3\2\2\29\7\3\2\2\2:;\7\32\2\2;<\7\6\2\2<=\5\"\22\2=>\7\7\2\2>H\5\6\4"+
		"\2?@\7\33\2\2@A\7\32\2\2AB\7\6\2\2BC\5\"\22\2CD\7\7\2\2DE\5\6\4\2EG\3"+
		"\2\2\2F?\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IM\3\2\2\2JH\3\2\2\2KL\7"+
		"\33\2\2LN\5\6\4\2MK\3\2\2\2MN\3\2\2\2N\t\3\2\2\2OP\7\34\2\2PQ\7\6\2\2"+
		"QR\5\"\22\2RS\7\7\2\2ST\5\6\4\2T\13\3\2\2\2UV\7\35\2\2VW\7\r\2\2W\r\3"+
		"\2\2\2X_\5\24\13\2Y_\5\32\16\2Z_\5\34\17\2[_\5\36\20\2\\_\5 \21\2]_\5"+
		"\"\22\2^X\3\2\2\2^Y\3\2\2\2^Z\3\2\2\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_"+
		"\17\3\2\2\2`a\5\b\5\2a\21\3\2\2\2be\5\n\6\2ce\5\f\7\2db\3\2\2\2dc\3\2"+
		"\2\2e\23\3\2\2\2fg\t\2\2\2gm\7$\2\2hi\7\b\2\2ij\7\"\2\2jl\7\t\2\2kh\3"+
		"\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2pr\5\26\f\2qp"+
		"\3\2\2\2qr\3\2\2\2r\u0082\3\2\2\2st\7\f\2\2tz\7$\2\2uv\7\b\2\2vw\7\"\2"+
		"\2wy\7\t\2\2xu\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{~\3\2\2\2|z\3\2\2"+
		"\2}\177\5\26\f\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080s\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\r\2\2\u0086\25\3\2\2\2\u0087"+
		"\u008a\7\31\2\2\u0088\u008b\5\"\22\2\u0089\u008b\5\30\r\2\u008a\u0088"+
		"\3\2\2\2\u008a\u0089\3\2\2\2\u008b\27\3\2\2\2\u008c\u008f\7\n\2\2\u008d"+
		"\u0090\5\"\22\2\u008e\u0090\5\30\r\2\u008f\u008d\3\2\2\2\u008f\u008e\3"+
		"\2\2\2\u0090\u0098\3\2\2\2\u0091\u0094\7\f\2\2\u0092\u0095\5\"\22\2\u0093"+
		"\u0095\5\30\r\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0097\3"+
		"\2\2\2\u0096\u0091\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\13"+
		"\2\2\u009c\31\3\2\2\2\u009d\u009e\7\n\2\2\u009e\u009f\5\4\3\2\u009f\u00a0"+
		"\7\13\2\2\u00a0\33\3\2\2\2\u00a1\u00a5\7$\2\2\u00a2\u00a3\7\b\2\2\u00a3"+
		"\u00a4\7\"\2\2\u00a4\u00a6\7\t\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\7\r\2\2\u00a9"+
		"\35\3\2\2\2\u00aa\u00ab\7\36\2\2\u00ab\u00af\7$\2\2\u00ac\u00ad\7\b\2"+
		"\2\u00ad\u00ae\7\"\2\2\u00ae\u00b0\7\t\2\2\u00af\u00ac\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\r\2\2\u00b2\37\3\2\2\2\u00b3"+
		"\u00b4\7\37\2\2\u00b4\u00b5\5\"\22\2\u00b5\u00b6\7\r\2\2\u00b6!\3\2\2"+
		"\2\u00b7\u00ba\5,\27\2\u00b8\u00ba\5$\23\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8"+
		"\3\2\2\2\u00ba#\3\2\2\2\u00bb\u00c0\5&\24\2\u00bc\u00bd\7\23\2\2\u00bd"+
		"\u00bf\5&\24\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1%\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c8"+
		"\5(\25\2\u00c4\u00c5\7\24\2\2\u00c5\u00c7\5(\25\2\u00c6\u00c4\3\2\2\2"+
		"\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\'\3"+
		"\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\5*\26\2\u00cc\u00cd\t\3\2\2\u00cd"+
		"\u00ce\5*\26\2\u00ce\u00d2\3\2\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00d2\5"+
		"(\25\2\u00d1\u00cb\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2)\3\2\2\2\u00d3\u00d7"+
		"\7$\2\2\u00d4\u00d5\7\b\2\2\u00d5\u00d6\7\"\2\2\u00d6\u00d8\7\t\2\2\u00d7"+
		"\u00d4\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00e0\3\2\2\2\u00d9\u00e0\7\""+
		"\2\2\u00da\u00e0\7!\2\2\u00db\u00dc\7\6\2\2\u00dc\u00dd\5,\27\2\u00dd"+
		"\u00de\7\7\2\2\u00de\u00e0\3\2\2\2\u00df\u00d3\3\2\2\2\u00df\u00d9\3\2"+
		"\2\2\u00df\u00da\3\2\2\2\u00df\u00db\3\2\2\2\u00e0+\3\2\2\2\u00e1\u00e2"+
		"\b\27\1\2\u00e2\u00e3\5*\26\2\u00e3\u00ec\3\2\2\2\u00e4\u00e5\f\5\2\2"+
		"\u00e5\u00e6\t\4\2\2\u00e6\u00eb\5,\27\6\u00e7\u00e8\f\4\2\2\u00e8\u00e9"+
		"\t\5\2\2\u00e9\u00eb\5,\27\5\u00ea\u00e4\3\2\2\2\u00ea\u00e7\3\2\2\2\u00eb"+
		"\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed-\3\2\2\2"+
		"\u00ee\u00ec\3\2\2\2\33\638HM^dmqz~\u0082\u008a\u008f\u0094\u0098\u00a5"+
		"\u00af\u00b9\u00c0\u00c8\u00d1\u00d7\u00df\u00ea\u00ec";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}