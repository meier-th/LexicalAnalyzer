/* A Bison parser, made by GNU Bison 3.3.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

package parsing;



/* "%code imports" blocks.  */
/* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":5  */ /* lalr1.java:92  */

	import semantics.*;
	import state.*;
	import value.*;

/* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/java/parsing/YYParser.java":45  */ /* lalr1.java:92  */

/**
 * A Bison parser, automatically generated from <tt>/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class YYParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.3.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>YYParser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int KEY = 258;
    /** Token number,to be returned by the scanner.  */
    static final int COM = 259;
    /** Token number,to be returned by the scanner.  */
    static final int AO = 260;
    /** Token number,to be returned by the scanner.  */
    static final int LP = 261;
    /** Token number,to be returned by the scanner.  */
    static final int RP = 262;
    /** Token number,to be returned by the scanner.  */
    static final int LCK = 263;
    /** Token number,to be returned by the scanner.  */
    static final int LDK = 264;
    /** Token number,to be returned by the scanner.  */
    static final int MIN = 265;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 266;
    /** Token number,to be returned by the scanner.  */
    static final int MUL = 267;
    /** Token number,to be returned by the scanner.  */
    static final int DIV = 268;
    /** Token number,to be returned by the scanner.  */
    static final int MORE = 269;
    /** Token number,to be returned by the scanner.  */
    static final int LESS = 270;
    /** Token number,to be returned by the scanner.  */
    static final int EQ = 271;
    /** Token number,to be returned by the scanner.  */
    static final int INV = 272;
    /** Token number,to be returned by the scanner.  */
    static final int CONST = 273;
    /** Token number,to be returned by the scanner.  */
    static final int IDENT = 274;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public YYParser (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }


  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yy_lr_goto_state_ (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
          case 2:
  if (yyn == 2)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":27  */ /* lalr1.java:480  */
    {yyval = new Program(((SemanticList)(yystack.valueAt (1))), ((SemanticList)(yystack.valueAt (0)))); ((Program)yyval).print(""); VariablesState.printVariables();};
  break;
    

  case 3:
  if (yyn == 3)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":28  */ /* lalr1.java:480  */
    {yyval = new SemanticList(SemanticList.SemanticTypes.VARIABLES_DECLARATION, ((Variable)(yystack.valueAt (0))));};
  break;
    

  case 4:
  if (yyn == 4)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":29  */ /* lalr1.java:480  */
    {yyval = Variable.createVariable(((String)(yystack.valueAt (0))));};
  break;
    

  case 5:
  if (yyn == 5)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":29  */ /* lalr1.java:480  */
    {yyval = Variable.createVariable(((String)(yystack.valueAt (2))), ((Variable)(yystack.valueAt (0))));};
  break;
    

  case 6:
  if (yyn == 6)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":30  */ /* lalr1.java:480  */
    {yyval = new SemanticList(SemanticList.SemanticTypes.COMPUTATIONS, ((OperatorsList)(yystack.valueAt (0))));};
  break;
    

  case 7:
  if (yyn == 7)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":31  */ /* lalr1.java:480  */
    {yyval = new OperatorsList(((Operator)(yystack.valueAt (0))));};
  break;
    

  case 8:
  if (yyn == 8)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":31  */ /* lalr1.java:480  */
    {yyval = new OperatorsList(((Operator)(yystack.valueAt (1))), ((OperatorsList)(yystack.valueAt (0))));};
  break;
    

  case 9:
  if (yyn == 9)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":32  */ /* lalr1.java:480  */
    {yyval = new Assignment(((String)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0)))); OperationsHolder.addAssignment((Assignment)yyval);};
  break;
    

  case 10:
  if (yyn == 10)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":33  */ /* lalr1.java:480  */
    {yyval = new LoopOperator(((Operation)(yystack.valueAt (2))), ((Operator)(yystack.valueAt (0)))); ((LoopOperator)yyval).execute();};
  break;
    

  case 11:
  if (yyn == 11)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":34  */ /* lalr1.java:480  */
    {yyval = new UnaryOperation(Operation.UnaryOperations.NOT, ((Operation)(yystack.valueAt (0))));};
  break;
    

  case 12:
  if (yyn == 12)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":35  */ /* lalr1.java:480  */
    {yyval = new UnaryOperation(Operation.UnaryOperations.MINUS, ((Operation)(yystack.valueAt (0))));};
  break;
    

  case 13:
  if (yyn == 13)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":36  */ /* lalr1.java:480  */
    {yyval = ((Operation)(yystack.valueAt (0)));};
  break;
    

  case 14:
  if (yyn == 14)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":37  */ /* lalr1.java:480  */
    {yyval = ((Operation)(yystack.valueAt (1)));};
  break;
    

  case 15:
  if (yyn == 15)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":37  */ /* lalr1.java:480  */
    {yyval = new UnaryOperation(((Variable)(yystack.valueAt (0))));};
  break;
    

  case 16:
  if (yyn == 16)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":38  */ /* lalr1.java:480  */
    {yyval = new BinaryOperation(((Operation)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0))), Operation.Operations.SUBTRACTION);};
  break;
    

  case 17:
  if (yyn == 17)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":39  */ /* lalr1.java:480  */
    {yyval = new BinaryOperation(((Operation)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0))), Operation.Operations.ADDITION);};
  break;
    

  case 18:
  if (yyn == 18)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":40  */ /* lalr1.java:480  */
    {yyval = new BinaryOperation(((Operation)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0))), Operation.Operations.MULTIPLICATION);};
  break;
    

  case 19:
  if (yyn == 19)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":41  */ /* lalr1.java:480  */
    {yyval = new BinaryOperation(((Operation)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0))), Operation.Operations.DIVISION);};
  break;
    

  case 20:
  if (yyn == 20)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":42  */ /* lalr1.java:480  */
    {yyval = new BinaryOperation(((Operation)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0))), Operation.Operations.LESSER);};
  break;
    

  case 21:
  if (yyn == 21)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":43  */ /* lalr1.java:480  */
    {yyval = new BinaryOperation(((Operation)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0))), Operation.Operations.GREATER);};
  break;
    

  case 22:
  if (yyn == 22)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":44  */ /* lalr1.java:480  */
    {yyval = new BinaryOperation(((Operation)(yystack.valueAt (2))), ((Operation)(yystack.valueAt (0))), Operation.Operations.EQUALS);};
  break;
    

  case 23:
  if (yyn == 23)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":46  */ /* lalr1.java:480  */
    {yyval = Variable.getVariable(((String)(yystack.valueAt (0))));};
  break;
    

  case 24:
  if (yyn == 24)
    /* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":46  */ /* lalr1.java:480  */
    {yyval = Variable.createLiteral(((Integer)(yystack.valueAt (0))));};
  break;
    


/* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/java/parsing/YYParser.java":505  */ /* lalr1.java:480  */
        default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }



  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
                                 Object yyvaluep                                 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
              + yytname_[yytype] + " ("
              + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
   public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {


            yycdebug ("Reading a token: ");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        if (yychar <= Lexer.EOF)
          {
            yychar = yytoken = Lexer.EOF;
            yycdebug ("Now at end of input.\n");
          }
        else
          {
            yytoken = yytranslate_ (yychar);
            yy_symbol_print ("Next token is", yytoken,
                             yylval);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yy_table_value_is_error_ (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            yy_symbol_print ("Shifting", yytoken,
                             yylval);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
        /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

        if (yychar <= Lexer.EOF)
          {
          /* Return failure if at end of input.  */
          if (yychar == Lexer.EOF)
            return false;
          }
        else
            yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:

        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                yyn += yyterror_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (yydebug > 0)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
                         yylval);

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final byte yypact_ninf_ = -15;
  private static final byte yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte yypact_[] = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
       1,   -11,     9,    -6,     8,   -15,   -15,    15,    19,   -15,
     -15,    -6,   -11,    15,     4,     4,   -15,   -15,    17,    25,
     -15,    15,   -15,   -15,    20,    25,    25,    -6,     4,     4,
       4,     4,     4,     4,     4,   -15,   -15,   -15,    -9,    -9,
      -9,    -9,    25,    25,    25
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,     0,     0,     0,     4,     3,     1,     0,     0,     2,
       6,     7,     0,     0,     0,     0,    24,    23,     0,    13,
      15,     0,     8,     5,     0,    12,    11,     0,     0,     0,
       0,     0,     0,     0,     0,     9,    14,    10,    16,    17,
      18,    19,    21,    20,    22
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -15,   -15,   -15,    16,   -15,    18,     3,   -10,   -14,   -15
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte yydefgoto_[] = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
      -1,     2,     3,     5,     9,    10,    11,    18,    19,    20
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte yytable_[] = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      25,    26,     7,    24,     1,    32,    33,    34,     4,     6,
      13,    35,    12,     8,    38,    39,    40,    41,    42,    43,
      44,    13,    16,    17,    21,    14,    27,    36,    23,    22,
      37,     0,    15,    16,    17,    28,    29,    30,    31,    32,
      33,    34
    };
  }

private static final byte yycheck_[] = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
      14,    15,     8,    13,     3,    14,    15,    16,    19,     0,
       6,    21,     4,    19,    28,    29,    30,    31,    32,    33,
      34,     6,    18,    19,     5,    10,     9,     7,    12,    11,
      27,    -1,    17,    18,    19,    10,    11,    12,    13,    14,
      15,    16
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,    21,    22,    19,    23,     0,     8,    19,    24,
      25,    26,     4,     6,    10,    17,    18,    19,    27,    28,
      29,     5,    25,    23,    27,    28,    28,     9,    10,    11,
      12,    13,    14,    15,    16,    27,     7,    26,    28,    28,
      28,    28,    28,    28,    28
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    20,    21,    22,    23,    23,    24,    25,    25,    26,
      26,    27,    27,    27,    28,    28,    28,    28,    28,    28,
      28,    28,    28,    29,    29
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     1,     3,     1,     1,     2,     3,
       4,     2,     2,     1,     3,     1,     3,     3,     3,     3,
       3,     3,     3,     1,     1
    };
  }

  /* YYTOKEN_NUMBER[YYLEX-NUM] -- Internal symbol number corresponding
      to YYLEX-NUM.  */
  private static final short yytoken_number_[] = yytoken_number_init();
  private static final short[] yytoken_number_init()
  {
    return new short[]
    {
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "KEY", "COM", "AO", "LP", "RP", "LCK",
  "LDK", "MIN", "PLUS", "MUL", "DIV", "MORE", "LESS", "EQ", "INV", "CONST",
  "IDENT", "$accept", "program", "variablesDeclaration", "variablesList",
  "computations", "operatorsList", "operator", "expression",
  "subexpression", "operand", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final byte yyrline_[] = yyrline_init();
  private static final byte[] yyrline_init()
  {
    return new byte[]
    {
       0,    27,    27,    28,    29,    29,    30,    31,    31,    32,
      33,    34,    35,    36,    37,    37,    38,    39,    40,    41,
      42,    43,    44,    46,    46
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
                       yystos_[yystack.stateAt(yynrhs - (yyi + 1))],
                       yystack.valueAt ((yynrhs) - (yyi + 1)));
  }

  /* YYTRANSLATE(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 41;
  private static final int yynnts_ = 10;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 6;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 20;

  private static final int yyuser_token_number_max_ = 274;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}

/* "/home/meier/IdeaProjects/lexicalAnalyzer/src/main/resources/parser.y":48  */ /* lalr1.java:1060  */

