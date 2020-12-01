package Main;

import DataFrame.ConnectorPart_1;
import DataFrame.ConstructDataFrame;
import DataFrame.ScanNewData;
import Manipulation.ConnectorPart2;
import java.io.IOException;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        
        Scanner group11 = new Scanner(System.in);
        System.out.println("1-Adding new data");
        System.out.println("2-Managing data");
        System.out.println("Enter step(1-6) to be proceed: ");
        int step=group11.nextInt();
        System.out.println("");
        
        if(step==1){
            
           ConnectorPart_1 c1 = new ConnectorPart_1();
           c1.display1();
           c1.display2();
           
        }else if(step==2){
            System.out.println();
            System.out.println("1 - Concatenate data");
            System.out.println("2 - Obtain specific data");
            System.out.println("3 - Data sorting");
            System.out.println("4 - Remove duplicated data in row");
            System.out.println("5 - Remove data with null value");
            System.out.println("Enter step to proceed(1-5): ");
            step=group11.nextInt();
                if(step==1){
                    ConnectorPart2 c2 = new ConnectorPart2();
                    c2.DisplayPart1();
                }else if(step==2){
                   ConnectorPart2 c2 = new ConnectorPart2();
                   c2.DisplayPart2();
                }else if(step==3){
                    ConnectorPart2 c2 = new ConnectorPart2();
                    c2.DisplayPart3();
                }else if(step==4){
                   ConnectorPart2 c2 = new ConnectorPart2();
                   c2.DisplayPart4();
                }else if(step==5){
                   ConnectorPart2 c2 = new ConnectorPart2();
                   c2.DisplayPart5();
                }
        }
        
    }
}
