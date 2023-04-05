import java.io.FileInputStream;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class L1Q2 {
    public static void main(String[] args) {
        String fileName = "";
        String pattern = "";
        for(int i = 1 ; i<=4 ; i++){
            System.out.println();
            fileName = String.format("C:\\Users\\ingzh\\OneDrive - Universiti Malaya\\y1s2\\WIA1002\\Week 1 WIA1002\\Tuto 1\\L1Q2\\src\\text%d.txt",i);
            switch(i){
                case 1 -> pattern = ",";
                case 2 -> pattern = ", ";
                case 3 -> pattern = "; ";
                case 4 -> pattern = "\\d+";
            }

            try{
                    Scanner sc = new Scanner(new FileInputStream(fileName));
                    String finalLine = "";
                    int charCount = 0;
                    while(sc.hasNextLine()){
                        String line = sc.nextLine();
                        if(i<=3){
                            String[] words = line.split(pattern);
                            finalLine = String.join("", words);
                        }
                        else{
                            finalLine = line.replaceAll(pattern , "");
                        }

                        charCount += finalLine.length();
                        System.out.println(finalLine);
                    }
                    System.out.println("Total number of characters: " + charCount);
                    sc.close();

    }catch(FileNotFoundException e){
        System.out.println("File not found");
    }
        }
    }
}