
package minicsharpanalyzer;
import java_cup.runtime.*;

%%

%class Rules
%unicode
%cup
%line
%column

%{
   StringBuffer string = new StringBuffer();
   private Symbol symbol(int type){
      return new Symbol(type, yyline, yycolumn);
   }
   private Symbol symbol(int type, Object value){
       return new Symbol(type, yyline, yycolumn, value);
   }
    public int getLine() { return  yyline; }
    public int getColumn() {return yycolumn; }
%}

Letters =[a-z]|[A-Z]
Digits =[0-9]
Identifiers =({Letters}|"_")({Letters}|{Digits}|"_")*

LineTerminator =[\r|\n|\r\n]
MultipleLineComment =("/*"~[^"*/"]~"*/")|("/*")["*"]+("/")
NotJump = [^\n\r]
ErrorComment ="/*"~[^*]+~[^/]+
String ="\""([^\n\"\\]*(\\[.\n])*)*"\""  

White =[\t|\n|" "|\r\n]+

ReservedWord ="void"|"int"|"double"|"bool"|"string"|"class"|"interface"|"null"|"this"|"extends"|"implements"|"for"|"while"|"if"|"else"|"return"|"break"|"New"|"NewArray"|"Print"|"ReadInteger"|"ReadLine"|"Malloc"|"GetByte"|"SetByte"|"const"|"include" 
OperatorsPunctuation ="+"|"-"|"*"|"/"|"%"|"<"|"<="|">"|">="|"="|"=="|"!="|"&&"|"||"|"!"|";"|","|"."|"["|"]"|"("|")"|"{"|"}"|"[]"|"()"|"{}"|"#"

Sdouble =({Digits})+"."({Digits})*
EDouble =({Sdouble})("E"|"e")("+"|"-"|"")({Digits}+)

HexElements ={Digits}|[a-f]|[A-F]
Hexadecimal =("0x"|"0X"){HexElements}+
Decimal ={Digits}+

Bool ="true"|"false"

Extensions = ".txt"
FileName= ({Identifiers})({Extensions})

%{
    /*public String lexeme = "";
    public int column = 0;
    public int line = 0;*/

   public static String result_lexical_analyzer = "";
%}

//%state STRING

%%
{White} { /*Ignore*/ }
"//"{NotJump}* { /*Ignore*/}

{MultipleLineComment} { /* Ignore */}

{ErrorComment} { 
                       /* lexeme = yytext();
                        column = yycolumn;
                        line = yyline;
                        return ErrorComment; */
                        result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" ERROR COMMENT token: \""+yytext()+"\" \n";
                        string.append("ErrorComment"); 
                     }

/*<YYINITIAL>
{*/
{String} { 
           /* lexeme = yytext();
            column = yycolumn;
            line = yyline;
            return  StringConstant;*/
            result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token string_constant: \""+yytext()+"\" \n";
            return symbol(sym.StringConstant, yytext());
         }
{ReservedWord} { 
                 /* lexeme = yytext();
                  column = yycolumn;
                  line = yyline;
                  return ReservedWord;
                  */
                  result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token reserved_word: \""+yytext()+"\" \n";
                  switch(yytext())
                  {
                      case "void":
                        return symbol(sym.voidd, yytext());
                      case "int":
                        return symbol(sym.intt, yytext());
                      case "double":
                        return symbol(sym.doublee, yytext());
                      case "bool":
                        return symbol(sym.booll, yytext());
                      case "string":
                        return symbol(sym.stringg, yytext());
                      case "class":
                        return symbol(sym.classs, yytext());
                      case "interface":
                        return symbol(sym.interfacee, yytext());
                      case "null":
                        return symbol(sym.nulll, yytext());
                      case "this":
                        return symbol(sym.thiss, yytext());
                      case "extends":
                        return symbol(sym.extendss, yytext());
                      case "implements":
                        return symbol(sym.implementss, yytext());
                      case "for":
                        return symbol(sym.forr, yytext());
                      case "while":
                        return symbol(sym.whilee, yytext());
                      case "if":
                        return symbol(sym.iff, yytext());
                      case "else":
                        return symbol(sym.elsee, yytext());
                      case "return":
                        return symbol(sym.returnn, yytext());
                      case "break":
                        return symbol(sym.breakk, yytext());
                      case "New":
                        return symbol(sym.neww, yytext());
                      case "NewArray":
                        return symbol(sym.newarray, yytext());
                      case "Print":
                        return symbol(sym.printt, yytext());
                      case "ReadInteger":
                        return symbol(sym.readinteger, yytext());
                      case "ReadLine":
                        return symbol(sym.readline, yytext());
                      case "Malloc":
                        return symbol(sym.mallocc, yytext());
                      case "GetByte":
                        return symbol(sym.getBytee, yytext());
                    case "SetByte":
                        return symbol(sym.setBytee, yytext());
                    case "include":
                        return symbol(sym.includee, yytext());
                    case "const":
                        return symbol(sym.constt, yytext());
                      default:
                        return symbol(sym.notfound, yytext());
                  }
               }
{Sdouble}|{EDouble} {
                       /* lexeme = yytext();
                        column = yycolumn;
                        line = yyline;
                        return DoubleConstant;*/
                        result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token double_constant: \""+yytext()+"\" \n";
                        return symbol(sym.DoubleConstant, yytext());
                     }

{Hexadecimal}|{Decimal} {
                          /* lexeme = yytext();
                           column = yycolumn;
                           line = yyline;
                           return IntegerConstant;*/
                           result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token integer_constant: \""+yytext()+"\" \n";
                           return symbol(sym.IntegerConstant, yytext());
                        }

{Bool} { 
         /*lexeme = yytext();
         column = yycolumn;
         line = yyline;
         return BoolConstant;*/
         result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token bool_constant: \""+yytext()+"\" \n";
         return symbol(sym.BoolConstant, yytext());
      }

{OperatorsPunctuation} {
                           /*lexeme = yytext();
                           column = yycolumn;
                           line = yyline;
                           return OperatorsAndPunctuation;*/
                           result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token operator_punctuation: \""+yytext()+"\" \n";
                           switch(yytext())
                            {
                                case "+":
                                    return symbol(sym.plus, yytext());
                                case "-":
                                    return symbol(sym.minus, yytext());
                                case "*":
                                    return symbol(sym.times, yytext());
                                case "/":
                                    return symbol(sym.div, yytext());
                                case "%":
                                    return symbol(sym.percentage, yytext());
                                case "<":
                                    return symbol(sym.smaller, yytext());
                                case "<=":
                                    return symbol(sym.smallerEquals, yytext());
                                case ">":
                                    return symbol(sym.greater, yytext());
                                case ">=":
                                    return symbol(sym.greaterEquals, yytext());
                                case "=":
                                    return symbol(sym.assignment, yytext());
                                case "==":
                                    return symbol(sym.equals, yytext());
                                case "!=":
                                    return symbol(sym.notequals, yytext());
                                case "&&":
                                    return symbol(sym.and, yytext());
                                case "||":
                                    return symbol(sym.or, yytext());
                                case "!":
                                    return symbol(sym.not, yytext());
                                case ";":
                                    return symbol(sym.dotcomma, yytext());
                                case ",":
                                    return symbol(sym.comma, yytext());
                                case ".":
                                    return symbol(sym.point, yytext());
                                case "[":
                                
                                    return symbol(sym.claspfirst, yytext());
                                case "]":
                                    return symbol(sym.claspsecond, yytext());
                                case "(":
                                    return symbol(sym.parentesisfirst, yytext());
                                case ")":
                                    return symbol(sym.parentesissecond, yytext());
                                case "{":
                                    return symbol(sym.bracketfirst, yytext());
                                case "}":
                                    return symbol(sym.bracketsecond, yytext());
                                case "[]":
                                    return symbol(sym.clasps, yytext());
                                case "()":
                                    return symbol(sym.parentesis, yytext());
                                case "{}":
                                    return symbol(sym.brackets, yytext());
                                case "#":
                                    return symbol(sym.numerall, yytext());
                                default:
                                    return symbol(sym.notfound, yytext());
                            }
                       }
{FileName} {
    result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token file_name: \""+yytext()+"\" \n";
    return symbol(sym.fileNamee, yytext());
         }
{Identifiers} { 
               /*lexeme = yytext();
               column = yycolumn;
               line = yyline;
               if(lexeme.length()>31){
                  return ErrorIdentifier;   
               }else{
                  return Identifier;

               }*/
               result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token identifier: \""+yytext()+"\" \n";
               return symbol(sym.Identifierr, yytext());
              }
//}

. {
   /*lexeme = yytext();
   column = yycolumn;
   line = yyline;
   return Error;*/
   result_lexical_analyzer+= "ERROR line: "+yyline+" column: "+yycolumn+" token: \""+yytext()+"\" \n";
   string.append("Error"); 
  }