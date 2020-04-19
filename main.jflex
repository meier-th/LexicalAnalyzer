
%%

%class Lexer
%unicode
%line
%standalone
%column
%state unary, normal

ws = [ \t]
nl = \n | \r | \r\n
wsnl = {ws} | {nl}

BinaryOperator = "+" | "*" | "/" | "<" | ">" | "=="
UnaryOperator = "not"
MinusSign = "-"
AssignmentOperator = "="
Separator = [),]
SeparatorBeforeUnary = "("
Comment = "//"[^\n]*\n
Keyword = "Var" | "DO"
KeywordBeforeUnary = "WHILE"
Const = [0-9]+
Ident = [A-Za-z]+

%%

{SeparatorBeforeUnary} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline, yycolumn); yybegin(unary);}
{KeywordBeforeUnary} {System.out.printf("Keyword %s at line %d, char %d\n", yytext(), yyline, yycolumn); yybegin(unary);}
{BinaryOperator} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
{UnaryOperator} {System.out.printf("Unary operator %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
<normal> {MinusSign} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
{AssignmentOperator} {System.out.printf("Assignment operator %s at line %d, char %d\n", yytext(), yyline, yycolumn); yybegin(unary);}
{Separator} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
{Comment} {System.out.printf("Comment %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
{Keyword} {System.out.printf("Keyword %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
{Const} {System.out.printf("Const %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
{Ident} {System.out.printf("Ident %s at line %d, char %d\n", yytext(), yyline, yycolumn);}
{wsnl} {}
<unary> {
    {MinusSign} {System.out.printf("Unary operator sign %s at line %d, char %d\n", yytext(), yyline, yycolumn); yybegin(normal);}
    {Const} {System.out.printf("Const %s at line %d, char %d\n", yytext(), yyline, yycolumn); yybegin(normal);}
    {Ident} {System.out.printf("Ident %s at line %d, char %d\n", yytext(), yyline, yycolumn); yybegin(normal);}
    {Separator} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline, yycolumn); yybegin(normal);}
}
. {System.out.printf("Error: unknown lexem %s at line %d, char %d\n", yytext(), yyline, yycolumn);}