%language "Java"
%define package "parsing"
%define public

%code imports {

}

%token KEY COM AO LP RP LCK LDK MIN PLUS MUL DIV MORE LESS EQ INV UMINUS
%token <Integer> CONST
%token <String> IDENT
%type <Expression> expression subexpression
%type <Operand> operand
%type <Operator> operator loopOperator
%type <ASTNode> program computations variablesDeclaration
%type <VariablesList> variablesList

%left MIN PLUS MUL DIV
%start program

%%

program: variablesDeclaration computations {$$ = new ASTNode($1, $2);};
variablesDeclaration: KEY variablesList {$$ = new ASTNode(SemanticTypes.VARIABLES_DECLARATION);};
variablesList: IDENT {$$ = new Variable($1);} | IDENT COM variablesList;
computations: operator | operator operatorsList {$$ = new ASTNode(SemanticTypes.COMPUTATIONS);};
operator: assignment | loopOperator;
assignment: IDENT EQ expression;
expression: INV subexpression |
            UMINUS subexpression | 
            subexpression;
subexpression: LP expression RP | operand | 
subexpression MIN subexpression
subexpression PLUS subexpression
subexpression MUL subexpression
subexpression DIV subexpression
subexpression LESS subexpression
subexpression MORE subexpression
subexpression EQ subexpression
;
operand: IDENT {$$ = $1;} | CONST {$$ = $1;};
loopOperator: LCK expression LDK operator;

%%
