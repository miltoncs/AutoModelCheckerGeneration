// Generated from /Users/mstafford/Projects/github.fit.edu/thesis/code/AADLTranslation/src/main/antlr/Aadl.g4 by ANTLR 4.7.2

    package antlr.aadl;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AadlParser}.
 */
public interface AadlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AadlParser#aadl}.
	 * @param ctx the parse tree
	 */
	void enterAadl(AadlParser.AadlContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#aadl}.
	 * @param ctx the parse tree
	 */
	void exitAadl(AadlParser.AadlContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#aadlPackage}.
	 * @param ctx the parse tree
	 */
	void enterAadlPackage(AadlParser.AadlPackageContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#aadlPackage}.
	 * @param ctx the parse tree
	 */
	void exitAadlPackage(AadlParser.AadlPackageContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#packageBody}.
	 * @param ctx the parse tree
	 */
	void enterPackageBody(AadlParser.PackageBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#packageBody}.
	 * @param ctx the parse tree
	 */
	void exitPackageBody(AadlParser.PackageBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#typeAlias}.
	 * @param ctx the parse tree
	 */
	void enterTypeAlias(AadlParser.TypeAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#typeAlias}.
	 * @param ctx the parse tree
	 */
	void exitTypeAlias(AadlParser.TypeAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(AadlParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(AadlParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#var_list}.
	 * @param ctx the parse tree
	 */
	void enterVar_list(AadlParser.Var_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#var_list}.
	 * @param ctx the parse tree
	 */
	void exitVar_list(AadlParser.Var_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#agree_annex}.
	 * @param ctx the parse tree
	 */
	void enterAgree_annex(AadlParser.Agree_annexContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#agree_annex}.
	 * @param ctx the parse tree
	 */
	void exitAgree_annex(AadlParser.Agree_annexContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#agree_node}.
	 * @param ctx the parse tree
	 */
	void enterAgree_node(AadlParser.Agree_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#agree_node}.
	 * @param ctx the parse tree
	 */
	void exitAgree_node(AadlParser.Agree_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#node_body}.
	 * @param ctx the parse tree
	 */
	void enterNode_body(AadlParser.Node_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#node_body}.
	 * @param ctx the parse tree
	 */
	void exitNode_body(AadlParser.Node_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(AadlParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(AadlParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#objectType}.
	 * @param ctx the parse tree
	 */
	void enterObjectType(AadlParser.ObjectTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#objectType}.
	 * @param ctx the parse tree
	 */
	void exitObjectType(AadlParser.ObjectTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#objectBody}.
	 * @param ctx the parse tree
	 */
	void enterObjectBody(AadlParser.ObjectBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#objectBody}.
	 * @param ctx the parse tree
	 */
	void exitObjectBody(AadlParser.ObjectBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#connectionsPart}.
	 * @param ctx the parse tree
	 */
	void enterConnectionsPart(AadlParser.ConnectionsPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#connectionsPart}.
	 * @param ctx the parse tree
	 */
	void exitConnectionsPart(AadlParser.ConnectionsPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#connection}.
	 * @param ctx the parse tree
	 */
	void enterConnection(AadlParser.ConnectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#connection}.
	 * @param ctx the parse tree
	 */
	void exitConnection(AadlParser.ConnectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#featurePart}.
	 * @param ctx the parse tree
	 */
	void enterFeaturePart(AadlParser.FeaturePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#featurePart}.
	 * @param ctx the parse tree
	 */
	void exitFeaturePart(AadlParser.FeaturePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#subcomponentsPart}.
	 * @param ctx the parse tree
	 */
	void enterSubcomponentsPart(AadlParser.SubcomponentsPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#subcomponentsPart}.
	 * @param ctx the parse tree
	 */
	void exitSubcomponentsPart(AadlParser.SubcomponentsPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#subcomponent}.
	 * @param ctx the parse tree
	 */
	void enterSubcomponent(AadlParser.SubcomponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#subcomponent}.
	 * @param ctx the parse tree
	 */
	void exitSubcomponent(AadlParser.SubcomponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(AadlParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(AadlParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(AadlParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(AadlParser.PortContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#annex}.
	 * @param ctx the parse tree
	 */
	void enterAnnex(AadlParser.AnnexContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#annex}.
	 * @param ctx the parse tree
	 */
	void exitAnnex(AadlParser.AnnexContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#agreeBody}.
	 * @param ctx the parse tree
	 */
	void enterAgreeBody(AadlParser.AgreeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#agreeBody}.
	 * @param ctx the parse tree
	 */
	void exitAgreeBody(AadlParser.AgreeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#agreeStatement}.
	 * @param ctx the parse tree
	 */
	void enterAgreeStatement(AadlParser.AgreeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#agreeStatement}.
	 * @param ctx the parse tree
	 */
	void exitAgreeStatement(AadlParser.AgreeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(AadlParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(AadlParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(AadlParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(AadlParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(AadlParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(AadlParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AadlParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AadlParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(AadlParser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(AadlParser.Var_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#assume}.
	 * @param ctx the parse tree
	 */
	void enterAssume(AadlParser.AssumeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#assume}.
	 * @param ctx the parse tree
	 */
	void exitAssume(AadlParser.AssumeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#guarantee}.
	 * @param ctx the parse tree
	 */
	void enterGuarantee(AadlParser.GuaranteeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#guarantee}.
	 * @param ctx the parse tree
	 */
	void exitGuarantee(AadlParser.GuaranteeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(AadlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(AadlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(AadlParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(AadlParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(AadlParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(AadlParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#if_expression}.
	 * @param ctx the parse tree
	 */
	void enterIf_expression(AadlParser.If_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#if_expression}.
	 * @param ctx the parse tree
	 */
	void exitIf_expression(AadlParser.If_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(AadlParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(AadlParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AadlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AadlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AadlParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(AadlParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AadlParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(AadlParser.OperationContext ctx);
}