%%

%class Lexer
%implements YYParser.Lexer
%unicode
%line
%standalone
%column
%xstate unary
%state normal

%{
    private String getHexRepresentation(String decRepresentation) {
        int value = Integer.parseInt(decRepresentation);
        return Integer.toString(value, 16);
    }
%}

ws = [ \t]
nl = \n | \r | \r\n
wsnl = {ws} | {nl}

Plus = "+"
Multiply = "*"
Divide = "/"
Less = "<"
More = ">"
Equal = "=="
UnaryOperator = "not"
MinusSign = "-"
AssignmentOperator = "="
RightParenthesis = ")"
Comma = ","
LeftParenthesis = "("
Comment = "//"[^\n]*\n
Keyword = "Var"
LoopStartKeyword = "DO"
LoopConditionKeyword = "WHILE"
Const = [0-9]+
Ident = [A-Za-z]+

%%

{LeftParenthesis} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(unary);}
{LoopConditionKeyword} {System.out.printf("Keyword %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(unary);}
{Plus} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{Multiply} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{Divide} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{Less} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{More} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{Equal} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{UnaryOperator} {System.out.printf("Unary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
<normal> {MinusSign} {System.out.printf("Binary operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{AssignmentOperator} {System.out.printf("Assignment operator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(unary);}
{Comma} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{Comment} {System.out.printf("Comment %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{Keyword} {System.out.printf("Keyword %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{LoopStartKeyword} {System.out.printf("Keyword %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{Const} {System.out.printf("Const %s at line %d, char %d. HEX representation: %s\n", yytext(), yyline + 1, yycolumn, getHexRepresentation(yytext()));}
{Ident} {System.out.printf("Ident %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
{wsnl} {}
<unary> {
    {MinusSign} {System.out.printf("Unary operator sign %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(normal);}
    {Const} {System.out.printf("Const %s at line %d, char %d. HEX representation: %s\n", yytext(), yyline + 1, yycolumn, getHexRepresentation(yytext())); yybegin(normal);}
    {Ident} {System.out.printf("Ident %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(normal);}
    {Comma} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(normal);}
    {RightParenthesis} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(normal);}
    {LeftParenthesis} {System.out.printf("Separator %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn); yybegin(unary);}
}
. {System.err.printf("Error: unknown lexem %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
