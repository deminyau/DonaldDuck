package K_Nearest_Neighbors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class knn extends ConnectorPart5 {
    public static void getKNN() {
        //read file
        int column = 0; 
        int row  = 0;

        String[][]file=null;
        Scanner group11= new Scanner(System.in);

        System.out.println("Input the name of the file which has the training data for K-NN: ");
        String filename=group11.nextLine();
            try {
                Scanner csv= new Scanner(new FileInputStream(filename));
                while (csv.hasNextLine()){//calculate number of rows and columns in training data
                    String s1 = csv.nextLine();
                    String [] s1_spilt = s1.split(",");
                    column = s1_spilt.length;
                    row ++;
                }

                Scanner csv2= new Scanner(new FileInputStream(filename)); 
                file = new String [row][column];
                for (int i=0;i<row;i++){//write into a 2D array and print the 2D array for user reference
                    String s1 = csv2.nextLine();
                    String [] s1_split = s1.split(",");
                    for (int j = 0; j<column; j++){
                        file[i][j] = s1_split[j];
                        System.out.printf("%-30s", s1_split[j]);
                    }
                     System.out.println("");
                }
            }
            catch (FileNotFoundException e){
                System.out.println("File not found!!");
            }
        //process file
        Scanner sc=new Scanner(System.in);
        // point aray x to the first row of the file(column names)
        String[] x=file[0];
        boolean independantwrong=false;
        int independantcount=-1;
        int independantindex=-1;
        boolean dependantwrong=false;
        int dependantcount=-1;
        int dependantindex=-1;
        boolean samecolumnindex=false;
        do{//this do-while loop make sure the independant values and dependant values are not the same column
            samecolumnindex=false;
            independantwrong=false;
            independantcount=-1;
            independantindex=-1;
            dependantwrong=false;
            dependantcount=-1;
            dependantindex=-1;
            while(independantindex<0){//this loop can get which column is used as the independant data
                if(independantwrong==true){
                    System.out.println("Invalid input, please enter again.");}
                System.out.println("Enter the name of the column for the independant values of training data: ");
                String independantcolumn=sc.nextLine();
                int samenamecolumn=0;
                for(int i=0;i<x.length;i++){
                    if(independantcolumn.compareToIgnoreCase(x[i])==0&&samenamecolumn<2){
                        independantindex=i;
                        samenamecolumn++;
                    }
                    if(samenamecolumn>1){
                        while(independantcount<0){
                            System.out.println("There are same name columms, the name cannot be used to identify anymore, please enter the number of the column instead(column counted from the left, starting from 1): ");
                            independantcount=sc.nextInt();
                            independantindex=independantcount-1;}
                    }
                }
                if(independantindex<0)
                    independantwrong=true;
            }
            while(dependantindex<0){//this loop can get which column is used as the dependant data
                if(dependantwrong==true){
                    System.out.println("Invalid input, please enter again.");}
                System.out.println("Enter the name of the column for the dependant values of training data: ");
                String dependantcolumn=sc.nextLine();
                int samenamecolumn=0;
                for(int i=0;i<x.length;i++){
                    if(dependantcolumn.compareToIgnoreCase(x[i])==0&&samenamecolumn<2){
                        dependantindex=i;
                        samenamecolumn++;
                    }
                    if(samenamecolumn>1){
                        while(dependantcount<0){
                            System.out.println("There are same name columms, the name cannot be used to identify anymore, please enter the number of the column instead(column counted from the left, starting from 1): ");
                            dependantcount=sc.nextInt();
                            dependantindex=independantcount-1;}
                    }
                }
                if(dependantindex<0)
                    dependantwrong=true;
            }
            if(independantindex==dependantindex){
                System.out.println("Column for independant data and dependant data are the same, please re-enter.");
                samecolumnindex=true;}
            }
        while(samecolumnindex);   
        System.out.println("Please enter a value of the "+ file[0][independantindex]+ " that you want to use to predict the regression value of "+ file[0][dependantindex]+" or the class it belongs to: ");
        System.out.println("Note: It is encouraged that the value to be used for prediction should not be any value that is already inside the training data, as the training data already gave the answer, no prediction is required.");
        float testdata=group11.nextFloat();
        int action=0;
        while(action==0){
            System.out.println("Do you want to perform regression or classification? Enter any positive value for regression, any negative value for classification. Please make sure the training data complys with the action you want to perform: ");
            action=group11.nextInt();
            if(action==0)
                System.out.println("Invalid input, please enter again.");}
        float[][] result=null;// used to store frequency of each class for classification
        // array ab is to store independant values and dependant values, make a copy and name it as abcopy
        float [][] ab= new float[row-1][2];
        float [][] abcopy=new float[row-1][2];
        for(int i=1;i<row;i++){
                ab[i-1][0]=Float.parseFloat(file[i][independantindex]);
                ab[i-1][1]=Float.parseFloat(file[i][dependantindex]);
                abcopy[i-1][0]=Float.parseFloat(file[i][independantindex]);  
                abcopy[i-1][1]=Float.parseFloat(file[i][dependantindex]);  
        }
        if(action<0){
            float[][] duplicate=new float[file.length-1][2];//frequency counter to find classes available in the sample data
            for(int i=1;i<file.length;i++){
                duplicate[i-1][0]=Float.parseFloat(file[i][dependantindex]);
                duplicate[i-1][1]=0;
                    }
            for(int i=0;i<file.length-1;i++){//when a same value is found for the second time, the frequency column beside it become 1. 3rd time found, frequency become 2 and so on
                for(int j=i+1;j<duplicate.length;j++){
                    if(Float.parseFloat(file[i+1][dependantindex])==duplicate[j][0]){
                        duplicate[j][1]++;
                    }
                }
            }
            int unique=0;//using this way, we can determine all classes available by reading the names of the classes with frequency of 0
            for(int i=0;i<duplicate.length;i++){//get the number of unique class names for classification
                if(duplicate[i][1]==0){
                    unique++;
                    
                }
            }
            result= new float[unique][2];
            int count=0;
            for(int i=0;i<duplicate.length;i++){
                if(duplicate[i][1]==0){//add each class into the [count][0] column of result array which is used to calculate frequency of each class in nearest k values
                        result[count][0]=duplicate[i][0];
                        result[count][1]=0;
                        count++; 
                }
            }  
        }
        float[]indepforcal=new float[row-1];// independant values for calculation
        for(int i=0;i<indepforcal.length;i++){
            indepforcal[i]=ab[i][0];}
        int k=CalK(row-1);
        System.out.println("From the total number of training data available, we recommend you to perform a "+k+"-Nearest Neighbor calculation, would you like to customize the value of k?");
        String yesorno=sc.next();
        boolean kinvalid=false;
        if(yesorno.compareToIgnoreCase("yes")==0){//let user to decide the value of k, loop until a reasonable k is given by the user
            do{
                System.out.println("Please enter your intended value of k: (Please make sure the value of k is reasonable)");
                k=sc.nextInt();
                kinvalid=false;
                if(k<=0){
                    kinvalid=true;
                    System.out.println("This value of k is invalid, please enter again: ");
                }   
            }
            while(kinvalid==true);
        }
        //calculate distance from sample data to each training data
        float[] distance=new float[indepforcal.length];
        for(int i=0;i<indepforcal.length;i++){
            distance[i]=CalDistance(testdata,indepforcal[i]);
            abcopy[i][0]=distance[i];
        }
        float [] temparray= new float[2];//temporary array for swapping
        //ascending sort the distance
        for (int i = 0; i < distance.length; i++){
            for (int j = 0; j < distance.length-1; j++) {
               if (distance[j]> distance[j+1]){
                    //swap between rows in indepanddeptCopy
                    temparray=abcopy[j];
                    abcopy[j]=abcopy[j+1];
                    abcopy[j+1]=temparray;
                    //swap between values of the column being used as sorting criteria that has been copied into 1D array distance 
                    float temp = distance[j]; 
                    distance[j] = distance[j+1]; 
                    distance[j+1] = temp; 
                        }
                    }
                }
        //regression
        float mean=0;
        float sum=0;
        if(action>0){
            for(int i=0;i<k;i++){
                sum+=abcopy[i][1];
            }
            mean=sum/k;
            System.out.println("Predicted regression value of "+file[0][dependantindex]+" based on "+k+" nearest neighbor for the given "+ file[0][independantindex]+" which is "+ testdata+" is: "+ mean);
        }     
        //classification
        if(action<0){
            for(int i=0;i<result.length;i++){
                for(int j=0;j<k;j++){
                    if(abcopy[j][1]==result[i][0]){
                        result[i][1]++;
                    }
                }
            }           
            //find the mode class
            float mode=result[0][1];
            float modeclass=result[0][0];
            for(int i=1;i<result.length;i++){
                if(result[i][1]>mode){
                    mode=result[i][1];
                    modeclass=result[i][0];
                }
            }
            System.out.println("Predicted classification of "+file[0][dependantindex]+" based on "+k+" nearest neighbor for the given "+ file[0][independantindex]+" which is "+ testdata+" is class: "+modeclass+" with the frequency of "+(int)mode);
        }
    }
    public static float CalDistance(float sample,float traindata){// method to calculate distance
        float distance= (float)(Math.sqrt(Math.pow((sample-traindata),2)));
        return distance;    
    }
    
    public static int CalK(int numofdata){//method to calculate recommended value of k based on number of sample data available
        int k=(int)(Math.round((Math.sqrt(numofdata*1.0))/2));
        if(k%2==0)//make sure k is odd number to avoid contradiction, even number of k nearest neighbor is not ideal
           return k-1;
        else
           return k;
    }
}
