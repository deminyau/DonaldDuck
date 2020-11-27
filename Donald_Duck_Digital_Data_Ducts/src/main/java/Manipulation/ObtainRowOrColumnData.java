package Manipulation;

import static DataFrame.ScanNewData.ScanNewDataFromOutputFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObtainRowOrColumnData extends ConnectorPart2 {
    public static Scanner group11 = new Scanner(System.in);
    public static String Newfilepath;
    
    public static void ObtainRecordInRow(){
        ScanNewDataFromOutputFile();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Enter start number for range: ");
        int RowRange1=group11.nextInt();
        System.out.println("Enter end number for range: ");
        int RowRange2=group11.nextInt();
        System.out.println("");
       
        try {
            Scanner csv= new Scanner(new FileInputStream("DataStorage.csv"));
            int column = 0; 
            int row  = 0;
            
            while (csv.hasNextLine()){
                String s1 = csv.nextLine();
                String [] s1_spilt = s1.split(",");
                row = s1_spilt.length;
                column ++;
            }
            
            Scanner csv2= new Scanner(new FileInputStream("DataStorage.csv")); 
            String [][] file = new String [column][row];
            for (int i=0;i<column;i++){
                String s1 = csv2.nextLine();
                String [] s1_split = s1.split(",");
                for (int j = 0; j<row; j++){
                    file[i][j] = s1_split[j];
                }
            } 
            int i=RowRange1;
            for (int j=0; j<row; j++){
                System.out.printf("%-30s", file[i][j]);
            }
            System.out.println("");
            
            i=RowRange2;
            for(int j=0; j<row; j++){
                System.out.printf("%-30s", file[i][j]);
            }
            System.out.println("");
            
            for (i=RowRange2+1;i<column;i++){
               for(int j=0; j<row; j++){
                   System.out.printf("%-30s", file[i][j]);
               }
                System.out.println("");
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }
    
      public static void ObtainRecordInColumn(){
        ScanNewDataFromOutputFile();
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("Enter name of first columns: ");
        String NameColumns1=group11.nextLine();
        System.out.println("Enter name of second columns: ");
        String NameColumns2=group11.nextLine();
        
        System.out.println("");
         
            try {
                Scanner csv= new Scanner(new FileInputStream("DataStorage.csv"));
                int column = 0; 
                int row  = 0;
                
                while (csv.hasNextLine()){
                    String s1 = csv.nextLine();
                    String [] s1_spilt = s1.split(",");
                    row = s1_spilt.length;
                    column++;
                }
            
                Scanner csv2= new Scanner(new FileInputStream("DataStorage.csv")); 
                String[][] file = new String [column][row];
                
                for(int i=0;i<column;i++){
                    String s1 = csv2.nextLine();
                    String [] s1_split = s1.split(",");
                    for (int j=0;j<row;j++){
                           file[i][j] = s1_split[j];
                    } 
                }
                int i=0;
                int nc1=0;
                int nc2=0;
                for (int j=0;j<row;j++){
                    if(NameColumns1.equalsIgnoreCase(file[i][j])){
                        nc1=j;
                    }
                    if(NameColumns2.equalsIgnoreCase(file[i][j])){
                        nc2=j;
                    }
                }
                for (int k=0;k<column; k++){
                     int j=nc1;
                     System.out.printf("%-30s", file[k][j]);
                     j=nc2;
                     System.out.printf("%-30s", file[k][j]);
                     System.out.println("");
                }
            }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        } 
    }
    
}
