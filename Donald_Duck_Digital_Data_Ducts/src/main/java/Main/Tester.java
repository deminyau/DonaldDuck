package Main;

import DataFrame.ConstructDataFrame;
import DataFrame.ScanNewData;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        
        Scanner group11 = new Scanner(System.in);
        
        System.out.println("Enter step(1-6) to be proceed: ");
        int step=group11.nextInt();
        
        if(step==1){
            
        ConstructDataFrame a = new ConstructDataFrame();
        a.SearchRecord();
        ScanNewData b = new ScanNewData();
        b.ScanData();
        }else if(step==2){
            
        }
        
    }
}
