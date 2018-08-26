
package minicsharpanalyzer;

import static minicsharpanalyzer.Token.*;

%%

%class Rules
%type Token

L=[a-b]
D=[0-8]
white =[ ,\n]

%{
    public String lexeme = "";
%}

%%
{white} {/*Ignore*/}
"=" {return igual;}
"+" {return suma;}
{L} {lexeme=yytext(); return Variable;}
{D} {lexeme=yytext(); return Numero;}
"*" {return multiplicacion;}
"-" {return resta;}
"/" {return division;}
. {return ERROR;}