package ExtraFeature;

import static DataFrame.SaveDataframeToCsvFile.ReadCsv;
import static DataFrame.SaveDataframeToCsvFile.filepath;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;

public class JsonFileConvertor {
    public static void PrintJsonFile(){
        
        Scanner group11 = new Scanner(System.in);
        int column = 0; 
        int row  = 0;
        String[][]file=null;
        
        ReadCsv();
        try {
            Scanner csv= new Scanner(new FileInputStream(filepath));
            
            while (csv.hasNextLine()){
                String s1 = csv.nextLine();
                String [] s1_spilt = s1.split(",");
                column = s1_spilt.length;
                row ++;
            }
            
            Scanner csv2= new Scanner(new FileInputStream(filepath)); 
            file = new String [row][column];
            for (int i=0;i<row;i++){
                String s1 = csv2.nextLine();
                String [] s1_split = s1.split(",");
                for (int j = 0; j<column; j++){
                    file[i][j] = s1_split[j];
                    System.out.printf("%-30s", s1_split[j]);
                }
                 System.out.println("");
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!!");
        }
            JSONArray jsonArray = new JSONArray();
            for (String[] w : file) {
                JSONArray arr = new JSONArray();
                for (String v : w) {
                 arr.add(v); // or some other conversion
                }
                jsonArray.add(arr);
            }
            try (FileWriter jsonout = new FileWriter("file.json")) {
 
            jsonout.write(jsonArray.toJSONString());
            jsonout.flush();
 
            } catch (IOException e) {
                 e.printStackTrace();
            }
            System.out.println("");
            System.out.println("(file).json is generating....");
            
            try{
               Thread.sleep(2000);
            }catch(Exception e) {
                System.out.println(e);
            }
            
            System.out.println("(file).json done. Please check ur files for more information.");
    }
}
