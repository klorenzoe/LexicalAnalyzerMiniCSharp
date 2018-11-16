/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharpanalyzer;

import java.util.ArrayList;

/**
 *
 * @author usuario
 * ClearLists()
 * addSymbolTo_SymbolList(String id_, String type_, String value, int column, int row, String content)
 * modifyValueToSymbol(String id_, String value, int column, int row, String content)
 * getValueOfId(String id_, int column, int row, String content)
 * void ErrorOfTypes(int column, int row, String content, String type1, String type2
 * addSymbolTo_SymbolFunctionList(String id_, String type_, int column, int row, String content)
 */
public class Singleton
{
   public static ArrayList<SymbolT> Symbol_list;
   public static ArrayList<ErrorSymbol> Error_report;
   public static ArrayList<SymbolFunction> Symbol_function_list;
  
  public static void ListInstances(){
     Symbol_list = new ArrayList<SymbolT>();
     Error_report = new ArrayList<ErrorSymbol>();
     Symbol_function_list = new ArrayList<SymbolFunction>();
  }
  
  public static void ClearLists(){
     Symbol_list = null;
     Error_report = null;
     Symbol_function_list = null;
  }
  public static void addSymbolTo_SymbolList(String id_, String type_, String value, int column, int row, String content){
     if(ExistIdOnSymbolList(id_)){
        ErrorSymbol ES = new ErrorSymbol();
        ES.column = column;
        ES.row = row;
        ES.detail = "The identifier already exist on symbol table";
        ES.line_content = content;
        Error_report.add(ES);
     }else{
        SymbolT S = new SymbolT();
        S.identifier = id_;
        S.type = type_;
        S.value = value;
        Symbol_list.add(S);
     }
  }
 
  public static void modifyValueToSymbol(String id_, String value, int column, int row, String content){
    
     for (SymbolT S : Symbol_list) {
      if(S.identifier.equals(id_)){
         S.value = value;
         return;
      }
     }
     
     ErrorSymbol ES = new ErrorSymbol();
     ES.column = column;
     ES.row = row;
     ES.detail = "El simbolo a modificar no ha sido instanciado";
     ES.line_content = content;
     Error_report.add(ES);
  }
  
  public static String getValueOfId(String id_, int column, int row, String content){
      for (SymbolT S : Symbol_list) {
      if(S.identifier.equals(id_)){
         if(S.value != null){
            return S.value + "!!" + S.type;
         }else{
            AddError(column, row, content, "No se ha ingresado nungún valor para la variable");
            return null;
         }
      }
     }
     AddError(column, row, content, "El simbolo no existe en la tabla de símbolos");
     return null;
  }
  
  public static void ErrorOfTypes(int column, int row, String content, String type1, String type2){
     AddError(column, row, content, "No se puede operar el tipo: "+type1+" con el tipo: "+type2);
  }
  
  public static void addSymbolTo_SymbolFunctionList(String id_, String type_, int column, int row, String content){
     if(ExistIdOnFunctionSymbolList(id_)){
        AddError(column, row, content, "La función ya existe en la tabla de símbolos");
     }else{
        SymbolFunction SF = new SymbolFunction();
        SF.identifier = id_;
        SF.type = type_;
        Symbol_function_list.add(SF);
     }
  }
   
   
   
  private static boolean ExistIdOnSymbolList(String id)
  {
     for (SymbolT S : Symbol_list) {
      if(S.identifier.equals(id)){
         return true;
      }
     }
     return false;
  }
  
  private static boolean ExistIdOnFunctionSymbolList(String id)
  {
     for (SymbolFunction S : Symbol_function_list) {
      if(S.identifier.equals(id)){
         return true;
      }
     }
     return false;
  }
 
  private static void AddError(int column, int row, String content, String detail){
      ErrorSymbol ES = new ErrorSymbol();
      ES.column = column;
      ES.row = row;
      ES.detail = detail;
      ES.line_content = content;
      Error_report.add(ES);
  }
  
}
