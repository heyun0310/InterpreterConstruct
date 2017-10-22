// Generated from E:/学习/大三上/解释器构造/KTest/src/main/java/com/cmm\CMinusMinus.g4 by ANTLR 4.7
package com.cmm;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CMinusMinusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CMinusMinusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(CMinusMinusParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(CMinusMinusParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CMinusMinusParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(CMinusMinusParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(CMinusMinusParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(CMinusMinusParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#sequenceStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceStructure(CMinusMinusParser.SequenceStructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#selectiveStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectiveStructure(CMinusMinusParser.SelectiveStructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#cycleStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleStructure(CMinusMinusParser.CycleStructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#declareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStatement(CMinusMinusParser.DeclareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(CMinusMinusParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(CMinusMinusParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(CMinusMinusParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(CMinusMinusParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(CMinusMinusParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(CMinusMinusParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CMinusMinusParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpr(CMinusMinusParser.LogicalOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpr(CMinusMinusParser.LogicalAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpr(CMinusMinusParser.RelationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CMinusMinusParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CMinusMinusParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpr(CMinusMinusParser.ArithmeticExprContext ctx);
}