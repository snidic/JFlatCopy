// Generated from JFlat.g4 by ANTLR 4.4

    import wci.intermediate.TypeSpec;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JFlatParser}.
 */
public interface JFlatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code simpBlock}
	 * labeled alternative in {@link JFlatParser#block}.
	 * @param ctx the parse tree
	 */
	void enterSimpBlock(@NotNull JFlatParser.SimpBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpBlock}
	 * labeled alternative in {@link JFlatParser#block}.
	 * @param ctx the parse tree
	 */
	void exitSimpBlock(@NotNull JFlatParser.SimpBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(@NotNull JFlatParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(@NotNull JFlatParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link JFlatParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(@NotNull JFlatParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link JFlatParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(@NotNull JFlatParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(@NotNull JFlatParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(@NotNull JFlatParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile(@NotNull JFlatParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile(@NotNull JFlatParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprReturn}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprReturn(@NotNull JFlatParser.ExprReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprReturn}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprReturn(@NotNull JFlatParser.ExprReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functApply}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctApply(@NotNull JFlatParser.FunctApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functApply}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctApply(@NotNull JFlatParser.FunctApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullBlock}
	 * labeled alternative in {@link JFlatParser#block}.
	 * @param ctx the parse tree
	 */
	void enterFullBlock(@NotNull JFlatParser.FullBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullBlock}
	 * labeled alternative in {@link JFlatParser#block}.
	 * @param ctx the parse tree
	 */
	void exitFullBlock(@NotNull JFlatParser.FullBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JFlatParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void enterSignedNumber(@NotNull JFlatParser.SignedNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link JFlatParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void exitSignedNumber(@NotNull JFlatParser.SignedNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeReal}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void enterTypeReal(@NotNull JFlatParser.TypeRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeReal}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void exitTypeReal(@NotNull JFlatParser.TypeRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functDeclare}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFunctDeclare(@NotNull JFlatParser.FunctDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functDeclare}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFunctDeclare(@NotNull JFlatParser.FunctDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realConst}
	 * labeled alternative in {@link JFlatParser#number}.
	 * @param ctx the parse tree
	 */
	void enterRealConst(@NotNull JFlatParser.RealConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realConst}
	 * labeled alternative in {@link JFlatParser#number}.
	 * @param ctx the parse tree
	 */
	void exitRealConst(@NotNull JFlatParser.RealConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(@NotNull JFlatParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(@NotNull JFlatParser.EmptyStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeVoid}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void enterTypeVoid(@NotNull JFlatParser.TypeVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeVoid}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void exitTypeVoid(@NotNull JFlatParser.TypeVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyReturn}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterEmptyReturn(@NotNull JFlatParser.EmptyReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyReturn}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitEmptyReturn(@NotNull JFlatParser.EmptyReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclareAssign}
	 * labeled alternative in {@link JFlatParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclareAssign(@NotNull JFlatParser.VarDeclareAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclareAssign}
	 * labeled alternative in {@link JFlatParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclareAssign(@NotNull JFlatParser.VarDeclareAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(@NotNull JFlatParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(@NotNull JFlatParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(@NotNull JFlatParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(@NotNull JFlatParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code signedNum}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSignedNum(@NotNull JFlatParser.SignedNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code signedNum}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSignedNum(@NotNull JFlatParser.SignedNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElse(@NotNull JFlatParser.IfThenElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElse(@NotNull JFlatParser.IfThenElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varListDeclare}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVarListDeclare(@NotNull JFlatParser.VarListDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varListDeclare}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVarListDeclare(@NotNull JFlatParser.VarListDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(@NotNull JFlatParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(@NotNull JFlatParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifThen}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfThen(@NotNull JFlatParser.IfThenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifThen}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfThen(@NotNull JFlatParser.IfThenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intConst}
	 * labeled alternative in {@link JFlatParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntConst(@NotNull JFlatParser.IntConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intConst}
	 * labeled alternative in {@link JFlatParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntConst(@NotNull JFlatParser.IntConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link JFlatParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(@NotNull JFlatParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JFlatParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(@NotNull JFlatParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(@NotNull JFlatParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(@NotNull JFlatParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link JFlatParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull JFlatParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link JFlatParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull JFlatParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(@NotNull JFlatParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(@NotNull JFlatParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bareExpr}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBareExpr(@NotNull JFlatParser.BareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bareExpr}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBareExpr(@NotNull JFlatParser.BareExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JFlatParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(@NotNull JFlatParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JFlatParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(@NotNull JFlatParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull JFlatParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull JFlatParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull JFlatParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull JFlatParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(@NotNull JFlatParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(@NotNull JFlatParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link JFlatParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(@NotNull JFlatParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JFlatParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(@NotNull JFlatParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclare}
	 * labeled alternative in {@link JFlatParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclare(@NotNull JFlatParser.VarDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclare}
	 * labeled alternative in {@link JFlatParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclare(@NotNull JFlatParser.VarDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unsignNumber}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnsignNumber(@NotNull JFlatParser.UnsignNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unsignNumber}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnsignNumber(@NotNull JFlatParser.UnsignNumberContext ctx);
}