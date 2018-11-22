/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharpanalyzer;

import com.sun.xml.internal.fastinfoset.EncodingConstants;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author usuario
 * ClearLists()
 * addSymbolTo_SymbolList(String id_, String type_, String value, int column, int row, String content)
 * modifyValueToSymbol(String id_, String value, int column, int row, String content)
 * getValueOfId(String id_, int column, int row, String content)
 * void ErrorOfTypes(int column, int row, String content, String type1, String type2
 * addSymbolTo_SymbolFunctionList(String id_, String type_, int column, int row, String content)
 *   public static void addClassOrInterfase(String id_, String Type)
 */
public class Singleton
{
   public static ArrayList<SymbolT> Symbol_list;
   public static ArrayList<ErrorSymbol> Error_report;
   public static ArrayList<SymbolFunction> Symbol_function_list;
   public static ArrayList<String> environmentQueue;
   public static ArrayList<SymbolClassInterfase> Symbol_Class_Interfase;
   public static boolean isParameterEnvironment;
  
  public static void ListInstances(){
     Symbol_list = new ArrayList<SymbolT>();
     Error_report = new ArrayList<ErrorSymbol>();
     Symbol_function_list = new ArrayList<SymbolFunction>();
     environmentQueue = new ArrayList<String>();
     Symbol_Class_Interfase = new ArrayList<SymbolClassInterfase>();
     environmentQueue.add(getGUID());
     isParameterEnvironment = false;
  }
  
  public static void ClearLists(){
     Symbol_list = null;
     Error_report = null;
     Symbol_function_list = null;
  }
  
 public static void AnalyzeOtherFile(String filePath, int column, int row, String content){
    try
    {
      Reader reader = new FileReader(new File(filePath));
      Rules lexer=new Rules(reader);
      SyntacticRules Syntactic = new SyntacticRules(lexer);
      Syntactic.report_error_result = "\n ---begin File: "+filePath+"---\n";
      Syntactic.parse();
      Syntactic.report_error_result = "\n ---end File: "+filePath+"---\n";
      
    }
    catch(Exception e)
    {
        ErrorSymbol ES = new ErrorSymbol();
        ES.column = column;
        ES.row = row;
        ES.detail = "No se encuentra el archivo o no se puede abrir.";
        ES.line_content = content;
        Error_report.add(ES);
    }
 
 };
  public static void addSymbolTo_SymbolList(String id_, String type_, String value, int column, int row, String content){
     if(ExistIdOnSymbolList(id_, peekEnvironmentQueue())){
        ErrorSymbol ES = new ErrorSymbol();
        ES.column = column;
        ES.row = row;
        ES.detail = "El simbolo ya existe en este ambiente";
        ES.line_content = content;
        Error_report.add(ES);
     }else{
        SymbolT S = new SymbolT();
        S.identifier = id_;
        S.type = type_;
        S.value = value;
        S.isParameter = isParameterEnvironment; //if is functionEnvironment then yes.
        S.environment = peekEnvironmentQueue();
        Symbol_list.add(S);
     }
  }
 
  public static String modifyValueToSymbol(String id_, String value, int column, int row, String content){
    id_ = id_.split("!")[0];
     String Type = "";
     String getSavedType = "";
     if(value.split("!")[1].equals("var")){
         String aux = getValueOfId(value.split("!")[0], column, row, content);
         Type = aux.split("!")[1];
     }
      
     for (SymbolT S : Symbol_list) {
      if(S.identifier.equals(id_)){
         getSavedType = S.type;
         if(S.type.equals(Type) || S.type.equals(value.split("!")[1])){
            S.value = value.split("!")[0];
            if(Type.equals("")){ Type = value.split("!")[1];}
            return S.value+"!"+Type;
         }
         else
         {
            if(Type.equals("comodin") ||value.split("!")[1].equals("comodin") ){
               ErrorSymbol ES = new ErrorSymbol();
               ES.column = column;
               ES.row = row;
               ES.detail = "No se puede operar ya que algun valor no ha sigo asignado o bien, algo no se ha instanciado";
               ES.line_content = content;
               Error_report.add(ES);
               S.value = "null";
               return "null!comodin";
            }
            else
            {
               if(Type.equals("")){ Type = value.split("!")[1]; }
               ErrorSymbol ES = new ErrorSymbol();
               ES.column = column;
               ES.row = row;
               ES.detail = "Los tipos de datos no coinciden. Tipo "+ S.type+" con "+Type;
               ES.line_content = content;
               Error_report.add(ES);
            }
            return "null!comodin";
         }
         
      }
     }
     
     ErrorSymbol ES = new ErrorSymbol();
     ES.column = column;
     ES.row = row;
     ES.detail = "El simbolo a modificar no ha sido instanciado";
     ES.line_content = content;
     Error_report.add(ES);
     return "null!comodin";
  }
  
  public static String getValueOfId(String id_, int column, int row, String content){ //ATENCIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOON
     //ATENCIIIOOOOOOOOOOOOOOOOOOOOOOOOOOON!!!! 
     String env = peekEnvironmentQueue();
     ArrayList<SymbolT> AL = new ArrayList<SymbolT>();
     
      for (SymbolT S : Symbol_list) {
      if(S.identifier.equals(id_)){
         AL.add(S);
      }
     }
      
      for (int i = AL.size()-1; i >= 0; i--)
     {
        int k = Symbol_list.size();
         do{
            k--;
            if(Symbol_list.get(k).environment.equals(AL.get(i).environment)){
               return AL.get(i).value + "!" + AL.get(i).type+"!"+AL.get(i).isParameter;
            }
         }while(!Symbol_list.get(k).environment.equals(env) || k == 0);
     }
     AddError(column, row, content, "El simbolo "+id_+" no existe en la tabla de simbolos");
     return "null!comodin";
  }
  
  public static void ErrorOfTypes(int column, int row, String content, String type1, String type2){
     AddError(column, row, content, "No se puede operar el tipo: "+type1+" con el tipo: "+type2);
  }
  
  public static void addSymbolTo_SymbolFunctionList(String id_, String type_, int column, int row, String content){
     if(ExistIdOnFunctionSymbolList(id_, peekEnvironmentQueue())){
        AddError(column, row, content, "La funcion ya existe en la tabla de simbolos");
     }else{
        
        SymbolFunction SF = new SymbolFunction();
        SF.itsEnvironment = peek2PositionsEnvironmentQueue();
        SF.identifier = id_;
        SF.type = type_;
        SF.functionEnvironment = peekEnvironmentQueue();
        Symbol_function_list.add(SF);
     }
  }
  
  public static void addClassOrInterfase(String id_, String type){
     SymbolClassInterfase SCI = new SymbolClassInterfase();
     SCI.environment = peekEnvironmentQueue();
     SCI.identifier = id_;
     SCI.type = type;
     Symbol_Class_Interfase.add(SCI);
  }
  public static String OperateUnaryOperators(String e1, String operator, int column, int row, String content){
     try
     {
         String aux = "";
         String e1_val = e1.split("!")[0];
         String e1_type = e1.split("!")[1];

         if(e1_type.equals("var")){
            //the entry is a variable
            aux = getValueOfId(e1_val, column, row, content);
            e1_val = aux.split("!")[0];
            e1_type = aux.split("!")[1];
         }

         switch(operator){     
            case "!":
               boolean b = !Boolean.parseBoolean(e1);
               return b+"!bool";
            case "-":
               switch(e1_type)
               {
                  case "int":
                     int result = Integer.parseInt(e1) * -1;
                     return result+"!int";
                  case "double":
                     double resultd = Double.parseDouble(e1) * -1;
                     return resultd+"!int";
               }
            default:
               AddError(column, row, content, "No se puede operar el unario "+e1_type+" con el recurso: "+ e1.split("!")[0]);
               return "null!comodin";
         }
     }
     catch(Exception e)
     {
        AddError(column, row, content, "No se puede operar el unario "+operator+" con el recurso: "+ e1.split("!")[0]);
               return "null!comodin";
     }
  }
  public static String OperateValues(String e1, String e2, String operator, int column, int row, String content){
     if(e1.contains("!comodin") || e2.contains("!comodin") || e1.equals("null") || e2.equals("null")){  
        AddError(column, row, content, "No se puede operar ya que uno de los valores no esta asignado o instanciado");
        return "null!comodin";
     }
        String aux = "";
     String e1_val = e1.toString().split("!")[0];
     String e1_type = e1.toString().split("!")[1];
     boolean Parameters = false;
     
     String e2_val = e2.toString().split("!")[0];
     String e2_type = e2.toString().split("!")[1];
     
     if(e1_type.equals("var")){
        //the entry is a variable
        aux = getValueOfId(e1_val, column, row, content);
        if(aux.equals("null!comodin")){return "null!comodin";}
        e1_val = aux.split("!")[0];
        e1_type = aux.split("!")[1];
        Parameters = Boolean.parseBoolean(aux.split("!")[2]);
     }
     
     if(e2_type.equals("var")){
        //the entry is a variable
        aux = getValueOfId(e2_val, column, row, content);
        if(aux.equals("null!comodin")){return "null!comodin";}
        e2_val = aux.split("!")[0];
        e2_type = aux.split("!")[1];
        Parameters = Parameters || Boolean.parseBoolean(aux.split("!")[2]);
     }
     
      if(e1_val.equals("null") || e2_val.equals("null")){  
        AddError(column, row, content, "No se puede operar ya que uno de los valores no esta asignado o instanciado");
        return "null!comodin";
     }
     try{
     if(!Parameters){
            double doubleR;
             String stringR;
             int intR;
             boolean boolR;
               switch(operator)
              {
                  case "+":
                     if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Double.parseDouble(e1_val) + Double.parseDouble(e2_val);
                                    return doubleR +"!double";
                                 case "int":
                                   doubleR = Double.parseDouble(e1_val) + Integer.parseInt(e2_val);
                                   return doubleR+"!double";
                                  case "string":
                                    stringR = e1_val+ e2_val;
                                    return stringR+"!string";
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Integer.parseInt(e1_val) + Double.parseDouble(e2_val);
                                    return doubleR+"!double"; 
                                 case "int":
                                    doubleR = Integer.parseInt(e1_val) + Integer.parseInt(e2_val);
                                    return doubleR+"!int"; 
                                 case "string":
                                    stringR = e1_val+ e2_val;
                                    return stringR+"!string";
                              }
                           case "string":
                              stringR = e1_val+ e2_val;
                              return stringR+"!string";
                           default:
                              break;
                        }
                     }
                  case "-":
                      if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Double.parseDouble(e1_val) - Double.parseDouble(e2_val);
                                    return doubleR +"!double";
                                 case "int":
                                   doubleR = Double.parseDouble(e1_val) - Integer.parseInt(e2_val);
                                   return doubleR+"!double"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Integer.parseInt(e1_val) - Double.parseDouble(e2_val);
                                    return doubleR+"!double"; 
                                 case "int":
                                    doubleR = Integer.parseInt(e1_val) - Integer.parseInt(e2_val);
                                    return doubleR+"!int"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "*":
                      if(isCompatible(e1_type, e2_type,operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Double.parseDouble(e1_val) * Double.parseDouble(e2_val);
                                    return doubleR +"!double";
                                 case "int":
                                   doubleR = Double.parseDouble(e1_val) * Integer.parseInt(e2_val);
                                   return doubleR+"!double"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Integer.parseInt(e1_val) * Double.parseDouble(e2_val);
                                    return doubleR+"!double"; 
                                 case "int":
                                    doubleR = Integer.parseInt(e1_val) * Integer.parseInt(e2_val);
                                    return doubleR+"!int"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "/":
                      if(isCompatible(e1_type, e2_type, operator,column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Double.parseDouble(e1_val) / Double.parseDouble(e2_val);
                                    return doubleR +"!double";
                                 case "int":
                                   doubleR = Double.parseDouble(e1_val) / Integer.parseInt(e2_val);
                                   return doubleR+"!double"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Integer.parseInt(e1_val) / Double.parseDouble(e2_val);
                                    return doubleR+"!double"; 
                                 case "int":
                                    doubleR = Integer.parseInt(e1_val) / Integer.parseInt(e2_val);
                                    return doubleR+"!int"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "%":
                      if(isCompatible(e1_type, e2_type, operator,column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Double.parseDouble(e1_val) % Double.parseDouble(e2_val);
                                    return doubleR +"!double";
                                 case "int":
                                   doubleR = Double.parseDouble(e1_val) % Integer.parseInt(e2_val);
                                   return doubleR+"!double"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    doubleR = Integer.parseInt(e1_val) % Double.parseDouble(e2_val);
                                    return doubleR+"!double"; 
                                 case "int":
                                    doubleR = Integer.parseInt(e1_val) % Integer.parseInt(e2_val);
                                    return doubleR+"!int"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "<":
                      if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Double.parseDouble(e1_val) < Double.parseDouble(e2_val);
                                    return boolR +"!bool";
                                 case "int":
                                   boolR = Double.parseDouble(e1_val) < Integer.parseInt(e2_val);
                                   return boolR+"!bool"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Integer.parseInt(e1_val) < Double.parseDouble(e2_val);
                                    return boolR+"!bool"; 
                                 case "int":
                                    boolR = Integer.parseInt(e1_val) < Integer.parseInt(e2_val);
                                    return boolR+"!bool"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "<=":
                      if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Double.parseDouble(e1_val) <= Double.parseDouble(e2_val);
                                    return boolR +"!bool";
                                 case "int":
                                   boolR = Double.parseDouble(e1_val) <= Integer.parseInt(e2_val);
                                   return boolR+"!bool"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Integer.parseInt(e1_val) <= Double.parseDouble(e2_val);
                                    return boolR+"!bool"; 
                                 case "int":
                                    boolR = Integer.parseInt(e1_val) <= Integer.parseInt(e2_val);
                                    return boolR+"!bool"; 
                              }
                           default:
                              break;
                        }
                     }
                  case ">":
                      if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Double.parseDouble(e1_val) > Double.parseDouble(e2_val);
                                    return boolR +"!bool";
                                 case "int":
                                   boolR = Double.parseDouble(e1_val) > Integer.parseInt(e2_val);
                                   return boolR+"!bool"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Integer.parseInt(e1_val) > Double.parseDouble(e2_val);
                                    return boolR+"!bool"; 
                                 case "int":
                                    boolR = Integer.parseInt(e1_val) > Integer.parseInt(e2_val);
                                    return boolR+"!bool"; 
                              }
                           default:
                              break;
                        }
                     }
                  case ">=":
                      if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Double.parseDouble(e1_val) >= Double.parseDouble(e2_val);
                                    return boolR +"!bool";
                                 case "int":
                                   boolR = Double.parseDouble(e1_val) >= Integer.parseInt(e2_val);
                                   return boolR+"!bool"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Integer.parseInt(e1_val) >= Double.parseDouble(e2_val);
                                    return boolR+"!bool"; 
                                 case "int":
                                    boolR = Integer.parseInt(e1_val) >= Integer.parseInt(e2_val);
                                    return boolR+"!bool"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "==":
                      if(isCompatible(e1_type, e2_type,operator, column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Double.parseDouble(e1_val) == Double.parseDouble(e2_val);
                                    return boolR +"!bool";
                                 case "int":
                                   boolR = Double.parseDouble(e1_val) == Integer.parseInt(e2_val);
                                   return boolR+"!bool"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Integer.parseInt(e1_val) == Double.parseDouble(e2_val);
                                    return boolR+"!bool"; 
                                 case "int":
                                    boolR = Integer.parseInt(e1_val) == Integer.parseInt(e2_val);
                                    return boolR+"!bool"; 
                              }
                           case "string":
                              switch(e2_type){
                                 case "string":
                                 boolR = (e1_val.equals(e2_val));
                                 return boolR+"!bool"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "!=":
                      if(isCompatible(e1_type, e2_type, operator,column, row, content)){
                        switch(e1_type){
                           case "double":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Double.parseDouble(e1_val) != Double.parseDouble(e2_val);
                                    return boolR +"!bool";
                                 case "int":
                                   boolR = Double.parseDouble(e1_val) != Integer.parseInt(e2_val);
                                   return boolR+"!bool"; 
                              }
                           case "int":
                              switch(e2_type)
                              {
                                 case "double":
                                    boolR = Integer.parseInt(e1_val) != Double.parseDouble(e2_val);
                                    return boolR+"!bool"; 
                                 case "int":
                                    boolR = Integer.parseInt(e1_val) != Integer.parseInt(e2_val);
                                    return boolR+"!bool"; 
                              }
                           case "string":
                              switch(e2_type){
                                 case "string":
                                 boolR = (!e1_val.equals(e2_val));
                                 return boolR+"!bool"; 
                              }
                           default:
                              break;
                        }
                     }
                  case "&&":
                      if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                          boolR = Boolean.parseBoolean(e1_val) && Boolean.parseBoolean(e2_val);
                          return boolR +"!bool";
                     }
                  case "||":
                      if(isCompatible(e1_type, e2_type, operator, column, row, content)){
                          boolR = Boolean.parseBoolean(e1_val) || Boolean.parseBoolean(e2_val);
                          return boolR +"!bool";
                     }
                  default:
                      break;
              }
                AddError(column, row, content, "No se puede realizar dicha operacion");
               return "null!comodin";
         }
         else
         {
            isCompatible(e1_type, e2_type, operator, column, row, content);
            return "null!comodin";
         }
     }
     catch(Exception e)
     {
        AddError(column, row, content, "No se puede realizar dicha operacion");
        return "null!comodin";
     }
  }
  
   public static boolean isCompatible(String type1, String type2, String operator, int column, int row, String content)
   {
      boolean is = false;
      switch(type1)
      {
         case "string":
            is = type2.equals("string");
            break;
         case "double":
            is = type2.equals("double") || type2.equals("int") || (type2.equals("string")&& operator.equals("+"));
            break;
         case "int":
            is = type2.equals("doble") || type2.equals("int") || (type2.equals("string")&& operator.equals("+"));
            break;
         case "bool":
            is = type2.equals("bool") || (type2.equals("string")&& operator.equals("+"));
           break;
         default:
            break;
      }
      
      if(!is){
         AddError(column, row, content, "No se puede operar el tipo "+type1+" con el tipo "+type2);
      }
      
      return is;
   }
  public static void popEnvironmentQueue(){
     int index = environmentQueue.size() - 1;
      environmentQueue.remove(index);
  }
   
    public static String peekEnvironmentQueue(){
     int index = environmentQueue.size() - 1;
      return environmentQueue.get(index);
  }
   
  public static String peek2PositionsEnvironmentQueue(){
     int index = environmentQueue.size() - 2;
      return environmentQueue.get(index);
  }
  public static void pushEnvironmentQueue(){
     environmentQueue.add(getGUID());
  }
  
  
  
    /*No se si este metodo se utiliza*/
  private static boolean ExistClassInterfase(String id, String environment){
     for (SymbolClassInterfase SCI : Symbol_Class_Interfase) {
      if(SCI.identifier.equals(id) && SCI.environment.equals(environment)){
         return true;
      }
     }
     return false;
  }
  private static boolean ExistIdOnSymbolList(String id, String environment)
  {
     for (SymbolT S : Symbol_list) {
      if(S.identifier.equals(id) && S.environment.equals(environment)){
         return true;
      }
     }
     return false;
  }
  
  private static boolean ExistIdOnFunctionSymbolList(String id, String environment)
  {
     for (SymbolFunction S : Symbol_function_list) {
      if(S.identifier.equals(id) && S.itsEnvironment.equals(environment)){
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
  
  private static String getGUID(){
     return UUID.randomUUID().toString().substring(0, 20);
  }
  
}
