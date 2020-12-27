package Manipulation;

import static DataFrame.ConstructDataframeFromCsvFile.ScanDataFromFile;
import static DataFrame.ConstructDataframeFromCsvFile.filename;
import static Main.TesterDonald.group11;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObtainRowOrColumnData extends ConnectorPart2 {
    
    public static void ObtainRecordInRow(){
        ScanDataFromFile();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Enter start number for range: ");
        int RowRange1=group11.nextInt();
        System.out.println("Enter end number for range: ");
        int RowRange2=group11.nextInt();
        System.out.println("");
        
        try {
            Scanner csv= new Scanner(new FileInputStream(filename));
            int column = 0; 
            int row  = 0;
            
            while (csv.hasNextLine()){
                String s1 = csv.nextLine();
                String [] s1_spilt = s1.split(",");
                row = s1_spilt.length;
                column ++;
            }
            
            Scanner csv2= new Scanner(new FileInputStream(filename)); 
            String [][] data = new String [column][row];
            for (int i=0;i<column;i++){
                String s1 = csv2.nextLine();
                String [] s1_split = s1.split(",");
                for (int j = 0; j<row; j++){
                    data[i][j] = s1_split[j];
                }
            } 
             for(int j=0; j<row; j++){
                System.out.printf("%-30s", data[0][j]);
            }
            System.out.println("");
            
            for (int j=0; j<row; j++){
                System.out.printf("%-30s", data[RowRange1][j]);
            }
            System.out.println("");
            
            
            for(int j=0; j<row; j++){
                System.out.printf("%-30s", data[RowRange2][j]);
            }
            System.out.println("");
            
            for (int i=RowRange2+1;i<column;i++){
               for(int j=0; j<row; j++){
                   System.out.printf("%-30s", data[i][j]);
               }
                System.out.println("");
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }
    
    public static void ObtainRecordInColumn(){
        Scanner group11 = new Scanner(System.in);
        
        File filename = new File ("DataStorage.csv");
        
     
        System.out.println("Enter the number of column you want to display: ");
        String input = group11.nextLine();
        
        int n = Integer.parseInt(input);
        
        String [] header = new String[n];
        for (int i = 0; i<n; i++){
            System.out.println("Enter name of column: ");
            header[i] = group11.nextLine();
        }
      
         
        try{
            Scanner csv= new Scanner (filename);
            int column = 0; 
            int row  = 0;
                
            while (csv.hasNextLine()){
                String s1 = csv.nextLine();
                String [] s1_spilt = s1.split(",");
                column = s1_spilt.length;
                row++;
            }
            
            Scanner csv2= new Scanner(filename); 
            String[][] data = new String [row][column];
                
            for(int i=0;i<row;i++){
                String s1 = csv2.nextLine();
                s1 += ", ,";
                String [] s1_split = s1.split(",");
                for (int j=0;j<column;j++){
                    data[i][j] = s1_split[j];
                } 
            }
            
            int [] column_index = new int [n];
            for (int k = 0; k<n; k++){ 
                for (int j = 0; j<column ; j++){
                    if (header[k].equalsIgnoreCase(data[0][j])){ 
                        column_index[k] = j;
                    }
                }
            }
               int i = 0;
               while (i<row){
                for ( int k = 0 ; k< n ;k++){
                    for (int j = 0; j<column; j++){
                        if (j == column_index[k]){
                            System.out.printf("%-30s", data [i][j]);
                        }
                    } 
                } 
                System.out.println(""); 
                i++;
                }
            }catch(FileNotFoundException e){
            System.out.println("File not found!!");
            } 
    }
    
}
