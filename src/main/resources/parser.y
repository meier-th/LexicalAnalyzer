%language "Java"
%define package "parsing"
%define public

%code imports {
	import semantics.*;
	import state.*;
	import value.*;
}

%token KEY COM AO LP RP LCK LDK MIN PLUS MUL DIV MORE LESS EQ INV UMINUS
%token <Integer> CONST
%token <String> IDENT
%type <Program> program
%type <SemanticList> computations variablesDeclaration
%type <Operation> expression subexpression
%type <Variable> operand variablesList

%type <Operator> operator assignment loopOperator operatorsList

%left MIN PLUS MUL DIV
%start program

%%

program: variablesDeclaration computations {$$ = new Program($1, $2);};
variablesDeclaration: KEY variablesList {$$ = new SemanticList(SemanticList.SemanticTypes.VARIABLES_DECLARATION, $2);};
variablesList: IDENT {$$ = Variable.createVariable($1);} | IDENT COM variablesList {$$ = Variable.createVariable($1, $3);};
computations: operatorsList {$$ = new SemanticList(SemanticList.SemanticTypes.COMPUTATIONS, $1);};
operatorsList: operator {$$ = $1;} | operator operatorsList {$$ = $1; ((Operator)$$).setNext($2);};
operator: assignment {$$ = $1;} | loopOperator {$$ = $1;};
assignment: IDENT EQ expression {$$ = new Assignment($1, $3);};
expression: INV subexpression {$$ = new UnaryOperation(Operation.UnaryOperations.NOT, $2);} |
            UMINUS subexpression {$$ = new UnaryOperation(Operation.UnaryOperations.MINUS, $2);} |
            subexpression {$$ = $1;};
subexpression: LP expression RP {$$ = $2;} | operand {$$ = new UnaryOperation($1);} |
subexpression MIN subexpression {$$ = new BinaryOperation($1, $3, Operation.Operations.SUBTRACTION);} |
subexpression PLUS subexpression {$$ = new BinaryOperation($1, $3, Operation.Operations.ADDITION);} |
subexpression MUL subexpression {$$ = new BinaryOperation($1, $3, Operation.Operations.MULTIPLICATION);} |
subexpression DIV subexpression {$$ = new BinaryOperation($1, $3, Operation.Operations.DIVISION);} |
subexpression LESS subexpression {$$ = new BinaryOperation($1, $3, Operation.Operations.LESSER);} |
subexpression MORE subexpression {$$ = new BinaryOperation($1, $3, Operation.Operations.GREATER);} |
subexpression EQ subexpression {$$ = new BinaryOperation($1, $3, Operation.Operations.EQUALS);}
;
operand: IDENT {$$ = Variable.getVariable($1);} | CONST {$$ = Variable.createLiteral($1);};
loopOperator: LCK expression LDK operator {$$ = new LoopOperator($2, $4);};

%%
