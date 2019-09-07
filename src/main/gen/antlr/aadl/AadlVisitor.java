// Generated from /Users/mstafford/Projects/github.fit.edu/thesis/code/AADLTranslation/src/main/antlr/Aadl.g4 by ANTLR 4.7.2

    package antlr.aadl;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AadlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AadlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AadlParser#aadl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAadl(AadlParser.AadlContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#aadlPackage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAadlPackage(AadlParser.AadlPackageContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#packageBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageBody(AadlParser.PackageBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#typeAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAlias(AadlParser.TypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(AadlParser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#var_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_list(AadlParser.Var_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#agree_annex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgree_annex(AadlParser.Agree_annexContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#agree_node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgree_node(AadlParser.Agree_nodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#node_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode_body(AadlParser.Node_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(AadlParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#objectType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectType(AadlParser.ObjectTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#objectBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBody(AadlParser.ObjectBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#connectionsPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectionsPart(AadlParser.ConnectionsPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#connection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnection(AadlParser.ConnectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#featurePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeaturePart(AadlParser.FeaturePartContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#subcomponentsPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubcomponentsPart(AadlParser.SubcomponentsPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#subcomponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubcomponent(AadlParser.SubcomponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(AadlParser.FeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#port}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort(AadlParser.PortContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#annex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnex(AadlParser.AnnexContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#agreeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreeBody(AadlParser.AgreeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#agreeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgreeStatement(AadlParser.AgreeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(AadlParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(AadlParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(AadlParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AadlParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#var_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_declaration(AadlParser.Var_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#assume}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssume(AadlParser.AssumeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#guarantee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuarantee(AadlParser.GuaranteeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AadlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(AadlParser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(AadlParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#if_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expression(AadlParser.If_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(AadlParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(AadlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AadlParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(AadlParser.OperationContext ctx);
}