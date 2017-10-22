// Generated from E:/ѧϰ/������/����������/KTest/src/main/java/com/cmm\CMinusMinus.g4 by ANTLR 4.7
package com.cmm.ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CMinusMinusParser}.
 */
public interface CMinusMinusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CMinusMinusParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CMinusMinusParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(CMinusMinusParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(CMinusMinusParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CMinusMinusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CMinusMinusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CMinusMinusParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CMinusMinusParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CMinusMinusParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CMinusMinusParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(CMinusMinusParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(CMinusMinusParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#sequenceStructure}.
	 * @param ctx the parse tree
	 */
	void enterSequenceStructure(CMinusMinusParser.SequenceStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#sequenceStructure}.
	 * @param ctx the parse tree
	 */
	void exitSequenceStructure(CMinusMinusParser.SequenceStructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#selectiveStructure}.
	 * @param ctx the parse tree
	 */
	void enterSelectiveStructure(CMinusMinusParser.SelectiveStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#selectiveStructure}.
	 * @param ctx the parse tree
	 */
	void exitSelectiveStructure(CMinusMinusParser.SelectiveStructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#cycleStructure}.
	 * @param ctx the parse tree
	 */
	void enterCycleStructure(CMinusMinusParser.CycleStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#cycleStructure}.
	 * @param ctx the parse tree
	 */
	void exitCycleStructure(CMinusMinusParser.CycleStructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStatement(CMinusMinusParser.DeclareStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStatement(CMinusMinusParser.DeclareStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(CMinusMinusParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(CMinusMinusParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(CMinusMinusParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(CMinusMinusParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(CMinusMinusParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(CMinusMinusParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(CMinusMinusParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(CMinusMinusParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(CMinusMinusParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(CMinusMinusParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(CMinusMinusParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(CMinusMinusParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CMinusMinusParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CMinusMinusParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(CMinusMinusParser.LogicalOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(CMinusMinusParser.LogicalOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(CMinusMinusParser.LogicalAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(CMinusMinusParser.LogicalAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpr(CMinusMinusParser.RelationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpr(CMinusMinusParser.RelationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CMinusMinusParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CMinusMinusParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CMinusMinusParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpr(CMinusMinusParser.ArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CMinusMinusParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpr(CMinusMinusParser.ArithmeticExprContext ctx);
}