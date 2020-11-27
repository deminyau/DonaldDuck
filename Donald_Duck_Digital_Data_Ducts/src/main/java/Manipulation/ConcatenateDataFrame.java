package Manipulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConcatenateDataFrame extends ConnectorPart2{
    public static void ConcatenateData(String main, String sub){
        try{
            File a = new File(main);
            Scanner sc1 = new Scanner (a);
            int column1 = 0; int row1  = 0;
            while (sc1.hasNextLine()){
                String s1 = sc1.nextLine();
                String [] s1_spilt = s1.trim().split(",");
                row1 = s1_spilt.length;
                column1 ++;
            }
            
            File b = new File (sub);
            Scanner sc2 = new Scanner (b);
            int column2 = 0; int row2  = 0;
            
            while (sc2.hasNextLine()){
                String s2 = sc2.nextLine();
                String [] s2_spilt = s2.trim().split(",");
                row2 = s2_spilt.length;
                column2 ++;
            }  
               
            Scanner sc3 = new Scanner(a); 
            String [][] file1 = new String [column1][row1];
            for (int i = 0; i<column1 ; i++){ //read from file 1
                String s1 = sc3.nextLine();
                String [] s1_split = s1.trim().split(",");
                for (int j = 0; j<row1; j++){
                    file1[i][j] = s1_split[j];
                }
            }
            Scanner sc4 = new Scanner(b);
            String [][] file2 = new String[column2][row2];
            for (int i = 0; i<column2; i++){
                String s2 = sc4.nextLine();
                String [] s2_split = s2.trim().split(",");
                for (int j = 0; j<row2 ; j++){
                    file2[i][j] = s2_split[j];
                }
            }
            
            PrintWriter pw = new PrintWriter(new FileOutputStream(a),true);
            if (column1 == column2){
                for (int i = 0; i<column1; i++ ){
                    int row = 0;
                    for (int j = 0; j<row1; j++){
                        System.out.printf("%-30s", file1[i][j]);
                        pw.print(file1[i][j] + ",");
                    } 
                    while(row<row2){
                         System.out.printf("%-30s", file2[i][row]); 
                         pw.print(file2[i][row] + ",");
                         row++;
                    }
                    System.out.println(""); pw.println();
                } 
                pw.close();
            }else if (row1 == row2){
                for (int i = 0; i<column1; i++ ){
                    for (int j = 0; j<row1; j++){
                        System.out.printf("%-30s", file1[i][j]);
                        pw.print(file1[i][j] + ",");
                    }
                    System.out.println(""); pw.println();
                }
                for (int i = 1; i<column2; i++ ){
                    for (int j = 0; j<row2; j++){
                        System.out.printf("%-30s", file2[i][j]);
                        pw.print(file2[i][j] + ",");
                    }
                    System.out.println(""); pw.println();
                }
                    pw.close();
            }else{
                System.out.println("Unequal number of column /row");
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found!!!");
        }
    }
    
}
