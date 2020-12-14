package Main;

import DataFrame.ConnectorPart1;
import ExtraFeature.Chart;
import K_Nearest_Neighbors.ConnectorPart5;
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
        System.out.println("--------Page 1--------");
        System.out.println("1 - Adding new data");
        System.out.println("2 - Managing data");
        System.out.println("3 - Statistic");
        System.out.println("4 - Scalers");
        System.out.println("5 - K-Nearest Neighbors(k-nn)");
        System.out.println("6 - Generate charts");
        System.out.println("-1 - Exit");
        System.out.println("Enter step(1-6) to be proceed: ");
        step=group11.nextInt();
    }
    
    public static int stepA;
    public static void ChoiceMessageAND(){
        System.out.println("--------Page Adding new data--------");
        System.out.println("1 - Display data from csv file");
        System.out.println("2 - Key in data ");
        System.out.println("(-1) - Back to previous step");
        System.out.println("Enter step to proceed(1/2): ");
        stepA=group11.nextInt();
        System.out.println("");
    }
    
    public static int stepB;
    public static void ChoiceMessageMD(){
        System.out.println();
        System.out.println("--------Page Managing data--------");
        System.out.println("1 - Concatenate data");
        System.out.println("2 - Obtain specific data");
        System.out.println("3 - Data sorting");
        System.out.println("4 - Remove duplicated data in row");
        System.out.println("5 - Remove data with null value");
        System.out.println("(-1) - Back to previous step");
        System.out.println("Enter step to proceed(1-5): ");
        stepB=group11.nextInt();
        
    }
    
    public static int stepAfter_stepB;
    public static void ChoiceMessage_sAsB(){
        System.out.println("--------Choices--------");
        System.out.println("In this step, you have two choices.You can only choose one at the same time!");
        System.out.println("1 - Obtain data using range of row");
        System.out.println("2 - Obtain data using certain column");
        System.out.println("(-1) - Back to previous step");
        System.out.println("Enter step to proceed(1/2): ");
        stepAfter_stepB=group11.nextInt();
        
    }
    
    public static int stepC;
    public static void ChoiceMessageS(){
        System.out.println("--------Page Statistic--------");
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
                do{
                    ChoiceMessageAND();
                    if(stepA==1){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart1 c1 = new ConnectorPart1();
                            c1.DisplayPart1a();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepA==2){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart1 c1 = new ConnectorPart1();
                            c1.DisplayPart1b();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }
                }while(stepA!=-1);
                ChoiceMessage1();

          }else if(step==2){
                do{
                    ChoiceMessageMD();
                    if(stepB==1){ 
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart2a();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepB==2){
                        ChoiceMessage_sAsB();
                        if(stepAfter_stepB==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart2b2();
                        }else if(stepAfter_stepB==2){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart2b1();
                        }else if(stepAfter_stepB==-1){
                            ChoiceMessageMD();
                        }else{
                            InvalidMessage();
                            ChoiceMessage_sAsB();
                        }
                        ChoiceMessage_sAsB();
                    }else if(stepB==3){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart2c();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepB==4){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart2d();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepB==5){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart2 c2 = new ConnectorPart2();
                            c2.DisplayPart2e();
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
                   ChoiceMessageS();  
                    if(stepC==1){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart3 c3 = new ConnectorPart3();
                            c3.Displaypart3a();
                        }else if(aus==-1){
                            continue;
                        }else{
                            InvalidMessage();
                        }
                    }else if(stepC==2){
                        AreYouSureMessage();
                        if(aus==1){
                            ConnectorPart3 c3 = new ConnectorPart3();
                            c3.Displaypart3b();
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
                c4.DisplayPart4();
            }else if(stepD==-1){
                ChoiceMessage1();
            }else{
                InvalidMessage();
                System.out.println("");
            }
          }else if(step==5){
            System.out.println("Are u sure u want to proceed? If yes please enter (1). If NO please enter (-1) to back to the previous step: ");
            int stepE=group11.nextInt();
              
            if(stepE==1){
                ConnectorPart5 c5 = new ConnectorPart5();
                c5.DisplayPart5();
            }else if(stepE==-1){
                ChoiceMessage1();
            }else{
                InvalidMessage();
                System.out.println("");
            }
          }else if(step==6){
              System.out.println("Are u sure u want to proceed? If yes please enter (1). If NO please enter (-1) to back to the previous step: ");
              int stepF=group11.nextInt();
              if(stepF==1){
                  Chart c = new Chart();
                  c.ReadNumberOfGraduates();
                  c.getBarChart();
              }else if(stepF==-1){
                ChoiceMessage1();
            }else{
                InvalidMessage();
                System.out.println("");
            }  
          }
        }while(step!=-1);
        System.out.println("Please use me next time.Bye bye!!");
        
    }
}
