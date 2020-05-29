%language "Java"
%define package "parsing"
%define public

%code imports {

}

%token KEY COM AO LP RP LCK LDK MIN PLUS MUL DIV MORE LESS EQ INV UMINUS
%token <Integer> CONST
%token <String> IDENT
%type <ASTNode> program computations variablesDeclaration
%type <Operation> expression subexpression
%type <Variable> operand
%type <Assignment> assignment

%type <Operator> operator loopOperator
%type <VariablesDeclaration> variablesList

%left MIN PLUS MUL DIV
%start program

%%

program: variablesDeclaration computations {$$ = new ASTNode($1, $2);};
variablesDeclaration: KEY variablesList {$$ = new ASTNode(SemanticTypes.VARIABLES_DECLARATION);};
variablesList: IDENT {$$ = new Variable($1);} | IDENT COM variablesList;
computations: operator | operator operatorsList {$$ = new ASTNode(SemanticTypes.COMPUTATIONS);};
operator: assignment | loopOperator;
assignment: IDENT EQ expression {$$ = new Assignment();};
expression: INV subexpression {$$ = new UnaryOperation(UnaryOperations.NOT, $2);} |
            UMINUS subexpression {$$ = new UnaryOperation(UnaryOperations.MINUS, $2);} |
            subexpression {$$ = $1;};
subexpression: LP expression RP {$$ = $2;} | operand {$$ = new UnaryOperation($1);} |
subexpression MIN subexpression {$$ = new BinaryOperation($1, $3, Operations.SUBTRACTION);} |
subexpression PLUS subexpression {$$ = new BinaryOperation($1, $3, Operations.ADDITION);} |
subexpression MUL subexpression {$$ = new BinaryOperation($1, $3, Operations.MULTIPLICATION);} |
subexpression DIV subexpression {$$ = new BinaryOperation($1, $3, Operations.DIVISION);} |
subexpression LESS subexpression {$$ = new BinaryOperation($1, $3, Operations.LESSER);} |
subexpression MORE subexpression {$$ = new BinaryOperation($1, $3, Operations.GREATER);} |
subexpression EQ subexpression {$$ = new BinaryOperation($1, $3, Operations.EQUALS);}
;
operand: IDENT {$$ = new Variable($1);} | CONST {$$ = new Variable($1);};
loopOperator: LCK expression LDK operator;

%%
