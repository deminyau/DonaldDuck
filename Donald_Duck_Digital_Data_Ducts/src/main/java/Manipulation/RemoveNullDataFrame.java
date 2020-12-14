package Manipulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveNullDataFrame extends ConnectorPart2{
    
    public static void deleteRecord(){
        
        Scanner group11 = new Scanner(System.in);
        
        System.out.println("Enter file to be inputed: ");
        String file=group11.nextLine();
        
        System.out.println("Enter the number of null columns to be deleted: ");
        String input =group11.nextLine();
        
        int n = Integer.parseInt(input);
        String [] header = new String[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the name of the column to be deleted: ");
            header[i]=group11.nextLine();
        }
   
        try{
            
            Scanner csv= new Scanner(new FileInputStream(file));
            int column=0; 
            int row=0;
        
            while(csv.hasNextLine()){
                  String s1=csv.nextLine();
                  String [] s1_spilt = s1.trim().split(",");
                  column = s1_spilt.length;
                  row ++;
            }
            
            Scanner csv2= new Scanner(new FileInputStream(file));
            String[][] data = new String [row][column];
            for(int i = 0; i<row ; i++){
                String s1 = csv2.nextLine();
                s1 += ", ,";
                String [] s1_split = s1.split(",");
                for(int j = 0; j<column; j++){
                    data [i][j] = s1_split[j];
                }
            } 
           
            int [] null_column_index = new int [n];
            
            for (int i = 0; i<n; i++){
                for (int j = 0; j<column; j++){
                    if (header[i].equalsIgnoreCase(data[0][j])){
                        null_column_index [i]= j;
                    }
                }
            }
            int remove_row = 0;
            stop :for (int i = 1; i<row; i++){
            int null_count = 0;
            for (int k = 0; k<n ; k++){
                for (int j = 0; j<column; j++){
                    if (data[i][j].isBlank() && j == null_column_index[k]){
                        null_count++;
                    }
                }
            }
            if (null_count == n) {
                remove_row = i; 
                   break 
                   stop;
            }
            }
            
            PrintWriter pw = new PrintWriter (file);
            for (int i = 0; i<row ; i++){
                if (i==remove_row) 
                    continue;
                for (int j = 0; j<column; j++){
                    System.out.printf("%-30s", data[i][j]);
                    pw.print(data[i][j] + ",");
                } System.out.println("");
                pw.println();
            } 
            pw.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }    
    
}
