  
/* ----------------------Preliminary Declarations Section--------------------*/
   
/* Import the class java_cup.runtime.*  */
package minicsharpanalyzer;
import java_cup.runtime.*;
   
/* Parser code to change the way the parser reports errors (include
   line and column number of the error). */
parser code {:
    public String report_error_result="";
    /* Change the method report_error so it will display the line and
       column of where the error occurred in the input as well as the
       reason for the error which is passed into the method in the
       String 'message'. */
    public void report_error(String message, Object info) {
   
        /* Create a StringBuilder called 'm' with the string 'Error' in it. */
       // StringBuilder m = new StringBuilder("Error");
   
        /* Check if the information passed to the method is the same
           type as the type java_cup.runtime.Symbol. */
        if (info instanceof java_cup.runtime.Symbol) {
            /* Declare a java_cup.runtime.Symbol object 's' with the
               information in the object info that is being typecasted
               as a java_cup.runtime.Symbol object. */
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
   
            /* Check if the line number in the input is greater or
               equal to zero. */
            if (s.left >= 0) {                
                /* Add to the end of the StringBuilder error message
                   the line number of the error in the input. */
                report_error_result += " in line "+(s.left+1) +" ";   
                /* Check if the column number in the input is greater
                   or equal to zero. */
                if (s.right >= 0)                    
                    /* Add to the end of the StringBuilder error message
                       the column number of the error in the input. */
                    report_error_result+=", column "+(s.right+1)+" ";
            }
        }
   
        /* Add to the end of the StringBuilder error message created in
           thissmethod the message that was passed into thissmethod. */
        report_error_result+=" message: "+message+"\n";

   
        /* Print the contents of the StringBuilder 'm', which contains
           an error message, out on a line. */
        //System.err.println(m);
    }
   
    /* Change the method report_fatal_error so when it reports a fatal
       error it will display the line and column number of where the
       fatal error occurred in the input as well as the reason for the
       fatal error which is passed into the method in the object
       'message' and then exit.*/
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        //System.exit(1);
    }
:};
   

   
/* ------------Declaration of Terminals and Non Terminals Section----------- */
   
/* Terminals (tokens returned by the scanner).  

   Terminals that have no value are listed first and then terminals
   that do have an value, in thisscase an integer value, are listed on
   the next line down. */
terminal String    Identifierr, DoubleConstant, StringConstant, voidd, classs, interfacee, nulll, thiss, extendss, implementss, forr, whilee, iff, elsee, returnn, breakk, neww, newarray, printt, readinteger, readline, mallocc, getBytee, setBytee, comma, parentesisfirst, parentesissecond, bracketfirst, bracketsecond, dotcomma, assignment, plus, minus, times, div, percentage, smaller, smallerEquals, greater, greaterEquals, equals, notequals, and, or, not, parentesis, point, claspfirst, claspsecond, clasps, intt, doublee, booll, stringg, brackets, notfound;
terminal Integer   IntegerConstant;
terminal Boolen    BoolConstant;
   
/* Non terminals used in the grammar section.  

   Non terminals that have an object value are listed first and then
   non terminals that have an integer value are listed.  An object
   value means that it can be any type, it isn't set to a specific
   type.  So it could be an Integer or a String or whatever. */

non terminal Object Program, DeclAst, Decl, VariableDecl, FunctionDecl, ClassDecl, InterfaceDecl;
non terminal Object Variable, Type, FunctionRightRecursive, Formals, StmtBlock, FormalsWithComma;
non terminal Object ExtendIdBool, ImplementsBool, FieldAst, implementssAst, ImplementWithComma, ExprBool;
non terminal Object Field, PrototypeAst, Prototype,  VariableDeclAst, StmtAst, Stmt, Expr, IfStmt,WhileStmt;
non terminal Object ForStmt, BreakStmt, ReturnStmt, PrintStmt, ElseBool, ExprCommaPlus, LValue, Call;
non terminal Object LibCall, Actuals, Constant;
non terminal Object FormalsAux, IImplementAstAux, PrototypeAux;
/* -------------Precedence and Associatively of Terminals Section----------- */
   
/*
  Precedence of non terminals could be defined here.  If you do define
  precedence here you won't need to worry about precedence in the
  Grammar Section, i.e. that TIMES should have a higher precedence
  than PLUS.
  
  The precedence defined here would look something like thisswhere the
  lower line always will have higher precedence than the line before it. */

  precedence left elsee;
  precedence left plus, minus, times, div, percentage;
  precedence left smaller, smallerEquals, greater, greaterEquals, assignment, equals, notequals, and, or, not ;
  precedence left voidd, classs , interfacee;
  precedence left intt, stringg, Identifierr, booll, doublee;



  // bracketsecond, dotcomma, assignment,, , , , , smaller, smallerEquals, greater, greaterEquals, equals, notequals, and, or, not, parentesis, point, claspfirst, claspsecond;

/* ----------------------------Grammar Section-------------------- */
   
Program::= DeclAst Decl | Decl;

Decl::=  VariableDecl
        | FunctionDecl
        | ClassDecl
        | InterfaceDecl 
        | error claspsecond
        | error dotcomma;

DeclAst::= | Program;

VariableDecl ::= Variable dotcomma ;

Variable ::= Type Identifierr ;

Type ::= intt
        | doublee
        | booll
        | stringg
        | Identifierr
        | Type clasps; //| Type claspfirst claspsecond ;



FunctionDecl ::= Type FunctionRightRecursive
| voidd FunctionRightRecursive ;

FunctionRightRecursive::= Identifierr parentesisfirst Formals parentesissecond StmtBlock ;

Formals::= | Variable FormalsWithComma | Variable;

FormalsWithComma ::= comma Variable FormalsAux;

FormalsAux::= | FormalsWithComma;

ClassDecl ::= classs Identifierr ExtendIdBool ImplementsBool bracketfirst FieldAst bracketsecond ;

ExtendIdBool ::= | extendss Identifierr ;

ImplementsBool ::= | implementss implementssAst;

implementssAst ::= Identifierr ImplementWithComma | Identifierr;
ImplementWithComma ::= comma Identifierr IImplementAstAux;
IImplementAstAux::= | ImplementWithComma;

FieldAst ::= | FieldAst Field;

Field ::= VariableDecl
| FunctionDecl ;

InterfaceDecl ::= interfacee Identifierr bracketfirst PrototypeAst bracketsecond ;

PrototypeAst ::= | PrototypeAst Prototype;

Prototype ::= Type Identifierr PrototypeAux
            | voidd Identifierr PrototypeAux;

PrototypeAux::= Identifierr parentesisfirst Formals parentesissecond dotcomma;

StmtBlock ::= bracketfirst VariableDeclAst StmtAst bracketsecond ;

VariableDeclAst ::= | VariableDeclAst VariableDecl;

StmtAst ::=  | Stmt StmtAst;

Stmt ::= Expr dotcomma
        | dotcomma
        | IfStmt
        | WhileStmt
        | ForStmt
        | BreakStmt
        | ReturnStmt
        | PrintStmt
        | StmtBlock ;

IfStmt ::= iff parentesisfirst Expr parentesissecond Stmt ElseBool ;

ElseBool ::= | elsee Stmt;

WhileStmt ::= whilee parentesisfirst Expr parentesissecond Stmt ;

ForStmt ::= forr parentesisfirst ExprBool dotcomma Expr dotcomma ExprBool parentesissecond Stmt ;

ExprBool::= | Expr;

ReturnStmt ::= returnn ExprBool dotcomma ;

BreakStmt ::= breakk dotcomma ;

PrintStmt ::= printt parentesisfirst ExprCommaPlus parentesissecond dotcomma ;

ExprCommaPlus ::= ExprCommaPlus comma Expr | Expr ;

Expr ::= LValue assignment Expr
| parentesisfirst Expr parentesissecond 
| Expr plus Expr
| Expr minus Expr
| Expr times Expr
| Expr div Expr
| Expr percentage Expr
| minus Expr
| Expr smaller Expr
| Expr smallerEquals Expr
| Expr greater Expr
| Expr greaterEquals Expr
| Expr equals Expr
| Expr notequals Expr
| Expr and Expr
| Expr or Expr
| not Expr
| neww parentesisfirst Identifierr parentesissecond
| newarray parentesisfirst Expr comma Type parentesissecond
| readinteger parentesis | readinteger parentesisfirst parentesissecond
| readline parentesis | readline parentesisfirst parentesissecond
| mallocc parentesisfirst Expr parentesissecond
| Constant
| LValue
| thiss
| Call;



LValue ::= Identifierr
| Expr point Identifierr
| Expr claspfirst Expr claspsecond ;



Call ::= Identifierr parentesisfirst Actuals parentesissecond 
| Expr point Identifierr  Identifierr parentesisfirst Actuals parentesissecond 
| Expr point LibCall parentesisfirst Actuals parentesissecond  ;

LibCall ::= getBytee parentesisfirst Expr parentesissecond 
| setBytee parentesisfirst Expr comma Expr parentesissecond ;

Actuals ::= | ExprCommaPlus;

Constant ::= IntegerConstant
| DoubleConstant
| BoolConstant
| StringConstant
| nulll ;