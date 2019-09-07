grammar Aadl;

@header {
    package antlr.aadl;
}

aadl: aadlPackage+;

aadlPackage: 'package' IDENTIFIER packageBody 'end' IDENTIFIER ';';
packageBody: 'public' withStatement* (object|typeAlias|agree_annex)*;
typeAlias: 'data' IDENTIFIER 'extends' type 'end' IDENTIFIER ';' ;
withStatement: 'with' IDENTIFIER ';';

var_list: var_declaration (',' var_declaration)* ;

agree_annex: ANNEX AGREE ANNEX_OPEN agree_node* ANNEX_CLOSE ';';
agree_node: 'node' IDENTIFIER '(' var_list ')' 'returns' '(' var_list ')' ';' 'let' node_body 'tel' ';' ;
node_body: (assignment ';')* ;


object: objectType 'implementation'? IDENTIFIER objectBody 'end' IDENTIFIER ';';
objectType: ('system') ;
objectBody: subcomponentsPart? featurePart? connectionsPart? annex?;
connectionsPart: 'connections' connection+ ;
connection: IDENTIFIER ':' 'port' IDENTIFIER '->' IDENTIFIER '{Communication_Properties::Timing => immediate;}'? ';' ;
featurePart: 'features' feature ;
subcomponentsPart: 'subcomponents' (subcomponent)+;
subcomponent: IDENTIFIER ':' objectType IDENTIFIER ';';
feature: (port)+ ;
port: IDENTIFIER ':' PORT_TYPE 'data' 'port' type ';';
annex: ANNEX (agreeBody) ;
agreeBody: AGREE ANNEX_OPEN agreeStatement* ANNEX_CLOSE ';' ;
agreeStatement: ( equation | constant | assume | guarantee | assign ) ';';
equation: 'eq' assignment;
constant: 'const' assignment ;
assign: 'assign' assignment ;
assignment: var_declaration (',' var_declaration)* (EQ expression)?;
var_declaration: IDENTIFIER (':' type)? ;
assume: 'assume' LITERAL_STRING ':' expression;
guarantee: 'guarantee' LITERAL_STRING ':' expression;
expression: leftHandSide (operation expression)?;
leftHandSide: (('(' expression ')') | value) ;
value: ('(' value ')') | BOOLEAN | NUM | LITERAL_STRING | IDENTIFIER | if_expression | function_call;
if_expression: 'if' expression 'then' expression 'else' expression ;
function_call: IDENTIFIER '(' expression? (',' expression)* ')' ;
type: IDENTIFIER ('::' IDENTIFIER)? ;
operation: '+' | '-' | '*' | '/' | '=>' | '->' | '>' | '<' | '<=' | '>=' | EQ | 'and' | 'or';

COMMENT: '--' ~[\n]* -> skip;
PORT_TYPE: ('in' | 'out') ;
LITERAL_STRING: '"' ~["]* '"' ;
EQ: '=';
AGREE: 'agree' ;
ANNEX: 'annex' ;
ANNEX_OPEN: '{**' ;
ANNEX_CLOSE: '**}' ;
BOOLEAN: 'true' | 'false';
NUM: '-'? [0-9]+('.'[0-9]+)?;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_.]*;
WS: [ \r\n\t] + -> skip;
