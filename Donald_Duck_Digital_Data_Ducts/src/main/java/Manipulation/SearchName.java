package Manipulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SearchName extends ConnectorPart2{
     public static void Searchdata(){
        Scanner group11 = new Scanner(System.in);
        
        System.out.println("Enter file name: ");
        String SearchFile = group11.next();
        
        File filename = new File (SearchFile);
        System.out.println("Enter the name of person you wish to search: ");
        String name = group11.next();
        
            try {
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
                String[][] file = new String [row][column];
                  int index = 0;
                for(int i=0;i<row;i++){
                    String s1 = csv2.nextLine();
                    s1 += ", ,";
                    String [] s1_split = s1.split(",");
                  
                    for (int j=0;j<column;j++){
                        if (s1_split[j].equalsIgnoreCase(name)) {
                            index = i;}  
                        file[i][j] = s1_split[j];}
                    }
                if (index>0){
                System.out.println(name + " found at row " + (index+1));
                for (int i = 0; i<row ; i++){
                for (int j = 0; j<column; j++){
                    if (i == 0 || i == index ){
                    System.out.printf("%-30s", file[i][j]);} 
                    } System.out.println(""); }
                }
                else{
                    System.out.println("Name could not be found");
                }
               
            }catch (FileNotFoundException e){
                System.out.println("File Not Found.");
            } 
    }

}
