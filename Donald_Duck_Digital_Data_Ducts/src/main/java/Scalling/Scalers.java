package Scalling;

import static Main.TesterDonald.group11;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scalers extends ConnectorPart4{
    public static String filepath5;
    
    public static void ReadFile5(){
        System.out.println("Enter file name that u want to use: ");
        filepath5=group11.next();
        System.out.println("");
    }
    public static void Scalling(){
        
        try{
            System.out.println("");
            ReadFile5();
            System.out.println("Please enter the name of column: ");
            Scanner sc= new Scanner(System.in);
            String header = sc.nextLine();
            File a = new File (filepath5);
            Scanner sc2 = new Scanner (a);
            String s1 = sc2.nextLine();
            String []s1_split = s1.split(",");
            int column = 0;  
            
            for(int i = 0; i<s1_split.length; i++){
               if(s1_split[i].equalsIgnoreCase(header)){ 
                   column = i; 
               }
            }
            int row = 0;
            while (sc2.hasNextLine()){
                String test = sc2.nextLine();
                row ++; 
            }
        
            double[] data = new double [row];
            Scanner sc3 = new Scanner(a);
            String test2 = sc3.nextLine();
            int k = 0;
            while (sc3.hasNextLine()){
                String s2 = sc3.nextLine();
                String [] s2_split = s2.split(",");
                double value = Double.parseDouble(s2_split[column]);
                data[k] = value; k++;
            }
            System.out.println("\nThe values of " + header + " are: ");      
            for (double value : data){
                System.out.print(value + "  ");
            } 
            System.out.println("\n\n");
            System.out.println("What do you wish to do with the data (1 for standard scaling/ 2 for min max scaling): ");
            int key = sc.nextInt();
            double sum = 0; double sumofsquare = 0;
            if (key == 1){
                for(int i = 0; i<row; i++) {
                   sum += data[i];
                   double square = data[i]*data[i];
                   sumofsquare += square;
                }
                   double squareofsum = sum*sum;
                   double answer = ((sumofsquare*row)-squareofsum)/(row*(row-1));
                   double standard_deviation = Math.pow(answer, 0.5);
                   double average = sum/row;
                   System.out.println("\nThe values after standard scaling: ");
                for(int i = 0; i<row; i++) {
                   double standard = (data[i]-average)/standard_deviation;
                   System.out.printf("%-15f", standard);
                }
            }else if(key == 2){
                double min = data[0]; 
                double max = data[0]; 
                for(int i = 0; i<row; i++){
                    if(data[i]>max){
                        max = data[i];
                    }
                    if (data[i]<min) {
                        min = data[i];
                    }
                } 
                double range = max - min;
                System.out.println("\nThe values after min max scaling: ");
                for (int i = 0; i<row; i++){ 
                    double minmax = (data[i]-min)/range;
                    System.out.printf("%-15f" , minmax);
                }
            }else 
                System.out.println("invalid key!"); 
            System.out.println("");
        } catch (FileNotFoundException e){
            System.out.println("error in file input");
        }
        
    }
}
