package Main;

import DataFrame.ConnectorPart1;
import Manipulation.ConnectorPart2;
import Scalling.ConnectorPart4;
import StatisticsAndImputers.ConnectorPart3;
import java.io.IOException;
import java.util.Scanner;

public class TesterDonald {
    
    public static void Message1(){
        System.out.println("");
        System.out.println("1 - Adding new data");
        System.out.println("2 - Managing data");
        System.out.println("3 - Statistic");
        System.out.println("4 - Scalers");
        System.out.println("5 - K-Nearest Neighbors(k-nn)");
        System.out.println("-1 - Exit");
    }
    public static void Message2(){
        System.out.println();
        System.out.println("1 - Concatenate data");
        System.out.println("2 - Obtain specific data");
        System.out.println("3 - Data sorting");
        System.out.println("4 - Remove duplicated data in row");
        System.out.println("5 - Remove data with null value");
    }
    public static void Message3(){
        System.out.println("");
        System.out.println("1 - Get overall statistics");
        System.out.println("2 - Fill missing values");
    }
    
    public static void main(String[] args) throws IOException {
        
        Scanner group11 = new Scanner(System.in);
        
        Message1();
        System.out.println("Enter step(1-6) to be proceed: ");
        int step=group11.nextInt();
        System.out.println("");
        
        do{
          if(step==1){
            System.out.println("Are u sure u want to proceed? If YES please enter (1).If NO please enter (-1) to back to the previous step: ");
            int stepA=group11.nextInt();
            System.out.println("");
            
            if(stepA==1){
               ConnectorPart1 c1 = new ConnectorPart1();
               c1.display1();
               c1.display2();
            }else if(stepA==-1){
                Message1();
                System.out.println("Enter step(1-6) to be proceed: ");
                step=group11.nextInt();
            }else{
                System.out.println("Invalid value!!!");
                System.out.println("");
            }
           
          }else if(step==2){
              
            Message2();
            System.out.println("Enter step to proceed(1-5): ");
            int stepB=group11.nextInt();
                if(stepB==1){
                    ConnectorPart2 c2 = new ConnectorPart2();
                    c2.DisplayPart1();
                }else if(stepB==2){
                   ConnectorPart2 c2 = new ConnectorPart2();
                   c2.DisplayPart2();
                }else if(stepB==3){
                    ConnectorPart2 c2 = new ConnectorPart2();
                    c2.DisplayPart3();
                }else if(stepB==4){
                   ConnectorPart2 c2 = new ConnectorPart2();
                   c2.DisplayPart4();
                }else if(stepB==5){
                   ConnectorPart2 c2 = new ConnectorPart2();
                   c2.DisplayPart5();
                }
          }else if(step==3){
              
            Message3();
            System.out.print("Enter step to proceed(1-2): ");
            int stepC=group11.nextInt();
            
            if(stepC==1){
                
            }else if(stepC==2){
                ConnectorPart3 c3 = new ConnectorPart3();
                c3.displaypart3b();
            }
            
          }else if(step==4){
              
            System.out.println("Are u sure u want to proceed? If yes please enter (1). If NO please enter (-1) to back to the previous step: ");
            int stepD=group11.nextInt();
            
            if(stepD==1){
                ConnectorPart4 c4 = new ConnectorPart4();
                c4.displayPart4();
            }else if(stepD==-1){
                Message1();
                System.out.println("Enter step(1-6) to be proceed: ");
                step=group11.nextInt();
            }else{
                System.out.println("Invalid value!!!");
                System.out.println("");
            }
          }
        }while(step!=-1);
        System.out.println("Please use me next time.Bye bye!!");
    }
}
