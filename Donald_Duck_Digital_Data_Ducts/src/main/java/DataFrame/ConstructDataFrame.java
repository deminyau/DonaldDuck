package DataFrame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ConstructDataFrame {//constructor
    //instance variables
    public String name;
    public String deaprtment;
    public String CurrentCGPA;
    public String Expected_graduation_salary;
    public String Actual_graduation_salary;
    
    public static void SearchRecord(){
        Scanner group11 = new Scanner(System.in);
        
        System.out.println("Enter file name:");
        String fileName=group11.next().trim();
        
        try{
   
            Scanner uni= new Scanner(new FileInputStream(fileName));
            
            //uni.useDelimiter(",");
            System.out.println("Adding new data....");
            while(uni.hasNextLine()){
                
                String uniRow=uni.nextLine();
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
            System.out.println("");
            uni.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
        
    }
}
