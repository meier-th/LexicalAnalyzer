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

    public String getLVal() {
        return "TODO";
    }

    public void yyerror(String error) {
     System.out.println(error);
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

{LeftParenthesis} { return LP;}
{LoopConditionKeyword} { return LCK;}
{Plus} {return PLUS;}
{Multiply} { return MUL;}
{Divide} { return DIV;}
{Less} { return LESS;}
{More} { return MORE;}
{Equal} { return EQ;}
{UnaryOperator} { /*TODO*/ }
<normal> {MinusSign} { return MIN;}
{AssignmentOperator} { return AO; }
{Comma} { /*TODO*/ }
{Comment} { return COM; }
{Keyword} { return KEY;}
{LoopStartKeyword} { return LDK;}
{Const} {/*yylval.CONST = Integer.valueOf(yytext());*/ return CONST;}
{Ident} { /*yylval.IDENT = yytext();*/ return IDENT;}
{wsnl} {}
<unary> {
    {MinusSign} {}
    {Const} {}
    {Ident} {}
    {Comma} {}
    {RightParenthesis} {}
    {LeftParenthesis} {}
}
. {System.err.printf("Error: unknown lexem %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
