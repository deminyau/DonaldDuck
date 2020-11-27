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
        
        System.out.println("Enter step(1-6) to be proceed: ");
        int step=group11.nextInt();
        
        if(step==1){
            
           ConnectorPart_1 c1 = new ConnectorPart_1();
           c1.display1();
           c1.display2();
           
        }else if(step==2){
            System.out.print("Enter step to proceed(1-6): ");
            step=group11.nextInt();
                if(step==1){
                    ConnectorPart2 c2 = new ConnectorPart2();
                    c2.DisplayPart1();
                }
                if(step==2){
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
