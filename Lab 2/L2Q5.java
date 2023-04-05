package Lab_2;
import java.util.*;

public class L2Q5 {
    public static void main(String[] args) {
        FindMax.main(args);
    }
}

class FindMax {
    static class Circle implements Comparable<Circle> {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public int compareTo(Circle that) {
            return Double.compare(radius, that.radius);
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "radius=" + radius +
                    '}';
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3};
        String[] strArray = {"red","green","blue"};
        Circle[] circleArray = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println(max(intArray));
        System.out.println(max(strArray));
        System.out.println(max(circleArray));
    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (E e : list) {
            if (e.compareTo(max) > 0)
                max = e;
        }
        return max;
    }

}

