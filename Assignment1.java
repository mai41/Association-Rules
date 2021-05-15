/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Mai Rady Hassan Mohamed_20170302_IS-DS-4
//DataMining_Assignment1_AprioriAlgorithm
package dataminingassignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author pc
 */
public class Assignment1 {
    public ArrayList iteration3(ArrayList<String> items,File scan,String minSupp) throws IOException, BiffException{
        ArrayList<String> itemSet=new ArrayList<>();
        ArrayList<String> itemSet2=new ArrayList<>();
        ArrayList<String> itemSet3=new ArrayList<>();
        ArrayList<String> supportCount=new ArrayList<>();
        ArrayList<String> test=new ArrayList<>();
        Workbook workbook=Workbook.getWorkbook(scan);
        Sheet sheet=workbook.getSheet(0);
        int r=sheet.getRows();
        int counter=0;
        for(int i=0;i<items.size();i++){
            for(int j=i;j<items.size();j++){
            for(int x=j;x<items.size();x++){
                if(i!=j&j!=x){
                itemSet.add(items.get(i));
                itemSet2.add(items.get(j));
                itemSet3.add(items.get(x));
        }}}}
        for(int x=0;x<r;x++){
            counter++;
            Cell c=sheet.getCell(3,x);
            Cell c2=sheet.getCell(4,x);
            Cell c3=sheet.getCell(5,x);
            test.add(c.getContents());
            test.add(c2.getContents());
            test.add(c3.getContents());
            for(int i=0;i<itemSet.size();i++){
                if(counter>1){
                    if(test.contains(itemSet.get(i))&test.contains(itemSet2.get(i))&test.contains(itemSet3.get(i))){
                        int j=Integer.parseInt(supportCount.get(i));
                        supportCount.set(i, Integer.toString(j+1));
                    }
                }
                if(counter==1){
                    if(test.contains(itemSet.get(i))&test.contains(itemSet2.get(i))&test.contains(itemSet3.get(i))){
                        supportCount.add(Integer.toString(counter));
                    }
                    if(!(test.contains(itemSet.get(i))&test.contains(itemSet2.get(i))&test.contains(itemSet3.get(i)))){
                        supportCount.add("0");
                    }
                }
            }
                test.clear();
        }
        for(int x=0;x<supportCount.size();x++){
            if(Integer.parseInt(supportCount.get(x))>=Integer.parseInt(minSupp)){
                test.add(itemSet.get(x));
                test.add(itemSet2.get(x));
                test.add(itemSet3.get(x));
                test.add(supportCount.get(x));
            }
        }
        return test;
    }
    
    public ArrayList iteration2(ArrayList<String> items,File scan,String minSupp) throws IOException, BiffException{
        ArrayList<String> itemSet=new ArrayList<>();
        ArrayList<String> itemSet2=new ArrayList<>();
        ArrayList<String> supportCount=new ArrayList<>();
        ArrayList<String> test=new ArrayList<>();
        Workbook workbook=Workbook.getWorkbook(scan);
        Sheet sheet=workbook.getSheet(0);
        int r=sheet.getRows();
        int counter=0;
        for(int i=0;i<items.size();i++){
            for(int j=i;j<items.size();j++){
                if(i!=j){
                itemSet.add(items.get(i));
                itemSet2.add(items.get(j));
        }}}
        for(int x=0;x<r;x++){
            counter++;
            Cell c=sheet.getCell(3,x);
            Cell c2=sheet.getCell(4,x);
            Cell c3=sheet.getCell(5,x);
            test.add(c.getContents());
            test.add(c2.getContents());
            test.add(c3.getContents());
            for(int i=0;i<itemSet.size();i++){
                if(counter>1){
                    if(test.contains(itemSet.get(i))&test.contains(itemSet2.get(i))){
                        int j=Integer.parseInt(supportCount.get(i));
                        supportCount.set(i, Integer.toString(j+1));
                    }
                }
                if(counter==1){
                    if(test.contains(itemSet.get(i))&test.contains(itemSet2.get(i))){
                        supportCount.add(Integer.toString(counter));
                    }
                    if(!(test.contains(itemSet.get(i))&test.contains(itemSet2.get(i)))){
                        supportCount.add("0");
                    }
                }
            }
                test.clear();
        }
        for(int x=0;x<supportCount.size();x++){
            if(Integer.parseInt(supportCount.get(x))>=Integer.parseInt(minSupp)){
                test.add(itemSet.get(x));
                test.add(itemSet2.get(x));
                test.add(supportCount.get(x));
            }
        }//System.out.println(test);
        return test;
    }
    
    public void RetailDataSet() throws FileNotFoundException, IOException, BiffException{
        Scanner in=new Scanner(System.in);
        Scanner in2=new Scanner(System.in);
        System.out.println("Please enter minimum support count: ");
        String minSupportCount=in.nextLine();
        System.out.println("Please enter confidence: ");
        String confidence=in2.nextLine();
        File excel=new File("D:\\Users\\DataMining\\Assignment1\\Assignment1\\CoffeeShopTransactions.xls");
        ArrayList<String> items=new ArrayList<String>();
        ArrayList<String> itemSet=new ArrayList<String>();
        ArrayList<String> supportCount=new ArrayList<String>();
        ArrayList<String> itemSet2=new ArrayList<String>();
        ArrayList<String> supportCount2=new ArrayList<String>();
        Workbook workbook=Workbook.getWorkbook(excel);
        Sheet sheet=workbook.getSheet(0);
        int r=sheet.getRows();
        for(int i=1;i<r;i++){
            Cell c=sheet.getCell(3,i);
            Cell c2=sheet.getCell(4,i);
            Cell c3=sheet.getCell(5,i);
            items.add(c.getContents());
            items.add(c2.getContents());
            items.add(c3.getContents());
            //System.out.println(items);
            for(int j=0;j<items.size();j++){
                if(!(itemSet2.contains(items.get(j)))){
                    itemSet2.add(items.get(j));
                }
            }
            for(int x=0;x<itemSet2.size();x++){
            if(itemSet.contains(itemSet2.get(x))){
                int j=itemSet.indexOf(itemSet2.get(x));
                int sc=Integer.parseInt(supportCount.get(j));
                supportCount.set(j,Integer.toString(sc+1));
            }
            else if(!(itemSet.contains(itemSet2.get(x)))){
                itemSet.add(itemSet2.get(x));
                supportCount.add("1");
            }
        }
            items.clear();itemSet2.clear();
        }
        System.out.println("1-itemSet: ");
        System.out.println(itemSet);
        System.out.println(supportCount);
        for(int i=0;i<itemSet.size();i++){
            if(Integer.parseInt(supportCount.get(i))>=Integer.parseInt(minSupportCount)){
                itemSet2.add(itemSet.get(i));
                supportCount2.add(supportCount.get(i));
            }
        }
        System.out.println("1-itemSet after editing:");
        System.out.println(itemSet2);
        System.out.println(supportCount2);
        System.out.println("2-itemSet: ");
        System.out.println(iteration2(itemSet2,excel,minSupportCount));
        System.out.println("3-itemSet: ");
        System.out.println(iteration3(itemSet2,excel,minSupportCount));
        System.out.println();
        
        float supp = 0;
        int index=0;
         if(iteration3(itemSet2, excel, minSupportCount).isEmpty()){
            itemSet=iteration2(itemSet2, excel, minSupportCount);
            for(int i=0;i<itemSet.size();i+=3){
                for(int j=i+1;j<itemSet.size();j+=3){
                    for(int x=j+1;x<itemSet.size();x+=3){
                        if(i!=j&j!=x){
                        if(itemSet2.contains(itemSet.get(i))){
                            index=itemSet2.indexOf(itemSet.get(i));
                            supp=Float.parseFloat(supportCount2.get(index));
                        }
                        float conf=(Integer.parseInt(itemSet.get(x))/supp)*100;
                        if(conf>=Float.parseFloat(confidence)){
                        System.out.println(itemSet.get(i)+"-->"+itemSet.get(j)+"-->"+conf);}
                        break;
                        }}break;}
            }
        }
        else{
            itemSet=iteration3(itemSet2, excel, minSupportCount);
            supportCount=iteration2(itemSet2, excel, minSupportCount);
            float supp2=0;
            for(int i=0;i<itemSet.size();i+=4){
                for(int j=i+1;j<itemSet.size();j+=4){
                    for(int x=j+1;x<itemSet.size();x+=4){
                        for(int y=x+1;y<itemSet.size();y+=4){
                        ArrayList<String> s=new ArrayList<>();
                        ArrayList<String> a1=new ArrayList<>();
                        ArrayList<String> a2=new ArrayList<>();
                        s.add(itemSet.get(i));
                        s.add(itemSet.get(j));
                        s.add(itemSet.get(x));
                             for(int m=0;m<s.size();m++){
                                 a1.add(s.get(m));
                                 if(itemSet2.contains(s.get(m))){
                                     int index1=itemSet2.indexOf(s.get(m));
                                     supp=Float.parseFloat(supportCount2.get(index1));
                                 }
                                 for(int n=0;n<s.size();n++){
                                     if(!(a1.contains(s.get(n)))){
                                         a2.add(s.get(n));
                             }}
                                 for(int l=0;l<supportCount.size();l+=3){
                                     for(int n=l+1;n<supportCount.size();n+=3){
                                         for(int b=n+1;b<supportCount.size();b+=3){
                                     if(supportCount.get(l)==a2.get(0)&supportCount.get(n)==a2.get(1)){
                                         index=supportCount.indexOf(supportCount.get(b));
                                         supp2=Float.parseFloat(supportCount.get(index));}
                                         break;}break;}}
                                 float conf1=(Float.parseFloat(itemSet.get(y))/supp)*100;
                                 float conf2=(Float.parseFloat(itemSet.get(y))/supp2)*100;
                                 if(conf1>=Float.parseFloat(confidence)){
                                 System.out.println(a1+"-->"+a2+"-->"+conf1);}
                                 if(conf2>=Float.parseFloat(confidence)){
                                 System.out.println(a2+"-->"+a1+"-->"+conf2);}
                                 a1.clear();a2.clear();}
               break;}break;}break;}
            }
        }
}
}
