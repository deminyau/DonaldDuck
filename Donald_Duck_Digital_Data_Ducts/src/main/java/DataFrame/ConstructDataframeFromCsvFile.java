package DataFrame;

import static Main.TesterDonald.group11;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConstructDataframeFromCsvFile extends ConnectorPart1 {
    
    public static String filename;
    public static void ReadFile(){
        System.out.println("This file is used to display records.");
        System.out.print("Enter file: ");
        filename=group11.next();
    }
    
    public static void ScanDataFromFile(){
        ReadFile();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("Data in DataStorage: ");
        
        int totalRecord=0;
        try{
            Scanner csv= new Scanner(new FileInputStream(filename));
            
            int column = 0; 
            int row  = 0;
            
            while (csv.hasNextLine()){
                String s1 = csv.nextLine();
                String [] s1_spilt = s1.split(",");
                row = s1_spilt.length;
                column ++;
                totalRecord++;
            }
            
            Scanner csv2= new Scanner(new FileInputStream(filename)); 
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
            System.out.print("Total records: "+(totalRecord-1));
            System.out.println("");
            csv.close();
            
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }
}
