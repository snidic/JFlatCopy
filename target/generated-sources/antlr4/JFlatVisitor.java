// Generated from JFlat.g4 by ANTLR 4.7.2

    import wci.intermediate.TypeSpec;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JFlatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JFlatVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JFlatParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(JFlatParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bareExpr}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBareExpr(JFlatParser.BareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(JFlatParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThen}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThen(JFlatParser.IfThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(JFlatParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(JFlatParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functDeclare}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctDeclare(JFlatParser.FunctDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varListDeclare}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarListDeclare(JFlatParser.VarListDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStat(JFlatParser.EmptyStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprReturn}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprReturn(JFlatParser.ExprReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyReturn}
	 * labeled alternative in {@link JFlatParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyReturn(JFlatParser.EmptyReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link JFlatParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(JFlatParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclare}
	 * labeled alternative in {@link JFlatParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclare(JFlatParser.VarDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclareAssign}
	 * labeled alternative in {@link JFlatParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclareAssign(JFlatParser.VarDeclareAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functApply}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctApply(JFlatParser.FunctApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(JFlatParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(JFlatParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(JFlatParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(JFlatParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signedNum}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNum(JFlatParser.SignedNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unsignNumber}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignNumber(JFlatParser.UnsignNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(JFlatParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(JFlatParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link JFlatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(JFlatParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JFlatParser#signedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNumber(JFlatParser.SignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link JFlatParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(JFlatParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intConst}
	 * labeled alternative in {@link JFlatParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConst(JFlatParser.IntConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realConst}
	 * labeled alternative in {@link JFlatParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealConst(JFlatParser.RealConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link JFlatParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(JFlatParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JFlatParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(JFlatParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullBlock}
	 * labeled alternative in {@link JFlatParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullBlock(JFlatParser.FullBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpBlock}
	 * labeled alternative in {@link JFlatParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpBlock(JFlatParser.SimpBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(JFlatParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(JFlatParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeReal}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReal(JFlatParser.TypeRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeVoid}
	 * labeled alternative in {@link JFlatParser#primType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVoid(JFlatParser.TypeVoidContext ctx);
}