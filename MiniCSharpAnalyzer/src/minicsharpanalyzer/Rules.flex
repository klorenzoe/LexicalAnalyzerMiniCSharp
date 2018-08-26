
package minicsharpanalyzer;
import static minicsharpanalyzer.Token.*;

%%

%class Rules
%type Token

Letters =[a-z]|[A-Z]
Digits =[0-9]
Identifiers = ({Letters}|{Digits}|"_")+{1,31}

LineTerminator =[\r|\n|\r\n]
MultipleLineComment ="/*"~"*/"
SingleLineComment ="//"~{LineTerminator}
ErrorComment ="/*"~[\r\n]

String ="""~![{LineTerminator}]~"""

White =[\t|\n| ]+

ReservedWord ="void"|"int"|"double"|"bool"|"string"|"class"|"interface"|"null"|"this"|"extends"|"implements"|"for"|"while"|"if"|"else"|"return"|"break"|"New"|"NewArray"
OperatorsPunctuation ="+"|"-"|"*"|"/"|"%"|"<"|"<="|">"|">="|"="|"=="|"!="|"&&"|"||"|"!"|";"|","|"."|"["|"]"|"("|")"|"{"|"}"|"[]"|"()"|"{}"

Sdouble =({Digits})+"."({Digits})*
EDouble =({Sdouble})["E"|"e"]["+"|"-"|" "]({Digits})

HexElements ={Digits}|[a-f]|[A-F]
Hexadecimal =["0x"|"0X"]({HexElements})+
Decimal =(!["0"]+)[Digits]+

Bool ="true"|"false"

%{
    public String lexeme = "";
    public int column = 0;
    public int line = 0;
%}

%%
{MultipleLineComment}|{SingleLineComment} {
                                           lexeme = yytext();
                                           column = yycolumn;
                                           line = yyline;
                                           return Comments; 
                                          }
{ErrorComment} { 
                  lexeme = yytext();
                  column = yycolumn;
                  line = yyline;
                  return ErrorComment; 
               }

{String} { 
            lexeme = yytext();
            column = yycolumn;
            line = yyline;
            return  StringConstant;
         }

{White} { /*Ignore*/ }
{ReservedWord} { 
                  lexeme = yytext();
                  column = yycolumn;
                  line = yyline;
                  return ReservedWord;
               }
{Sdouble}|{EDouble} {
                        lexeme = yytext();
                        column = yycolumn;
                        line = yyline;
                        return DoubleConstant;
                     }

{Hexadecimal}|{Decimal} {
                           lexeme = yytext();
                           column = yycolumn;
                           line = yyline;
                           return IntegerConstant;
                        }

{Bool} { 
         lexeme = yytext();
         column = yycolumn;
         line = yyline;
         return BoolConstant;
      }

{OperatorsPunctuation} {
                           lexeme = yytext();
                           column = yycolumn;
                           line = yyline;
                           return OperatorsAndPunctuation;
                       }
{Identifiers} { 
               lexeme = yytext();
               column = yycolumn;
               line = yyline;
               if(lexeme.length()>31){
                  return ErrorIdentifier;   
               }else{
                  return Identifier;
               }
              }
. {
   lexeme = yytext();
   column = yycolumn;
   line = yyline;
   return Error;
  }