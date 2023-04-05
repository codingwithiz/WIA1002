//Author: Lee Ing Zhen
import java.util.*;
import java.io.*;
public class L1Q1 {
    public static void main(String[] args) {
        try{
            //Part 1
            Scanner sc = new Scanner(new FileInputStream("LeeIngZhen_22055760.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();

            //Part 2
            sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(new FileOutputStream("LeeIngZhen_22055760.txt" , true));
            pw.println();
            String line;
            while(!(line = sc.nextLine()).equals("end")){
                pw.println(line);
            }
            pw.close();

            sc = new Scanner(new FileInputStream("LeeIngZhen_22055760.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();

            //Part 3


        }catch(FileNotFoundException e){
            System.out.println("Error opening the file LeeIngZhen_22055760.txt");
            System.exit(0);
        }
    }
}