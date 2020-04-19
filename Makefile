all : Lexer.class

run: Lexer.class example
	java Lexer example

Lexer.class : Lexer.java
	javac Lexer.java

Lexer.java : main.jflex
	jflex main.jflex

clean: 
	rm Lexer.class
	rm Lexer.java
