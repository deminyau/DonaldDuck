package DataFrame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanNewData extends ConnectorPart_1{
    public static void ScanNewDataFromOutputFile(){ //Read new data from output file(DataStorage)
        
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("                                             Data in Storage                                               ");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        
        try{
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
                    System.out.printf("%-30s", file[i][j]);
                }
                System.out.println("");
            } 
            csv.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }
}
