grammar TheRealDealLang;

compileUnit:   (function_definition|statement)*  EOF;

statement :
        type=TYPE name=IDENTIFIER ASSIGN (expr)? SEMICOLON                                    # initStmt
    |   type=TYPE name=IDENTIFIER  SEMICOLON                                                  # varDeclStmt
    |   IDENTIFIER ASSIGN expr SEMICOLON                                                      # assignVarStmt
    |   RETURN_KEYWORD expr? SEMICOLON                                                        # returnStmt
    |   PRINT '('  expr ')' SEMICOLON                                                         # printCallStatement
    |   WHILE condition block                                                                 # whileStmt
    |   IF_KEYWORD ifCondition=condition trueBlock=block (ELSE_KEYWORD falseBlock=block)?     # ifStatement
    |   stmtExpr=expr SEMICOLON                                                               # exprStmt
    |   block                                                                                 # blockStmt
    ;

block:   '{' statement* '}';
function_body: '{' statement* '}';

expr
    :
        value=INT                                                                           # intExpr
    |   value=DOUBLE                                                                        # doubleExpr
    |   value=(TRUE|FALSE)                                                                  # booleanExpr
    |   value=IDENTIFIER                                                                    # variableExpr
    |   '(' expr ')'                                                                        # parensExpr
    |   IDENTIFIER '(' expression_list? ')'                                                 # funcExpr
    |   left=expr op=(MUL|DIVIDE) right=expr                                                # exMulExpr
    |   left=expr op=(ADD | SUB) right=expr                                                 # addsubExpr
    |   left=expr cpr=(BIGGER_THEN|SMALLER_THEN) right=expr                                 # compareExpr
    |   left=expr cpr=(NOT_EQUALS|EQUALS) right=expr                                        # equalExpr
    |   left=expr op=AND right=expr                                                         # logicalExpr
    |   left=expr op=OR right=expr                                                          # logicalExpr
    | TEXT_VALUE                                                                            # textExpr
    | SCANNER                                                                               # scannerExpr
    ;

LineComment:    '//' ~( '\r' | '\n' )* ( '\r'? '\n' | EOF )     ;
condition           : '(' expr')';
function_definition: TYPE IDENTIFIER '(' argument_list? ')' function_body;
argument_list: declaration (',' declaration)*;
declaration:   TYPE IDENTIFIER;
expression_list: expr (',' expr)*;

MUL         : '*';
ADD         : '+';
SUB         : '-';
BIGGER_THEN   : '>';
SMALLER_THEN     : '<';
EQUALS         : '==';
ASSIGN         : '=';
NOT_EQUALS     : '!=';
DIVIDE         : '/';
OR             : '||';
AND            : '&&';
COMMA    : ',';
SEMICOLON: ';';
SCANNER             : 'scanInt()'
                    | 'scanText()'
                    | 'scanBoolean()'
                    | 'scanDouble()';
START_BLOCK : '{';
END_BLOCK   : '}';
PRINT               : 'print';
TRUE : 'true';
FALSE: 'false';
QUOTE               : '"';
DOUBLE_SEP: '.';
VOID_KEYWORD    : 'void';
TYPE            : INT_KEYWORD|DOUBLE_KEYWORD|BOOLEAN_KEYWORD|TEXT_KEYWORD|VOID_KEYWORD;
WHILE   : 'while';
IF_KEYWORD      : 'if';
ELSE_KEYWORD    : 'else';
INT_KEYWORD     : 'int';
DOUBLE_KEYWORD  : 'double';
BOOLEAN_KEYWORD : 'boolean';
TEXT_KEYWORD:       'Text';
RETURN_KEYWORD  : 'return';


IDENTIFIER     :   [a-zA-Z][a-zA-Z0-9]*;
INT    :   [0-9]+;
TEXT_VALUE :QUOTE ~('\r' | '\n' | '"')*QUOTE;
DOUBLE :   [0-9]+ DOUBLE_SEP [0-9]+;
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);
WS: [\r\n\t ]+ -> skip;

STRING: '"' (ESC|.)*? '"' ;
ESC : '\\"' | '\\\\' ;
