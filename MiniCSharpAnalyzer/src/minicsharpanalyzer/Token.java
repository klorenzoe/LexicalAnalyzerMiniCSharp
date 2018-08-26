package minicsharpanalyzer;

import com.sun.javafx.binding.IntegerConstant;
import com.sun.javafx.binding.StringConstant;
import org.omg.CORBA.IdentifierHelper;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public enum Token
{
   ReservedWord, Identifier, Comments, IntegerConstant, BoolConstant, DoubleConstant, StringConstant, OperatorsAndPunctuation, ErrorComment, ErrorIdentifier, Error
}