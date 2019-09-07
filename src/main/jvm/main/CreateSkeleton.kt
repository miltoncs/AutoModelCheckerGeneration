package main

import antlr.aadl.*
import javaast.JavaFromAgreeNodes
import javaast.JavaFromAadlSystem
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import visitors.*
import javaast.JavaConstantLibrary.Companion.javaMemoryObjectClasses

fun createSkeleton(input: String): String {

    val lexer = AadlLexer(CharStreams.fromString(input))
    val tokens = CommonTokenStream(lexer)
    val parser = AadlParser(tokens)

    val tree = parser.aadl()

    val conditions = ConditionsVisitor().visit(tree)

    val structure: Map<AadlObjectName, AadlObject> = StructureVisitor().visit(tree).combineObjects().propagateConnections()

    val agreeVars: Map<AadlObjectName, List<AgreeValue>> = AgreePackageValuesVisitor().visit(tree)

    val translatedAgreeNodes = JavaFromAgreeNodes(AgreeNodeVisitor().visit(tree)).build()

    return JavaFromAadlSystem(structure, conditions, agreeVars).toString() + javaMemoryObjectClasses + translatedAgreeNodes
}
/*
TODO
finish up eq parsing/translation
 - grab just varname
 - Visit rh expression
 - pre() function gets an if statement
 - map number of lh operands to rh function returns, line for each
 */



