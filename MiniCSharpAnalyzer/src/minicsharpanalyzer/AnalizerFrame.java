/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicsharpanalyzer;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultStyledDocument;
/**
 *
 * @author usuario
 */
public class AnalizerFrame extends javax.swing.JFrame
{
   public File inputCode = null;
   public String fileName = "";

   /**
    * Creates new form Sumator
    */
   public AnalizerFrame()
   {
      initComponents();
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
      Singleton.ListInstances();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      jPanel1 = new javax.swing.JPanel();
      jScrollPane2 = new javax.swing.JScrollPane();
      txtCode = new javax.swing.JTextArea();
      jLabel1 = new javax.swing.JLabel();
      btnAnalyze = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      txtResult = new javax.swing.JTextArea();
      jLabel2 = new javax.swing.JLabel();
      btnSearchFile = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      txtSavedOn = new javax.swing.JTextField();
      openLexicalAnalysis = new javax.swing.JButton();
      txtPath = new javax.swing.JTextField();
      txtSymbolTableDir = new javax.swing.JTextField();
      jButton4 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jPanel1.setBackground(new java.awt.Color(60, 43, 62));

      txtCode.setColumns(20);
      txtCode.setRows(5);
      jScrollPane2.setViewportView(txtCode);

      jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(204, 140, 139));
      jLabel1.setText("C# code");

      btnAnalyze.setBackground(new java.awt.Color(245, 210, 188));
      btnAnalyze.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
      btnAnalyze.setForeground(new java.awt.Color(60, 43, 62));
      btnAnalyze.setText("Analyce Code");
      btnAnalyze.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            btnAnalyzeActionPerformed(evt);
         }
      });

      txtResult.setColumns(20);
      txtResult.setRows(5);
      jScrollPane1.setViewportView(txtResult);

      jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(204, 140, 139));
      jLabel2.setText("Done analysis");

      btnSearchFile.setBackground(new java.awt.Color(245, 210, 188));
      btnSearchFile.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
      btnSearchFile.setForeground(new java.awt.Color(60, 43, 62));
      btnSearchFile.setText("Search");
      btnSearchFile.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            btnSearchFileActionPerformed(evt);
         }
      });

      jLabel4.setBackground(new java.awt.Color(204, 140, 139));
      jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(204, 140, 139));
      jLabel4.setText("Saved on: ");

      txtSavedOn.setEnabled(false);
      txtSavedOn.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            txtSavedOnActionPerformed(evt);
         }
      });

      openLexicalAnalysis.setBackground(new java.awt.Color(245, 210, 188));
      openLexicalAnalysis.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
      openLexicalAnalysis.setForeground(new java.awt.Color(60, 43, 62));
      openLexicalAnalysis.setText("Open lexical analysis");
      openLexicalAnalysis.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            openLexicalAnalysisActionPerformed(evt);
         }
      });

      txtPath.setEnabled(false);

      txtSymbolTableDir.setEnabled(false);

      jButton4.setBackground(new java.awt.Color(245, 210, 188));
      jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
      jButton4.setForeground(new java.awt.Color(60, 43, 62));
      jButton4.setText("Open symbol table");
      jButton4.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton4ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(45, 45, 45)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(btnAnalyze))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(btnSearchFile)
                  .addGap(18, 18, 18)
                  .addComponent(txtPath)))
            .addGap(95, 95, 95)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(txtSymbolTableDir, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                  .addGap(32, 32, 32))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSavedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openLexicalAnalysis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                  .addGap(34, 34, 34))))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(jLabel2))
                  .addGap(0, 0, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(btnAnalyze)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel4)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnSearchFile)
               .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtSymbolTableDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jButton4))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(txtSavedOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(openLexicalAnalysis))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnAnalyzeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAnalyzeActionPerformed
   {//GEN-HEADEREND:event_btnAnalyzeActionPerformed
      // TODO add your handling code here:
      Rules.result_lexical_analyzer = "";
      
      try
      {
         if(inputCode!=null){
         String AnalyzeResult = AnalyzeTokens();
         PrintWriter writer = new PrintWriter(new File("outputContainer/"+fileName.split("\\.")[0]+".out"), "UTF-8");
                 writer.println(AnalyzeResult);
                 writer.close();
          
         PrintWriter writer2 = new PrintWriter(new File("symbolTables/"+fileName.split("\\.")[0]+".csv"), "UTF-8");
                  writer2.println(SymbolTableReulst(Singleton.Symbol_list, Singleton.Symbol_function_list, Singleton.Error_report));
                  writer2.close();
         }
         
         Singleton.ClearLists();
         
         txtSavedOn.setText("outputContainer/"+fileName.split("\\.")[0]+".out");
         txtSymbolTableDir.setText("symbolTables/"+fileName.split("\\.")[0]+".csv");
      }catch(Exception e)
      {
         String m = e.getMessage();
      }
   }//GEN-LAST:event_btnAnalyzeActionPerformed

   private void openLexicalAnalysisActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openLexicalAnalysisActionPerformed
   {//GEN-HEADEREND:event_openLexicalAnalysisActionPerformed
        // TODO add your handling code here:
      
      try{
         if(txtSavedOn.getText()!=""){
         File file = new File(txtSavedOn.getText());
        
        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
           JOptionPane.showMessageDialog(null,"The source to open the file is not supported for this PC ");
        }else{
           Desktop desktop = Desktop.getDesktop();
           if(file.exists()) desktop.open(file);
        }
      }
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,"The file is not possible to open...");
      }
   }//GEN-LAST:event_openLexicalAnalysisActionPerformed

   private void btnSearchFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSearchFileActionPerformed
   {//GEN-HEADEREND:event_btnSearchFileActionPerformed
      // TODO add your handling code here:
      try{
         JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt","*.frag","frag"));
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setDialogTitle("Choose file with the C# code");
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.showOpenDialog(chooser);
            
            inputCode = new File(chooser.getSelectedFile().getAbsolutePath());
            fileName = chooser.getSelectedFile().getName();
            txtPath.setText(fileName);
            
            BufferedReader codeFile = new BufferedReader(new FileReader(inputCode));
            String line;
            String input="";
              while ((line = codeFile.readLine()) != null){
                input+=line+"\n";
              }
             txtCode.setText(input);
            codeFile.close();
            txtSavedOn.setText("");
            txtResult.setText("");
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,"It is necessary a file (: ");
      }
   }//GEN-LAST:event_btnSearchFileActionPerformed

   private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
   {//GEN-HEADEREND:event_jButton4ActionPerformed
      // TODO add your handling code here:
       // TODO add your handling code here:
      try{
         if(txtSymbolTableDir.getText()!=""){
         File file = new File(txtSymbolTableDir.getText());
        
        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
           JOptionPane.showMessageDialog(null,"The source to open the file is not supported for this PC ");
        }else{
           Desktop desktop = Desktop.getDesktop();
           if(file.exists()) desktop.open(file);
        }
      }
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,"The file is not possible to open...");
      }
   }//GEN-LAST:event_jButton4ActionPerformed

   private void txtSavedOnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtSavedOnActionPerformed
   {//GEN-HEADEREND:event_txtSavedOnActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtSavedOnActionPerformed

   public String AnalyzeTokens() throws Exception{
     Reader reader = new FileReader(inputCode);
      Rules lexer=new Rules(reader);
      String results="";
      //while that run all the text and recognize the tokens
    /*  while(true){
          Token token = lexer.yylex();
          if(token==null){
            return results;
          }
      switch(token){
         case ReservedWord:
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_"+lexer.lexeme+"\n";
            break;
         case Identifier:
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_Identifier\n";
            break;
         case Comments:
            //results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_Comment\n";
            break;
         case IntegerConstant:
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_IntConstant\n";
            break;
         case BoolConstant:
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_BoolConstant\n";
            break;
         case DoubleConstant:
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_DoubleConstant\n";
            break;
         case StringConstant:
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_StringConstant\n";
            break;
         case OperatorsAndPunctuation:
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is '"+lexer.lexeme+"'\n";
            break;
         case ErrorComment:
            results+= "*** Error line "+(lexer.line+1)+".*** Doesn't finish the comment: "+lexer.lexeme+"\n";
            break;
         case ErrorIdentifier:
            results+= "*** line "+(lexer.line+1)+".*** Long identifier will be truncated: "+lexer.lexeme+"\n";
            lexer.lexeme = lexer.lexeme.substring(0, 30);
            results+= lexer.lexeme+"\t"+"line "+(lexer.line+1)+" cols "+(lexer.column+1)+"-"+(lexer.lexeme.length() + lexer.column)+" is T_Identifier\n";
            break;
         case Error:
            results+= "*** Error line "+(lexer.line+1)+".*** Unrecognized char: '"+lexer.lexeme+"'\n";
            break;
         default:
            results+= "*** Error line DEFAULT"+(lexer.line+1)+".*** Unrecognized char: ': "+lexer.lexeme+"'\n";
            }	
         }*/
      
     AnalyzeSyntactic(lexer);
     String lexerResult = lexer.result_lexical_analyzer;
     lexer.result_lexical_analyzer = "";
     return lexerResult;
   }
   
   private void AnalyzeSyntactic(Rules lexicalAnalyzer_)
   {
      try
      {
         SyntacticRules Syntactic = new SyntacticRules(lexicalAnalyzer_);
         Syntactic.parse();
         
         String ResultToReturn = Syntactic.report_error_result;
         if(ResultToReturn.equals(""))
         {
            ResultToReturn = "Correct!";
         }
         txtResult.setText(ResultToReturn);//Show the results on txtArea
      }
      catch(Exception e)
      {
         txtResult.setText(e.getMessage());
      }
   }
   
   private String SymbolTableReulst(ArrayList<SymbolT> Symbol_list, ArrayList<SymbolFunction> Symbol_function_list, ArrayList<ErrorSymbol> Error_report){
      String result = "";
      
      result+= "VARIABLES Y CONSTANTES \n";
      
      result+="Tipo,Identificador,Valor\n";
      for (SymbolT S : Symbol_list) {
        result+= S.type +","+S.identifier+","+S.value+"\n";
      }
      result +="\n";
      
      result += "FUNCIONES \n";
      result+="Tipo,Identificador,Parámetros\n";
        for (SymbolFunction SF : Symbol_function_list) {
         result+= SF.type+","+SF.identifier+",";
         for(SymbolT S : SF.parameters){
           result+= S.type + " " + S.identifier+"; ";
         }
         result+="\n";
        }
       
        result+="\n";
        
        result+="LOG DE ERRORES\n";
        result+="Columna,Fila,Contenido,**ERROR**\n";
        for(ErrorSymbol ES: Error_report){
           result+=ES.column +","+ ES.row+","+ES.line_content+","+ES.detail+"\n";
        }
        
        return result;
      }
   
   /**
    * @param args the command line arguments
    */
   public static void main(String args[])
   {
      /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      }
      catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(AnalizerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(AnalizerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(AnalizerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(AnalizerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
        //</editor-fold>
        //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new AnalizerFrame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAnalyze;
   private javax.swing.JButton btnSearchFile;
   private javax.swing.JButton jButton4;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JButton openLexicalAnalysis;
   private javax.swing.JTextArea txtCode;
   private javax.swing.JTextField txtPath;
   private javax.swing.JTextArea txtResult;
   private javax.swing.JTextField txtSavedOn;
   private javax.swing.JTextField txtSymbolTableDir;
   // End of variables declaration//GEN-END:variables
}
