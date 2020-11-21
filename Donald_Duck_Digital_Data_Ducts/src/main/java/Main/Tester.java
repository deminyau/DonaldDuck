package Main;

import DataFrame.ConnectorPart_1;
import DataFrame.ConstructDataFrame;
import DataFrame.ScanNewData;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        
        Scanner group11 = new Scanner(System.in);
        
        System.out.println("Enter step(1-6) to be proceed: ");
        int step=group11.nextInt();
        
        if(step==1){
            
           ConnectorPart_1 c1 = new ConnectorPart_1();
           c1.display1();
           c1.display2();
           
        }else if(step==2){
            
        }
        
    }
}
