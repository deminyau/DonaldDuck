package Manipulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveDuplicatedRowInData extends ConnectorPart2 {
    
    public static void DeleteDuplicatedRow() {
        Scanner c = new Scanner(System.in);
        int z = 0;
        String[] specialName = new String[5];


        try {
            Scanner uni = new Scanner(new FileInputStream("DataStorage.csv"));

            while (uni.hasNextLine()) {

                String uniRow = uni.nextLine();
                String[] uniColumns = uniRow.trim().split(",");
                String name = uniColumns[0];
                specialName[z] = name;
                z++;
                String department = uniColumns[1];
                String CurrentCGPA = uniColumns[2];
                String Expected_graduation_salary = uniColumns[3];
                String Actual_graduation_salary = uniColumns[4];

                System.out.printf("%s\t%-23s\t%-10s\t%-30s\t%-20s\n", name, department, CurrentCGPA, Expected_graduation_salary, Actual_graduation_salary);
            }
            uni.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }


        for (int i = 0; i < z - 1; i++) {
            for (int j = i + 1; j < z; j++) {
                if (specialName[i].equals(specialName[j])) {

                    System.out.println("Line " + (i + 1) + " and Line " + (j + 1) + " have the same name (duplication)!");
                    System.out.println("Choose Line to be kept (e.g. 1) or input -1 to remove all lines: ");
                    int keeper = c.nextInt();
                    System.out.println("Choice recorded...");


                    if (keeper == (i + 1)) {
                        try {
                            Scanner uni = new Scanner(new FileInputStream("DataStorage.csv"));
                            int b = 0;

                            while (uni.hasNextLine()) {


                                String uniRow = uni.nextLine();
                                String[] uniColumns = uniRow.trim().split(",");
                                if (b != j) {
                                    String name = uniColumns[0];
                                    String department = uniColumns[1];
                                    String CurrentCGPA = uniColumns[2];
                                    String Expected_graduation_salary = uniColumns[3];
                                    String Actual_graduation_salary = uniColumns[4];


                                    System.out.printf("%s\t%-23s\t%-10s\t%-30s\t%-20s\n", name, department, CurrentCGPA, Expected_graduation_salary, Actual_graduation_salary);
                                }
                                b++;
                            }
                            uni.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found!!");
                        }
                    } else if (keeper == (j + 1)) {
                        try {
                            Scanner uni = new Scanner(new FileInputStream("DataStorage.csv"));
                            int b = 0;

                            while (uni.hasNextLine()) {


                                String uniRow = uni.nextLine();
                                String[] uniColumns = uniRow.trim().split(",");
                                if (b != i) {
                                    String name = uniColumns[0];
                                    String department = uniColumns[1];
                                    String CurrentCGPA = uniColumns[2];
                                    String Expected_graduation_salary = uniColumns[3];
                                    String Actual_graduation_salary = uniColumns[4];


                                    System.out.printf("%s\t%-23s\t%-10s\t%-30s\t%-20s\n", name, department, CurrentCGPA, Expected_graduation_salary, Actual_graduation_salary);
                                }
                                b++;
                            }
                            uni.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found!!");
                        }
                    } else if (keeper == -1) {
                        try {
                            Scanner uni = new Scanner(new FileInputStream("DataStorage.csv"));
                            int b = 0;

                            while (uni.hasNextLine()) {


                                String uniRow = uni.nextLine();
                                String[] uniColumns = uniRow.trim().split(",");
                                if (b != i && b != j) {
                                    String name = uniColumns[0];
                                    String department = uniColumns[1];
                                    String CurrentCGPA = uniColumns[2];
                                    String Expected_graduation_salary = uniColumns[3];
                                    String Actual_graduation_salary = uniColumns[4];


                                    System.out.printf("%s\t%-23s\t%-10s\t%-30s\t%-20s\n", name, department, CurrentCGPA, Expected_graduation_salary, Actual_graduation_salary);
                                }
                                b++;
                            }
                            uni.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found!!");
                        }
                    }
                }
            }
        }
    } 
}
