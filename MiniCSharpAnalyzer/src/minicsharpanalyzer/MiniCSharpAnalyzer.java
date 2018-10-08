/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharpanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.io.Reader;
import java.nio.file.StandardCopyOption;

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
      String LexerPath = "src\\minicsharpanalyzer\\Rules.flex";
      String SyntacticPath = "src\\minicsharpanalyzer\\SyntacticRules.cup";
      GenerateLexerFile(LexerPath);
      GenerateSyntacticFile(SyntacticPath);
      AnalizerFrame s = new AnalizerFrame();
      s.setVisible(true);
   }
   
   public static void GenerateLexerFile(String sourcesPath){
         try{
            File r = new File(sourcesPath);
            JFlex.Main.generate(r);
         }
         catch(Exception e){
         }
   }
   
   public static void GenerateSyntacticFile(String path){
      String[] commands = {"-parser", "SyntacticRules", path};
      try
      {
         String fromRules = "SyntacticRules.java";
         String fromSymbols = "sym.java";
         java_cup.Main.main(commands);
         Files.move(Paths.get(fromRules), Paths.get("src\\minicsharpanalyzer\\"+fromRules), StandardCopyOption.REPLACE_EXISTING);
         Files.move(Paths.get(fromSymbols), Paths.get("src\\minicsharpanalyzer\\"+fromSymbols), StandardCopyOption.REPLACE_EXISTING);
      }
      catch(Exception e)
      {
      }
   }
}
