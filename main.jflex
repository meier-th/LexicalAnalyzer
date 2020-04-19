
%%

%class Lexer
%unicode
%line
%standalone
%column

Program = {VariablesDeclaration}{wsnl}+{Computations}
Computations = {OperatorsList}
OperatorsList = {Operator} | {Operator}{wsnl}+{OperatorsList}
VariablesList = {Ident} | {Ident}{wsnl}*","{VariablesList}
VariablesDeclaration = "Var"{wsnl}+{VariablesList}

Const = [0-9]+
Ident = [A-Za-z]+
ws = [ \t]
nl = \n | \r | \r\n
wsnl = {ws} | {nl}

Operand = {Ident} | {Const}
BinaryOperator = "-" | "+" | "*" | "/" | "<" | ">" | "=="
UnaryOperator = "-" | "not"
Expression = {UnaryOperator} {wsnl}+ {Subexpression} | {Subexpression}
Subexpression = "("{wsnl}* {Expression} {wsnl}*")" | {Operand} | {Subexpression}{wsnl}*{BinaryOperator}{wsnl}*{Subexpression}
Assignment = {Ident}{wsnl}*"="{wsnl}*{Expression}
Operator = {Assignment} | {ComplexOperator}
ComplexOperator = "WHILE" {wsnl}+{Expression}{wsnl}+"DO"{wsnl}+{Operator}
Comment = "//"[^\n]*\n

%%

{Program} {System.out.println(yytext());}
. {}