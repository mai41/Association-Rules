/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Mai Rady Hassan Mohamed_20170302_IS-DS-4
//DataMining_Assignment1_AprioriAlgorithm
package dataminingassignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 *
 * @author pc
 */
public class DataMiningAssignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, BiffException{
        // TODO code application logic here
        Assignment1 assi=new Assignment1();
        assi.RetailDataSet();
        
        
    }
    
}
