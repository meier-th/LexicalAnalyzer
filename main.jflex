import java.util.HashMap;
%%

%class Lexer
%unicode
%line
%standalone
%column

%{
    HashMap<String, String> lexemMap = new HashMap<>();
%}

Number = [0-9]+
String = [A-Za-z]+
Whitespace = [ \t]+
Newline = \n | \r | \r\n
Equals = "="
Assignment = {String}{Whitespace}*{Equals}{Whitespace}*{Number}
Comment = "//".*\n

%%

{Assignment} {System.out.printf("Assignment: %s\n", yytext());}
{Comment} {System.out.printf("Comment: %s\n", yytext());}
{Newline} {}
. {}