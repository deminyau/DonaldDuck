package Main;

import DataFrame.ConnectorPart1;
import Manipulation.ConnectorPart2;
import Scalling.ConnectorPart4;
import StatisticsAndImputers.ConnectorPart3;
import java.io.IOException;
import java.util.Scanner;

public class TesterDonald {
    
    public static Scanner group11 = new Scanner(System.in);
    
    public static int step;
    public static void ChoiceMessage1(){
        System.out.println("");
        System.out.println("1 - Adding new data");
        System.out.println("2 - Managing data");
        System.out.println("3 - Statistic");
        System.out.println("4 - Scalers");
        System.out.println("5 - K-Nearest Neighbors(k-nn)");
        System.out.println("-1 - Exit");
        System.out.println("Enter step(1-6) to be proceed: ");
        step=group11.nextInt();
    }
    
    public static int stepB;
    public static void ChoiceMessage2(){
        System.out.println();
        System.out.println("1 - Concatenate data");
        System.out.println("2 - Obtain specific data");
        System.out.println("3 - Data sorting");
        System.out.println("4 - Remove duplicated data in row");
        System.out.println("5 - Remove data with null value");
        System.out.println("(-1) - Back to previous step");
        System.out.println("Enter step to proceed(1-5): ");
        stepB=group11.nextInt();
        
    }
    
    public static int stepC;
    public static void ChoiceMessage3(){
        System.out.println("1 - Get overall statistics");
        System.out.println("2 - Fill missing values");
        System.out.println("(-1) - Back to previous step");
        System.out.println("Enter step to proceed(1/2): ");
        stepC=group11.nextInt();

    }
    
    public static int aus;
    public static void AreYouSureMessage(){
        System.out.println("Are u sure u want to proceed? If YES please enter (1).If NO please enter (-1) to back to the previous step:");
        aus=group11.nextInt();
        
    }
    
    public static void InvalidMessage(){
        System.out.println("Invalid input!! Please enter again value.");
    }
    
    public static void main(String[] args) throws IOException {
        
        ChoiceMessage1();
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
                ChoiceMessage1();
                step=group11.nextInt();
            }else{
                System.out.println("Invalid value!!!");
                System.out.println("");
            }
           
          }else if(step==2){
                do{
                    ChoiceMessage2();
                    if(stepB==1){ 
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart1();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepB==2){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart2();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepB==3){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart3();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepB==4){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart4();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepB==5){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart5();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }
                }while(stepB!=-1);
                ChoiceMessage1();
          }else if(step==3){
                do{
                   ChoiceMessage3();  
                    if(stepC==1){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart3 c3 = new ConnectorPart3();
                            c3.displaypart3a();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepC==2){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart3 c3 = new ConnectorPart3();
                            c3.displaypart3b();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    } 
                }while(stepC!=-1);
                ChoiceMessage1();

          }else if(step==4){
              
            System.out.println("Are u sure u want to proceed? If yes please enter (1). If NO please enter (-1) to back to the previous step: ");
            int stepD=group11.nextInt();
            
            if(stepD==1){
                ConnectorPart4 c4 = new ConnectorPart4();
                c4.displayPart4();
            }else if(stepD==-1){
                ChoiceMessage1();
            }else{
                System.out.println("Invalid value!!!");
                System.out.println("");
            }
          }
        }while(step!=-1);
        System.out.println("Please use me next time.Bye bye!!");
    }
}
