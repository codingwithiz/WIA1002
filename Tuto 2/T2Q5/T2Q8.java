package T2Q5;
import java.util.ArrayList;

public class T2Q8 {
    public static void main(String[]args){
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();
        displayList(numOfCars);
        displayList(milesPerHour);
    }

    public static void displayList(ArrayList<?>list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
