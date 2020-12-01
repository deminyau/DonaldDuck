package DataFrame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class ConstructDataFrame extends ConnectorPart_1{
    
    public static Scanner group11 = new Scanner(System.in);
    public static String filepath;
    
    public static void ReadFile(){ //Method read a csv file which is to collect new data
        System.out.println("Enter file name: ");
        filepath=group11.next();
        System.out.println();
    }
    
    public static void ScanFileCsvAndWriteToCsvFile(){ //Method to scan the file just read and write to an output file(DataStorage.csv)
        
        try{
            Scanner csv = new Scanner(new FileInputStream(filepath));
            
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("                                        Adding new data                                                    ");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            while(csv.hasNextLine()){
                
                String uniRow=csv.nextLine();
                String[] uniColumns=uniRow.split(",");
                String name=uniColumns[0];
                String department=uniColumns[1];
                String CurrentCGPA=uniColumns[2];
                String Expected_graduation_salary=uniColumns[3];
                String Actual_graduation_salary=uniColumns[4];
                
                System.out.printf("%s\t%-23s\t%-10s\t%-30s\t%-20s\n",name,department,CurrentCGPA,Expected_graduation_salary,Actual_graduation_salary);
                
                SaveDataFrame k = new SaveDataFrame(name,department,CurrentCGPA,Expected_graduation_salary,Actual_graduation_salary);
                SaveDataFrame.saveRecord();
                
            }
            csv.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }
}
