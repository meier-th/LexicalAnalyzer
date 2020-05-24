%language "Java"

%code imports {

}

%token KEY, COM, AO, LP, RP, IDENT, CONST, LCK, LDK, MIN, PLUS, MUL, DIV,
MORE, LESS, EQ, INV, UMINUS
%token <Integer> CONST
%token <String> IDENT
%left MIN PLUS
%left MUL DIV
%start program

%%

program: variablesDeclaration computations;
computations: operatorsList;
variablesDeclaration: KEY variablesList;
variablesList: ident | ident COM variablesList;
operatorsList: operator | operator operatorsList;
operator: assignment | loopOperator;
assignment: ident EQ expression;
expression: unaryOperator subexpression | subexpression;
subexpression: LP expression RP | operand | subexpression binaryOperator subexpression;
operand: IDENT | CONST;
loopOperator: LCK expression LDK operator;

%%

