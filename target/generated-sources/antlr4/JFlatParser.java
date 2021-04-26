// Generated from JFlat.g4 by ANTLR 4.4

    import wci.intermediate.TypeSpec;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JFlatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, IF=7, ELSE=8, WHILE=9, 
		FUNCT=10, VAR=11, PRINT=12, RETURN=13, PBOOL=14, PINT=15, PREAL=16, PVOID=17, 
		BOOL=18, INT=19, REAL=20, MUL=21, DIV=22, ADD=23, SUB=24, MOD=25, GT=26, 
		LT=27, GTE=28, LTE=29, EQ=30, SEPARATOR=31, IDENTIFIER=32, NEWLINE=33, 
		BLOCK_COMMENT=34, LINE_COMMENT=35, WS=36;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "'='", "'}'", "'('", "')'", "','", "'if'", "'else'", 
		"'while'", "'function'", "'var'", "'print'", "'return'", "'boolean'", 
		"'int'", "'real'", "'void'", "BOOL", "INT", "REAL", "'*'", "'/'", "'+'", 
		"'-'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "';'", "IDENTIFIER", 
		"NEWLINE", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_varList = 2, RULE_varDec = 3, RULE_expr = 4, 
		RULE_signedNumber = 5, RULE_sign = 6, RULE_number = 7, RULE_params = 8, 
		RULE_args = 9, RULE_block = 10, RULE_primType = 11;
	public static final String[] ruleNames = {
		"prog", "stat", "varList", "varDec", "expr", "signedNumber", "sign", "number", 
		"params", "args", "block", "primType"
	};

	@Override
	public String getGrammarFileName() { return "JFlat.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JFlatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24); stat();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << IF) | (1L << WHILE) | (1L << FUNCT) | (1L << VAR) | (1L << PRINT) | (1L << RETURN) | (1L << BOOL) | (1L << INT) | (1L << REAL) | (1L << ADD) | (1L << SUB) | (1L << SEPARATOR) | (1L << IDENTIFIER))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyReturnContext extends StatContext {
		public TerminalNode RETURN() { return getToken(JFlatParser.RETURN, 0); }
		public EmptyReturnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterEmptyReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitEmptyReturn(this);
		}
	}
	public static class PrintContext extends StatContext {
		public TerminalNode PRINT() { return getToken(JFlatParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitPrint(this);
		}
	}
	public static class IfThenElseContext extends StatContext {
		public TerminalNode ELSE() { return getToken(JFlatParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(JFlatParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public IfThenElseContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterIfThenElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitIfThenElse(this);
		}
	}
	public static class FunctDeclareContext extends StatContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode FUNCT() { return getToken(JFlatParser.FUNCT, 0); }
		public PrimTypeContext primType() {
			return getRuleContext(PrimTypeContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(JFlatParser.IDENTIFIER, 0); }
		public FunctDeclareContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterFunctDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitFunctDeclare(this);
		}
	}
	public static class VarListDeclareContext extends StatContext {
		public TerminalNode VAR() { return getToken(JFlatParser.VAR, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public VarListDeclareContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterVarListDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitVarListDeclare(this);
		}
	}
	public static class IfThenContext extends StatContext {
		public TerminalNode IF() { return getToken(JFlatParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfThenContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterIfThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitIfThen(this);
		}
	}
	public static class WhileContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(JFlatParser.WHILE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitWhile(this);
		}
	}
	public static class EmptyStatContext extends StatContext {
		public TerminalNode SEPARATOR() { return getToken(JFlatParser.SEPARATOR, 0); }
		public EmptyStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterEmptyStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitEmptyStat(this);
		}
	}
	public static class BareExprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEPARATOR() { return getToken(JFlatParser.SEPARATOR, 0); }
		public BareExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterBareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitBareExpr(this);
		}
	}
	public static class ExprReturnContext extends StatContext {
		public TerminalNode RETURN() { return getToken(JFlatParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprReturnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterExprReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitExprReturn(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new BareExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29); expr(0);
				setState(30); match(SEPARATOR);
				}
				break;
			case 2:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32); match(IF);
				setState(33); match(T__2);
				setState(34); expr(0);
				setState(35); match(T__1);
				setState(36); block();
				setState(37); match(ELSE);
				setState(38); block();
				}
				break;
			case 3:
				_localctx = new IfThenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(40); match(IF);
				setState(41); match(T__2);
				setState(42); expr(0);
				setState(43); match(T__1);
				setState(44); block();
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(46); match(WHILE);
				setState(47); match(T__2);
				setState(48); expr(0);
				setState(49); match(T__1);
				setState(50); block();
				}
				break;
			case 5:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(52); match(PRINT);
				setState(53); match(T__2);
				setState(54); expr(0);
				setState(55); match(T__1);
				setState(56); match(SEPARATOR);
				}
				break;
			case 6:
				_localctx = new FunctDeclareContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(58); match(FUNCT);
				setState(59); primType();
				setState(60); match(IDENTIFIER);
				setState(61); params();
				setState(62); match(T__5);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << IF) | (1L << WHILE) | (1L << FUNCT) | (1L << VAR) | (1L << PRINT) | (1L << RETURN) | (1L << BOOL) | (1L << INT) | (1L << REAL) | (1L << ADD) | (1L << SUB) | (1L << SEPARATOR) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(63); stat();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69); match(T__3);
				}
				break;
			case 7:
				_localctx = new VarListDeclareContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(71); match(VAR);
				setState(72); varList();
				setState(73); match(SEPARATOR);
				}
				break;
			case 8:
				_localctx = new EmptyStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(75); match(SEPARATOR);
				}
				break;
			case 9:
				_localctx = new ExprReturnContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(76); match(RETURN);
				setState(77); expr(0);
				setState(78); match(SEPARATOR);
				}
				break;
			case 10:
				_localctx = new EmptyReturnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(80); match(RETURN);
				setState(81); match(SEPARATOR);
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

	public static class VarListContext extends ParserRuleContext {
		public List<VarDecContext> varDec() {
			return getRuleContexts(VarDecContext.class);
		}
		public VarDecContext varDec(int i) {
			return getRuleContext(VarDecContext.class,i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitVarList(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); varDec();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(85); match(T__0);
				setState(86); varDec();
				}
				}
				setState(91);
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

	public static class VarDecContext extends ParserRuleContext {
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
	 
		public VarDecContext() { }
		public void copyFrom(VarDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDeclareAssignContext extends VarDecContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(JFlatParser.IDENTIFIER, 0); }
		public VarDeclareAssignContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterVarDeclareAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitVarDeclareAssign(this);
		}
	}
	public static class VarDeclareContext extends VarDecContext {
		public TerminalNode IDENTIFIER() { return getToken(JFlatParser.IDENTIFIER, 0); }
		public VarDeclareContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterVarDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitVarDeclare(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDec);
		try {
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new VarDeclareContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92); match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new VarDeclareAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93); match(IDENTIFIER);
				setState(94); match(T__4);
				setState(95); expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public TypeSpec type;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class FunctApplyContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(JFlatParser.IDENTIFIER, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunctApplyContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterFunctApply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitFunctApply(this);
		}
	}
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitMulDivMod(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitParens(this);
		}
	}
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(JFlatParser.BOOL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitBoolean(this);
		}
	}
	public static class ComparisonContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitComparison(this);
		}
	}
	public static class SignedNumContext extends ExprContext {
		public SignedNumberContext signedNumber() {
			return getRuleContext(SignedNumberContext.class,0);
		}
		public SignedNumContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterSignedNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitSignedNum(this);
		}
	}
	public static class UnsignNumberContext extends ExprContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public UnsignNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterUnsignNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitUnsignNumber(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitAddSub(this);
		}
	}
	public static class VarRefContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(JFlatParser.IDENTIFIER, 0); }
		public VarRefContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitVarRef(this);
		}
	}
	public static class VarAssignContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(JFlatParser.IDENTIFIER, 0); }
		public VarAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterVarAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitVarAssign(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new VarAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(99); match(IDENTIFIER);
				setState(100); match(T__4);
				setState(101); expr(1);
				}
				break;
			case 2:
				{
				_localctx = new FunctApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102); match(IDENTIFIER);
				setState(103); args();
				}
				break;
			case 3:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104); match(IDENTIFIER);
				}
				break;
			case 4:
				{
				_localctx = new UnsignNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105); number();
				}
				break;
			case 5:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106); signedNumber();
				}
				break;
			case 6:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107); match(BOOL);
				}
				break;
			case 7:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108); match(T__2);
				setState(109); expr(0);
				setState(110); match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(123);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(115);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(116); expr(10);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(118);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(119); expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(121);
						((ComparisonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTE) | (1L << LTE) | (1L << EQ))) != 0)) ) {
							((ComparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(122); expr(8);
						}
						break;
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class SignedNumberContext extends ParserRuleContext {
		public TypeSpec type;
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public SignedNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterSignedNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitSignedNumber(this);
		}
	}

	public final SignedNumberContext signedNumber() throws RecognitionException {
		SignedNumberContext _localctx = new SignedNumberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_signedNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); sign();
			setState(129); number();
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

	public static class SignContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(JFlatParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(JFlatParser.ADD, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitSign(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class NumberContext extends ParserRuleContext {
		public TypeSpec type;
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class RealConstContext extends NumberContext {
		public TerminalNode REAL() { return getToken(JFlatParser.REAL, 0); }
		public RealConstContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterRealConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitRealConst(this);
		}
	}
	public static class IntConstContext extends NumberContext {
		public TerminalNode INT() { return getToken(JFlatParser.INT, 0); }
		public IntConstContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterIntConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitIntConst(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_number);
		try {
			setState(135);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133); match(INT);
				}
				break;
			case REAL:
				_localctx = new RealConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134); match(REAL);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<PrimTypeContext> primType() {
			return getRuleContexts(PrimTypeContext.class);
		}
		public TerminalNode IDENTIFIER(int i) {
			return getToken(JFlatParser.IDENTIFIER, i);
		}
		public PrimTypeContext primType(int i) {
			return getRuleContext(PrimTypeContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(JFlatParser.IDENTIFIER); }
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); match(T__2);
				setState(138); primType();
				setState(139); match(IDENTIFIER);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(140); match(T__0);
					setState(141); primType();
					setState(142); match(IDENTIFIER);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149); match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151); match(T__2);
				setState(152); match(T__1);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_args);
		int _la;
		try {
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); match(T__2);
				setState(156); expr(0);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(157); match(T__0);
					setState(158); expr(0);
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164); match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); match(T__2);
				setState(167); match(T__1);
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
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FullBlockContext extends BlockContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public FullBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterFullBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitFullBlock(this);
		}
	}
	public static class SimpBlockContext extends BlockContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public SimpBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterSimpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitSimpBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			setState(179);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new FullBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170); match(T__5);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << IF) | (1L << WHILE) | (1L << FUNCT) | (1L << VAR) | (1L << PRINT) | (1L << RETURN) | (1L << BOOL) | (1L << INT) | (1L << REAL) | (1L << ADD) | (1L << SUB) | (1L << SEPARATOR) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(171); stat();
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177); match(T__3);
				}
				break;
			case T__2:
			case IF:
			case WHILE:
			case FUNCT:
			case VAR:
			case PRINT:
			case RETURN:
			case BOOL:
			case INT:
			case REAL:
			case ADD:
			case SUB:
			case SEPARATOR:
			case IDENTIFIER:
				_localctx = new SimpBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(178); stat();
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

	public static class PrimTypeContext extends ParserRuleContext {
		public TypeSpec type;
		public PrimTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primType; }
	 
		public PrimTypeContext() { }
		public void copyFrom(PrimTypeContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	public static class TypeIntContext extends PrimTypeContext {
		public TerminalNode PINT() { return getToken(JFlatParser.PINT, 0); }
		public TypeIntContext(PrimTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitTypeInt(this);
		}
	}
	public static class TypeRealContext extends PrimTypeContext {
		public TerminalNode PREAL() { return getToken(JFlatParser.PREAL, 0); }
		public TypeRealContext(PrimTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterTypeReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitTypeReal(this);
		}
	}
	public static class TypeBoolContext extends PrimTypeContext {
		public TerminalNode PBOOL() { return getToken(JFlatParser.PBOOL, 0); }
		public TypeBoolContext(PrimTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterTypeBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitTypeBool(this);
		}
	}
	public static class TypeVoidContext extends PrimTypeContext {
		public TerminalNode PVOID() { return getToken(JFlatParser.PVOID, 0); }
		public TypeVoidContext(PrimTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).enterTypeVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JFlatListener ) ((JFlatListener)listener).exitTypeVoid(this);
		}
	}

	public final PrimTypeContext primType() throws RecognitionException {
		PrimTypeContext _localctx = new PrimTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primType);
		try {
			setState(185);
			switch (_input.LA(1)) {
			case PBOOL:
				_localctx = new TypeBoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181); match(PBOOL);
				}
				break;
			case PINT:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(182); match(PINT);
				}
				break;
			case PREAL:
				_localctx = new TypeRealContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(183); match(PREAL);
				}
				break;
			case PVOID:
				_localctx = new TypeVoidContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(184); match(PVOID);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 9);
		case 1: return precpred(_ctx, 8);
		case 2: return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u00be\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3C\n\3\f\3\16\3F\13\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3U\n\3\3\4\3\4"+
		"\3\4\7\4Z\n\4\f\4\16\4]\13\4\3\5\3\5\3\5\3\5\5\5c\n\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6s\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6~\n\6\f\6\16\6\u0081\13\6\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\5\t\u008a\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0093\n\n\f\n\16\n"+
		"\u0096\13\n\3\n\3\n\3\n\3\n\5\n\u009c\n\n\3\13\3\13\3\13\3\13\7\13\u00a2"+
		"\n\13\f\13\16\13\u00a5\13\13\3\13\3\13\3\13\3\13\5\13\u00ab\n\13\3\f\3"+
		"\f\7\f\u00af\n\f\f\f\16\f\u00b2\13\f\3\f\3\f\5\f\u00b6\n\f\3\r\3\r\3\r"+
		"\3\r\5\r\u00bc\n\r\3\r\2\3\n\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\4\2"+
		"\27\30\33\33\3\2\31\32\3\2\34 \u00d1\2\33\3\2\2\2\4T\3\2\2\2\6V\3\2\2"+
		"\2\bb\3\2\2\2\nr\3\2\2\2\f\u0082\3\2\2\2\16\u0085\3\2\2\2\20\u0089\3\2"+
		"\2\2\22\u009b\3\2\2\2\24\u00aa\3\2\2\2\26\u00b5\3\2\2\2\30\u00bb\3\2\2"+
		"\2\32\34\5\4\3\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2"+
		"\2\36\3\3\2\2\2\37 \5\n\6\2 !\7!\2\2!U\3\2\2\2\"#\7\t\2\2#$\7\6\2\2$%"+
		"\5\n\6\2%&\7\7\2\2&\'\5\26\f\2\'(\7\n\2\2()\5\26\f\2)U\3\2\2\2*+\7\t\2"+
		"\2+,\7\6\2\2,-\5\n\6\2-.\7\7\2\2./\5\26\f\2/U\3\2\2\2\60\61\7\13\2\2\61"+
		"\62\7\6\2\2\62\63\5\n\6\2\63\64\7\7\2\2\64\65\5\26\f\2\65U\3\2\2\2\66"+
		"\67\7\16\2\2\678\7\6\2\289\5\n\6\29:\7\7\2\2:;\7!\2\2;U\3\2\2\2<=\7\f"+
		"\2\2=>\5\30\r\2>?\7\"\2\2?@\5\22\n\2@D\7\3\2\2AC\5\4\3\2BA\3\2\2\2CF\3"+
		"\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\5\2\2HU\3\2\2\2IJ\7"+
		"\r\2\2JK\5\6\4\2KL\7!\2\2LU\3\2\2\2MU\7!\2\2NO\7\17\2\2OP\5\n\6\2PQ\7"+
		"!\2\2QU\3\2\2\2RS\7\17\2\2SU\7!\2\2T\37\3\2\2\2T\"\3\2\2\2T*\3\2\2\2T"+
		"\60\3\2\2\2T\66\3\2\2\2T<\3\2\2\2TI\3\2\2\2TM\3\2\2\2TN\3\2\2\2TR\3\2"+
		"\2\2U\5\3\2\2\2V[\5\b\5\2WX\7\b\2\2XZ\5\b\5\2YW\3\2\2\2Z]\3\2\2\2[Y\3"+
		"\2\2\2[\\\3\2\2\2\\\7\3\2\2\2][\3\2\2\2^c\7\"\2\2_`\7\"\2\2`a\7\4\2\2"+
		"ac\5\n\6\2b^\3\2\2\2b_\3\2\2\2c\t\3\2\2\2de\b\6\1\2ef\7\"\2\2fg\7\4\2"+
		"\2gs\5\n\6\3hi\7\"\2\2is\5\24\13\2js\7\"\2\2ks\5\20\t\2ls\5\f\7\2ms\7"+
		"\24\2\2no\7\6\2\2op\5\n\6\2pq\7\7\2\2qs\3\2\2\2rd\3\2\2\2rh\3\2\2\2rj"+
		"\3\2\2\2rk\3\2\2\2rl\3\2\2\2rm\3\2\2\2rn\3\2\2\2s\177\3\2\2\2tu\f\13\2"+
		"\2uv\t\2\2\2v~\5\n\6\fwx\f\n\2\2xy\t\3\2\2y~\5\n\6\13z{\f\t\2\2{|\t\4"+
		"\2\2|~\5\n\6\n}t\3\2\2\2}w\3\2\2\2}z\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080\13\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\5"+
		"\16\b\2\u0083\u0084\5\20\t\2\u0084\r\3\2\2\2\u0085\u0086\t\3\2\2\u0086"+
		"\17\3\2\2\2\u0087\u008a\7\25\2\2\u0088\u008a\7\26\2\2\u0089\u0087\3\2"+
		"\2\2\u0089\u0088\3\2\2\2\u008a\21\3\2\2\2\u008b\u008c\7\6\2\2\u008c\u008d"+
		"\5\30\r\2\u008d\u0094\7\"\2\2\u008e\u008f\7\b\2\2\u008f\u0090\5\30\r\2"+
		"\u0090\u0091\7\"\2\2\u0091\u0093\3\2\2\2\u0092\u008e\3\2\2\2\u0093\u0096"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u0098\7\7\2\2\u0098\u009c\3\2\2\2\u0099\u009a\7\6"+
		"\2\2\u009a\u009c\7\7\2\2\u009b\u008b\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\23\3\2\2\2\u009d\u009e\7\6\2\2\u009e\u00a3\5\n\6\2\u009f\u00a0\7\b\2"+
		"\2\u00a0\u00a2\5\n\6\2\u00a1\u009f\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\7\7\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00a9\7\6\2\2\u00a9\u00ab\7\7"+
		"\2\2\u00aa\u009d\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\25\3\2\2\2\u00ac\u00b0"+
		"\7\3\2\2\u00ad\u00af\5\4\3\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b6\7\5\2\2\u00b4\u00b6\5\4\3\2\u00b5\u00ac\3\2\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\27\3\2\2\2\u00b7\u00bc\7\20\2\2\u00b8\u00bc\7\21"+
		"\2\2\u00b9\u00bc\7\22\2\2\u00ba\u00bc\7\23\2\2\u00bb\u00b7\3\2\2\2\u00bb"+
		"\u00b8\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\31\3\2\2"+
		"\2\22\35DT[br}\177\u0089\u0094\u009b\u00a3\u00aa\u00b0\u00b5\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}