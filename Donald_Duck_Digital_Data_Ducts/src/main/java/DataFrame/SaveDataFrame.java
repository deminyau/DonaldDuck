package DataFrame;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SaveDataFrame extends ConstructDataFrame {
    
    private static String name;
    private static String department;
    private static String CGPA;
    private static String Exp_Salary;
    private static String Act_Salary;
    
    public SaveDataFrame(String n,String d,String c,String e,String a){
        name=n;
        department=d;
        CGPA=c;
        Exp_Salary=e;
        Act_Salary=a;
        
    }
    
    public static void saveRecord() throws FileNotFoundException{
        FileOutputStream fos = new FileOutputStream("output.csv",true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println(name +"," +department +"," +CGPA +"," +Exp_Salary +"," +Act_Salary);
        pw.close();
    }
}
