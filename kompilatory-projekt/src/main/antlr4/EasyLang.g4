grammar EasyLang;

/*
 * Lexer Rules
 */

T_END_LINE          : ('.');
T_INTEGER           : ('calkowity'|'całkowity');
T_STRING            : ('napis');
T_BOOL              : ('logiczny');
T_IF_CLAUSE         : ('jeżeli'|'jezeli');
T_ELSE_CLAUSE       : ('inaczej');
T_UNTIL_CLAUSE      : ('dopóki'|'dopoki');
T_AND               : ('oraz');
T_OR                : ('albo');
T_NOT               : ('nie');
T_ASTERISK          : '*';
T_SLASH             : '/';
T_PLUS              : '+';
T_MINUS             : '-';
T_COMMA             : ',';
T_LEQ               : '<=';
T_GEQ               : '>=';
T_L                 : '<';
T_G                 : '>';
T_NEQ               : '!=';
T_EQ                : '==';
T_LBRACKET          : '(';
T_RBRACKET          : ')';
T_LCURLYBRACKET     : '{';
T_RCURLYBRACKET     : '}';
T_EQUALS            : '=';
T_FUNCTION          : ('funkcja');
T_RETURN            : ('zwróć'|'zwroc');
T_PRINT             : ('wypisz');
T_START             : ('start');
T_COMMENT           :  '#'[a-zA-Z_ąćęłńóśźż0-9 \t\n;]*'#';
T_INTEGER_VAL       : [-]?[0-9]+;
T_BOOL_TRUE         : ( 'prawda');
T_BOOL_FALSE        : ('fałsz' | 'falsz');
T_STRING_VAL        : '"'[a-zA-Z_ąćęłńóśźż0-9 \t\n;]+'"';
T_ID                : [a-zA-Z_ąćęłńóśźż][a-zA-Z0-9_ąćęłńóśźż]*;
T_WHITESPACE        : (' ' | '\t' | '\n') -> skip ;


/*
 * Parser Rules
 */
start :
    program
    ;

program :
    function program
    | T_COMMENT program
    | startFunction EOF
    ;

code :
    expression T_END_LINE
    | expression T_END_LINE code
    | flowExpression
    | flowExpression code
    | T_COMMENT code
    ;

expression :
    varDeclaration
    | varExpression
    | printExpression
    | functionCall
    | logicalExpression
    ;

flowExpression :
    conditionalExpression
    | untilExpression
    ;

printExpression :
    T_PRINT T_LBRACKET value T_RBRACKET
    | T_PRINT T_LBRACKET T_ID T_RBRACKET
    ;

startFunction :
    T_START '()' T_LCURLYBRACKET code T_RCURLYBRACKET
    ;

bool_val :
    T_BOOL_TRUE
    | T_BOOL_FALSE
    ;

type :
    T_INTEGER
    | T_STRING
    | T_BOOL
    ;

value :
    T_INTEGER_VAL
    | T_STRING_VAL
    | bool_val
    ;

varDeclaration :
    type T_ID T_EQUALS factor
    | type T_ID
    ;

varExpression :
    T_ID T_EQUALS factor
    ;

factor :
    T_ID
    | value
    | arithmeticExpression
    ;

returnn :
    T_RETURN value T_END_LINE
    | T_RETURN T_ID T_END_LINE
    ;

function :
    T_FUNCTION type T_ID T_LBRACKET typedArgList T_RBRACKET T_LCURLYBRACKET code returnn T_RCURLYBRACKET
    ;

typedArgList :
    left=type T_ID T_COMMA right=typedArgList
    | type T_ID
    ;

argList :
    left=factor T_COMMA right=argList
    | factor
    ;

functionCall :
    T_ID T_LBRACKET argList T_RBRACKET
    ;

logicalExpression :
    '(' logicalExpression ')'                               # logicParenthesis
    | logicalExpression (T_AND|T_OR) logicalExpression      # logicAndOr
    | T_NOT logicalExpression                               # logicNot
    | compareExpression                                     # logicCompareExpr
    | functionCall                                          # logicFunctionCall
    | T_ID                                                  # logicId
    ;

arithmeticExpression :
    T_LBRACKET arithmeticExpression T_RBRACKET
    | arithmeticExpression (T_ASTERISK|T_SLASH) arithmeticExpression
    | arithmeticExpression (T_PLUS|T_MINUS) arithmeticExpression
    | T_INTEGER_VAL
    | T_ID
    ;

compareExpression :
    left=factor T_G right=factor
    | left=factor T_L right=factor
    | left=factor T_GEQ right=factor
    | left=factor T_LEQ right=factor
    | left=factor T_EQ right=factor
    | left=factor T_NEQ right=factor
    ;

conditionalExpression :
    T_IF_CLAUSE '(' logicalExpression ')' '{' code '}' T_ELSE_CLAUSE '{' code '}'
    | T_IF_CLAUSE '(' logicalExpression ')' '{' code '}' T_ELSE_CLAUSE conditionalExpression
    | T_IF_CLAUSE '(' logicalExpression ')' '{' code '}'
    ;

untilExpression :
    T_UNTIL_CLAUSE '(' logicalExpression ')' '{' code '}'
    ;