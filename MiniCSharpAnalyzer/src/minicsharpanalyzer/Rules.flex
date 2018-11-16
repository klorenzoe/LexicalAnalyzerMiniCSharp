
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

ReservedWord ="void"|"int"|"double"|"bool"|"string"|"class"|"interface"|"null"|"this"|"extends"|"implements"|"for"|"while"|"if"|"else"|"return"|"break"|"New"|"NewArray"|"Print"|"ReadInteger"|"ReadLine"|"Malloc"|"GetByte"|"SetByte" 
OperatorsPunctuation ="+"|"-"|"*"|"/"|"%"|"<"|"<="|">"|">="|"="|"=="|"!="|"&&"|"||"|"!"|";"|","|"."|"["|"]"|"("|")"|"{"|"}"|"[]"|"()"|"{}"

Sdouble =({Digits})+"."({Digits})*
EDouble =({Sdouble})("E"|"e")("+"|"-"|"")({Digits}+)

HexElements ={Digits}|[a-f]|[A-F]
Hexadecimal =("0x"|"0X"){HexElements}+
Decimal ={Digits}+

Bool ="true"|"false"

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
            return symbol(sym.StringConstant);
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
                        return symbol(sym.voidd);
                      case "int":
                        return symbol(sym.intt);
                      case "double":
                        return symbol(sym.doublee);
                      case "bool":
                        return symbol(sym.booll);
                      case "string":
                        return symbol(sym.stringg);
                      case "class":
                        return symbol(sym.classs);
                      case "interface":
                        return symbol(sym.interfacee);
                      case "null":
                        return symbol(sym.nulll);
                      case "this":
                        return symbol(sym.thiss);
                      case "extends":
                        return symbol(sym.extendss);
                      case "implements":
                        return symbol(sym.implementss);
                      case "for":
                        return symbol(sym.forr);
                      case "while":
                        return symbol(sym.whilee);
                      case "if":
                        return symbol(sym.iff);
                      case "else":
                        return symbol(sym.elsee);
                      case "return":
                        return symbol(sym.returnn);
                      case "break":
                        return symbol(sym.breakk);
                      case "New":
                        return symbol(sym.neww);
                      case "NewArray":
                        return symbol(sym.newarray);
                      case "Print":
                        return symbol(sym.printt);
                      case "ReadInteger":
                        return symbol(sym.readinteger);
                      case "ReadLine":
                        return symbol(sym.readline);
                      case "Malloc":
                        return symbol(sym.mallocc);
                      case "GetByte":
                        return symbol(sym.getBytee);
                        case "SetByte":
                        return symbol(sym.setBytee);
                      default:
                        return symbol(sym.notfound);
                  }
               }
{Sdouble}|{EDouble} {
                       /* lexeme = yytext();
                        column = yycolumn;
                        line = yyline;
                        return DoubleConstant;*/
                        result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token double_constant: \""+yytext()+"\" \n";
                        return symbol(sym.DoubleConstant);
                     }

{Hexadecimal}|{Decimal} {
                          /* lexeme = yytext();
                           column = yycolumn;
                           line = yyline;
                           return IntegerConstant;*/
                           result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token integer_constant: \""+yytext()+"\" \n";
                           return symbol(sym.IntegerConstant);
                        }

{Bool} { 
         /*lexeme = yytext();
         column = yycolumn;
         line = yyline;
         return BoolConstant;*/
         result_lexical_analyzer+= "line: "+yyline+" column: "+yycolumn+" token bool_constant: \""+yytext()+"\" \n";
         return symbol(sym.BoolConstant);
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
                                    return symbol(sym.plus);
                                case "-":
                                    return symbol(sym.minus);
                                case "*":
                                    return symbol(sym.times);
                                case "/":
                                    return symbol(sym.div);
                                case "%":
                                    return symbol(sym.percentage);
                                case "<":
                                    return symbol(sym.smaller);
                                case "<=":
                                    return symbol(sym.smallerEquals);
                                case ">":
                                    return symbol(sym.greater);
                                case ">=":
                                    return symbol(sym.greaterEquals);
                                case "=":
                                    return symbol(sym.assignment);
                                case "==":
                                    return symbol(sym.equals);
                                case "!=":
                                    return symbol(sym.notequals);
                                case "&&":
                                    return symbol(sym.and);
                                case "||":
                                    return symbol(sym.or);
                                case "!":
                                    return symbol(sym.not);
                                case ";":
                                    return symbol(sym.dotcomma);
                                case ",":
                                    return symbol(sym.comma);
                                case ".":
                                    return symbol(sym.point);
                                case "[":
                                
                                    return symbol(sym.claspfirst);
                                case "]":
                                    return symbol(sym.claspsecond);
                                case "(":
                                    return symbol(sym.parentesisfirst);
                                case ")":
                                    return symbol(sym.parentesissecond);
                                case "{":
                                    return symbol(sym.bracketfirst);
                                case "}":
                                    return symbol(sym.bracketsecond);
                                case "[]":
                                    return symbol(sym.clasps);
                                case "()":
                                    return symbol(sym.parentesis);
                                case "{}":
                                    return symbol(sym.brackets);
                                default:
                                    return symbol(sym.notfound);
                            }
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
               return symbol(sym.Identifierr);
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