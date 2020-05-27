package parsing;
%%

%public
%class Lexer
%implements YYParser.Lexer
%unicode
%line
%column
%xstate unary
%state normal
%int

%{

    private Object lvalue;

    private String getHexRepresentation(String decRepresentation) {
        int value = Integer.parseInt(decRepresentation);
        return Integer.toString(value, 16);
    }

    public Object getLVal() {
        return lvalue;
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
{UnaryOperator} { return INV; }
<normal> {MinusSign} { return MIN;}
{AssignmentOperator} { return AO; }
{Comma} { return COM; }
{Comment} {}
{Keyword} { return KEY;}
{LoopStartKeyword} { return LDK;}
{Const} { lvalue = Integer.valueOf(yytext()); return CONST;}
{Ident} { lvalue = yytext(); return IDENT;}
{wsnl} {}
<unary> {
    {MinusSign} {return UMINUS; }
    {Const} { return CONST; }
    {Ident} { return IDENT; }
    {Comma} { return COM; }
    {RightParenthesis} { return RP; }
    {LeftParenthesis} { return LP; }
}
. {System.err.printf("Error: unknown lexem %s at line %d, char %d\n", yytext(), yyline + 1, yycolumn);}
