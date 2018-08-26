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
      String filePath = "src\\minicsharpanalyzer\\Rules.flex";
      GenerateLexerFile(filePath);
      Sumator s = new Sumator();
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
}
