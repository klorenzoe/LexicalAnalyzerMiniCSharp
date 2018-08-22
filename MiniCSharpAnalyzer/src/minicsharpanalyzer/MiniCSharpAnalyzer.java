/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharpanalyzer;

import java.io.File;

/**
 *
 * @author usuario
 */
public class MiniCSharpAnalyzer
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      // TODO code application logic here
      String file_path = "C:\\Users\\usuario\\Desktop\\Universidad\\Sexto ciclo\\Compiladores\\LexicalAnalyzerMiniCSharp\\MiniCSharpAnalyzer\\src\\minicsharpanalyzer";
      Generate_lexer_file(file_path);
   }
   
   public static void Generate_lexer_file(String sourcesPath){
      File source = new File(sourcesPath);
      JFlex.Main.generate(source);
   }
}
