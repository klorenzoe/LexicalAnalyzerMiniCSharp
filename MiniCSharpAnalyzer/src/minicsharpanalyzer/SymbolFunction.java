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
 */
public class SymbolFunction
{
   public String itsEnvironment;
   public String functionEnvironment;
   public String identifier;
   public String type; //int, double, string...
   ArrayList<SymbolT> parameters;
   
   public SymbolFunction(){
      parameters = new ArrayList<>();
   }
}
