package Manipulation;

import static Manipulation.ConcatenateDataFrame.group11;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveNullDataFrame extends ConnectorPart2{
    public static String Newfilepath;
    public static String filepath3;
     
    
    public static void GotoNewCsv(){
        System.out.print("Enter new file name to save data after process: ");
        Newfilepath=group11.next();
        System.out.println("");
    }
    
    public static void ReadFile3(){
        System.out.print("Enter file name that u want to use: ");
        filepath3=group11.next();
        System.out.println("");
    }
    
    public static void deleteRecord(){
        System.out.print("Enter the number of null columns to be deleted: ");
        int NumColumn=group11.nextInt();
        
        String[] ColumnName=new String[NumColumn];
        
        for(int loop=0;loop<NumColumn;loop++){
            System.out.print("Enter the name of " +(loop+1) +" column to be deleted: ");
            ColumnName[loop]=group11.next();
        }

        GotoNewCsv();
        
        try{
            Scanner csv= new Scanner(new FileInputStream(filepath3));
            int column1=0; 
            int row1=0;
        
            while(csv.hasNextLine()){
                  String s1=csv.nextLine();
                  String [] s1_spilt = s1.trim().split(",");
                  row1 = s1_spilt.length;
                  column1 ++;
            }
            
            Scanner csv2= new Scanner(new FileInputStream(filepath3));
            String[][] line = new String [column1][row1];
            for(int i = 0; i<column1 ; i++){
                String s1 = csv2.nextLine();
                s1 += ", ,";
                String [] s1_split = s1.split(",");
                for(int j = 0; j<row1; j++){
                    line[i][j] = s1_split[j];
                }
            } 
           
            int remove1=0; 
            int remove2=0;
            int i=0;
            for(int loop=0;loop<NumColumn;loop++){
            
            for (int j=0; j<row1; j++){
                if(ColumnName[loop].equalsIgnoreCase(line[i][j])){
                   remove1=j;
                }
                else if(ColumnName[loop].equalsIgnoreCase(line[i][j])){
                   remove2=j;
                }
            }
            }
            int remove_column=0;
            for(int k=0;k<column1;k++){      
               int error1=0; 
               int error2=0;
                for(int j=0;j<row1;j++){
                    if(line[k][j].isBlank() && j==remove1){
                       error1=-1;
                    }else if (line[k][j].isBlank() && j==remove2){
                       error2=-1;
                    }
                } 
                if(error1==-1 && error2==-1){ 
                   remove_column=k;
                }       
            }
            FileOutputStream fos = new FileOutputStream(Newfilepath,true);
            PrintWriter pw = new PrintWriter(fos);
            for(int k=0;k<column1;k++){     
                if(k==remove_column)
                  continue;
            for(int j=0;j<row1;j++){
               System.out.printf("%-30s", line[k][j]);
               pw.print(line[k][j]+",");
            }
            
            System.out.println("");
            pw.println();
            }
            pw.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
        }
    }    
    
}
