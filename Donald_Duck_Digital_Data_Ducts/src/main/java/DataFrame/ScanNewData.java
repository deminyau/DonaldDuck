package DataFrame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanNewData extends ConnectorPart_1{
    public static void ScanNewDataFromOutputFile(){ //Read new data from output file(DataStorage)
        
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("Data in DataStorage: ");
        
        try{
            Scanner csv= new Scanner(new FileInputStream("DataStorage.csv"));
            
            while(csv.hasNextLine()){
                
                String uniRow=csv.nextLine();
                String[] uniColumns=uniRow.trim().split(",");
                String name=uniColumns[0];
                String department=uniColumns[1];
                String CurrentCGPA=uniColumns[2];
                String Expected_graduation_salary=uniColumns[3];
                String Actual_graduation_salary=uniColumns[4];
                
                System.out.printf("%s\t%-23s\t%-10s\t%-30s\t%-20s\n",name,department,CurrentCGPA,Expected_graduation_salary,Actual_graduation_salary);
            }   
            csv.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }
}
