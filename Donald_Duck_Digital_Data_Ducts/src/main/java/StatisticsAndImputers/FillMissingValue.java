package StatisticsAndImputers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FillMissingValue extends ConnectorPart3{
    private static String filepath;
    private static Scanner group11 = new Scanner(System.in);
    
    private static void ReadCsv(){
        
        System.out.println("Enter file name that you want to use: ");
        filepath=group11.next();
        System.out.println("");
    }
    
    public static void FillValue() throws FileNotFoundException{
        ReadCsv();
        try{
        File a = new File(filepath);
        Scanner sc1 = new Scanner (a);
        int column1 = 0; int row1  = 0;
        while (sc1.hasNextLine()){
            String s1 = sc1.nextLine();
            String [] s1_spilt = s1.split(",");
            row1 = s1_spilt.length;
            column1 ++;
        }
                     
        Scanner sc2 = new Scanner(a); 
        String [][] file1 = new String [column1][row1];
        for(int i = 0; i<column1 ; i++){ //read from file 1
            String s1 = sc2.nextLine();
            s1 += ", ,";
            String [] s1_split = s1.trim().split(",");
            for(int j = 0; j<row1; j++){
                file1[i][j] = s1_split[j];
                System.out.printf("%-30s" , s1_split[j]);
            }
            System.out.println("");
        }   
        System.out.println("\n\n");     
        Scanner sc3 = new Scanner(a);
        String header = sc3.nextLine();
        Scanner sc4 = new Scanner (System.in);
        String [] header_split = header.split(",");
        for (int i = 0; i<column1 ; i++){
            for (int j = 0; j<row1; j++){
                if (file1 [i][j].isBlank() ){
                    System.out.println("Blank space found in column " + header_split[j] + " at row " + j);
                    System.out.print("Please enter value: ");
                    file1[i][j] = sc4.nextLine();
                    for (int k = 0; k<row1; k++){ 
                        System.out.printf("%-30s", file1[i][k]);
                    }
                    System.out.println("\n\n");;
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("                                        There is no missing value                                          ");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        PrintWriter pw = new PrintWriter(a);
        for(int i = 0; i<column1 ; i++){
            for(int j = 0; j<row1 ; j++){
                System.out.printf("%-30s", file1[i][j]);
                pw.print(file1[i][j] + ",");
            }
            System.out.println(""); 
            pw.println();
        }
        pw.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found!!");
            System.out.println("");
        }
    }
}
