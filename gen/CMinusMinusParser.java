// Generated from E:/ѧϰ/������/����������/KTest/src/main/java\CMinusMinus.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMinusMinusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, Comment=2, LineComment=3, LPAREN=4, RPAREN=5, LBRACK=6, RBRACK=7, 
		LBRACE=8, RBRACE=9, COMMA=10, SEMICOLON=11, ADD=12, SUB=13, MUL=14, DIV=15, 
		EQEQ=16, NE=17, LT=18, EQ=19, IF=20, ELSE=21, WHILE=22, BREAK=23, READ=24, 
		WRITE=25, INT=26, REAL=27, Integer=28, RealNumber=29, ID=30;
	public static final int
		RULE_prog = 0, RULE_statementList = 1, RULE_statement = 2, RULE_ifStatement = 3, 
		RULE_whileStatement = 4, RULE_sequenceStructure = 5, RULE_selectiveStructure = 6, 
		RULE_cycleStructure = 7, RULE_declareStatement = 8, RULE_initializer = 9, 
		RULE_arrayLiteral = 10, RULE_blockStatement = 11, RULE_assignStatement = 12, 
		RULE_readStatement = 13, RULE_writeStatement = 14, RULE_expression = 15, 
		RULE_relationExpr = 16, RULE_variable = 17, RULE_arithmeticExpr = 18;
	public static final String[] ruleNames = {
		"prog", "statementList", "statement", "ifStatement", "whileStatement", 
		"sequenceStructure", "selectiveStructure", "cycleStructure", "declareStatement", 
		"initializer", "arrayLiteral", "blockStatement", "assignStatement", "readStatement", 
		"writeStatement", "expression", "relationExpr", "variable", "arithmeticExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", "','", 
		"';'", "'+'", "'-'", "'*'", "'/'", "'=='", "'<>'", "'<'", "'='", "'if'", 
		"'else'", "'while'", "'break'", "'read'", "'write'", "'int'", "'real'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "Comment", "LineComment", "LPAREN", "RPAREN", "LBRACK", "RBRACK", 
		"LBRACE", "RBRACE", "COMMA", "SEMICOLON", "ADD", "SUB", "MUL", "DIV", 
		"EQEQ", "NE", "LT", "EQ", "IF", "ELSE", "WHILE", "BREAK", "READ", "WRITE", 
		"INT", "REAL", "Integer", "RealNumber", "ID"
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
	public String getGrammarFileName() { return "com/cmm/CMinusMinus.g4"; }

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
			setState(38);
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
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				statement();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LBRACE) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << INT) | (1L << REAL) | (1L << Integer) | (1L << ID))) != 0) );
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
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				selectiveStructure();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				cycleStructure();
				}
				break;
			case LPAREN:
			case LBRACE:
			case READ:
			case WRITE:
			case INT:
			case REAL:
			case Integer:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
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
		public List<RelationExprContext> relationExpr() {
			return getRuleContexts(RelationExprContext.class);
		}
		public RelationExprContext relationExpr(int i) {
			return getRuleContext(RelationExprContext.class,i);
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
			setState(50);
			match(IF);
			setState(51);
			match(LPAREN);
			setState(52);
			relationExpr();
			setState(53);
			match(RPAREN);
			setState(54);
			statement();
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(55);
					match(ELSE);
					setState(56);
					match(IF);
					setState(57);
					match(LPAREN);
					setState(58);
					relationExpr();
					setState(59);
					match(RPAREN);
					setState(60);
					statement();
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(67);
				match(ELSE);
				setState(68);
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
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
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
			setState(71);
			match(WHILE);
			setState(72);
			match(LPAREN);
			setState(73);
			relationExpr();
			setState(74);
			match(RPAREN);
			setState(75);
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
		enterRule(_localctx, 10, RULE_sequenceStructure);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				declareStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				blockStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				assignStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				readStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				writeStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
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
		enterRule(_localctx, 12, RULE_selectiveStructure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
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
		enterRule(_localctx, 14, RULE_cycleStructure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			whileStatement();
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
		enterRule(_localctx, 16, RULE_declareStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==REAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(90);
			match(ID);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(91);
				match(LBRACK);
				setState(92);
				match(Integer);
				setState(93);
				match(RBRACK);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(99);
				initializer();
				}
			}

			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(102);
				match(COMMA);
				setState(103);
				match(ID);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(104);
					match(LBRACK);
					setState(105);
					match(Integer);
					setState(106);
					match(RBRACK);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(112);
					initializer();
					}
				}

				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
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
		enterRule(_localctx, 18, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(EQ);
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case REAL:
			case Integer:
			case ID:
				{
				setState(123);
				expression();
				}
				break;
			case LBRACE:
				{
				setState(124);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(CMinusMinusParser.RBRACE, 0); }
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
		enterRule(_localctx, 20, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(LBRACE);
			setState(128);
			expression();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(129);
				match(COMMA);
				setState(130);
				expression();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
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
		enterRule(_localctx, 22, RULE_blockStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LBRACE);
			setState(139);
			statementList();
			setState(140);
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
		enterRule(_localctx, 24, RULE_assignStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(ID);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(143);
				match(LBRACK);
				setState(144);
				match(Integer);
				setState(145);
				match(RBRACK);
				}
			}

			setState(148);
			initializer();
			setState(149);
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
		enterRule(_localctx, 26, RULE_readStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(READ);
			setState(152);
			match(ID);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(153);
				match(LBRACK);
				setState(154);
				match(Integer);
				setState(155);
				match(RBRACK);
				}
			}

			setState(158);
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
		enterRule(_localctx, 28, RULE_writeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(WRITE);
			setState(161);
			expression();
			setState(162);
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
		public RelationExprContext relationExpr() {
			return getRuleContext(RelationExprContext.class,0);
		}
		public ArithmeticExprContext arithmeticExpr() {
			return getRuleContext(ArithmeticExprContext.class,0);
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
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				relationExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				arithmeticExpr(0);
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
		enterRule(_localctx, 32, RULE_relationExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			variable();
			setState(169);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQEQ) | (1L << NE) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(170);
			variable();
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
		enterRule(_localctx, 34, RULE_variable);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(ID);
				setState(176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(173);
					match(LBRACK);
					setState(174);
					match(Integer);
					setState(175);
					match(RBRACK);
					}
					break;
				}
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(Integer);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(REAL);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(LPAREN);
				setState(181);
				arithmeticExpr(0);
				setState(182);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_arithmeticExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(187);
			variable();
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(195);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpr);
						setState(189);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(190);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						arithmeticExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpr);
						setState(192);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(193);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						arithmeticExpr(3);
						}
						break;
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		case 18:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00cb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\6\3,\n\3\r\3\16\3-\3\4\3\4\3\4\5\4\63"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5A\n\5\f\5\16\5"+
		"D\13\5\3\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7V\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\na\n\n\f\n\16\nd\13"+
		"\n\3\n\5\ng\n\n\3\n\3\n\3\n\3\n\3\n\7\nn\n\n\f\n\16\nq\13\n\3\n\5\nt\n"+
		"\n\7\nv\n\n\f\n\16\ny\13\n\3\n\3\n\3\13\3\13\3\13\5\13\u0080\n\13\3\f"+
		"\3\f\3\f\3\f\7\f\u0086\n\f\f\f\16\f\u0089\13\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\5\16\u0095\n\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u009f\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00a9"+
		"\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00b3\n\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00bb\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u00c6\n\24\f\24\16\24\u00c9\13\24\3\24\2\3&\25\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\6\3\2\34\35\3\2\22\24\3\2\20\21"+
		"\3\2\16\17\2\u00d1\2(\3\2\2\2\4+\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\nI"+
		"\3\2\2\2\fU\3\2\2\2\16W\3\2\2\2\20Y\3\2\2\2\22[\3\2\2\2\24|\3\2\2\2\26"+
		"\u0081\3\2\2\2\30\u008c\3\2\2\2\32\u0090\3\2\2\2\34\u0099\3\2\2\2\36\u00a2"+
		"\3\2\2\2 \u00a8\3\2\2\2\"\u00aa\3\2\2\2$\u00ba\3\2\2\2&\u00bc\3\2\2\2"+
		"()\5\4\3\2)\3\3\2\2\2*,\5\6\4\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2"+
		"\2.\5\3\2\2\2/\63\5\16\b\2\60\63\5\20\t\2\61\63\5\f\7\2\62/\3\2\2\2\62"+
		"\60\3\2\2\2\62\61\3\2\2\2\63\7\3\2\2\2\64\65\7\26\2\2\65\66\7\6\2\2\66"+
		"\67\5\"\22\2\678\7\7\2\28B\5\6\4\29:\7\27\2\2:;\7\26\2\2;<\7\6\2\2<=\5"+
		"\"\22\2=>\7\7\2\2>?\5\6\4\2?A\3\2\2\2@9\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC"+
		"\3\2\2\2CG\3\2\2\2DB\3\2\2\2EF\7\27\2\2FH\5\6\4\2GE\3\2\2\2GH\3\2\2\2"+
		"H\t\3\2\2\2IJ\7\30\2\2JK\7\6\2\2KL\5\"\22\2LM\7\7\2\2MN\5\6\4\2N\13\3"+
		"\2\2\2OV\5\22\n\2PV\5\30\r\2QV\5\32\16\2RV\5\34\17\2SV\5\36\20\2TV\5 "+
		"\21\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\r\3"+
		"\2\2\2WX\5\b\5\2X\17\3\2\2\2YZ\5\n\6\2Z\21\3\2\2\2[\\\t\2\2\2\\b\7 \2"+
		"\2]^\7\b\2\2^_\7\36\2\2_a\7\t\2\2`]\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2"+
		"\2\2cf\3\2\2\2db\3\2\2\2eg\5\24\13\2fe\3\2\2\2fg\3\2\2\2gw\3\2\2\2hi\7"+
		"\f\2\2io\7 \2\2jk\7\b\2\2kl\7\36\2\2ln\7\t\2\2mj\3\2\2\2nq\3\2\2\2om\3"+
		"\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2\2rt\5\24\13\2sr\3\2\2\2st\3\2\2\2t"+
		"v\3\2\2\2uh\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2"+
		"z{\7\r\2\2{\23\3\2\2\2|\177\7\25\2\2}\u0080\5 \21\2~\u0080\5\26\f\2\177"+
		"}\3\2\2\2\177~\3\2\2\2\u0080\25\3\2\2\2\u0081\u0082\7\n\2\2\u0082\u0087"+
		"\5 \21\2\u0083\u0084\7\f\2\2\u0084\u0086\5 \21\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\13\2\2\u008b\27\3\2\2\2\u008c\u008d"+
		"\7\n\2\2\u008d\u008e\5\4\3\2\u008e\u008f\7\13\2\2\u008f\31\3\2\2\2\u0090"+
		"\u0094\7 \2\2\u0091\u0092\7\b\2\2\u0092\u0093\7\36\2\2\u0093\u0095\7\t"+
		"\2\2\u0094\u0091\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\5\24\13\2\u0097\u0098\7\r\2\2\u0098\33\3\2\2\2\u0099\u009a\7\32"+
		"\2\2\u009a\u009e\7 \2\2\u009b\u009c\7\b\2\2\u009c\u009d\7\36\2\2\u009d"+
		"\u009f\7\t\2\2\u009e\u009b\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\7\r\2\2\u00a1\35\3\2\2\2\u00a2\u00a3\7\33\2\2\u00a3\u00a4"+
		"\5 \21\2\u00a4\u00a5\7\r\2\2\u00a5\37\3\2\2\2\u00a6\u00a9\5\"\22\2\u00a7"+
		"\u00a9\5&\24\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9!\3\2\2\2"+
		"\u00aa\u00ab\5$\23\2\u00ab\u00ac\t\3\2\2\u00ac\u00ad\5$\23\2\u00ad#\3"+
		"\2\2\2\u00ae\u00b2\7 \2\2\u00af\u00b0\7\b\2\2\u00b0\u00b1\7\36\2\2\u00b1"+
		"\u00b3\7\t\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00bb\3\2"+
		"\2\2\u00b4\u00bb\7\36\2\2\u00b5\u00bb\7\35\2\2\u00b6\u00b7\7\6\2\2\u00b7"+
		"\u00b8\5&\24\2\u00b8\u00b9\7\7\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00ae\3\2"+
		"\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b5\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb"+
		"%\3\2\2\2\u00bc\u00bd\b\24\1\2\u00bd\u00be\5$\23\2\u00be\u00c7\3\2\2\2"+
		"\u00bf\u00c0\f\5\2\2\u00c0\u00c1\t\4\2\2\u00c1\u00c6\5&\24\6\u00c2\u00c3"+
		"\f\4\2\2\u00c3\u00c4\t\5\2\2\u00c4\u00c6\5&\24\5\u00c5\u00bf\3\2\2\2\u00c5"+
		"\u00c2\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\'\3\2\2\2\u00c9\u00c7\3\2\2\2\25-\62BGUbfosw\177\u0087\u0094"+
		"\u009e\u00a8\u00b2\u00ba\u00c5\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}