import java.util.Scanner;

import static java.lang.Math.abs;

public class Test {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            String time = in.next();
            String[] s = time.split(":");
            double h = Double.parseDouble(s[0]);
            double min = Double.parseDouble(s[1]);

            if (h > 12 || h < 1) {
                System.out.print("Error");
                return;
            }

            if (min > 59 || min < 0) {
                System.out.print("Error");
                return;
            }

            if ((h != Math.floor(h)) && Double.isInfinite(h)) {
                System.out.print("Error");
                return;
            }

            if ((min != Math.floor(min)) && Double.isInfinite(min)) {
                System.out.print("Error");
                return;
            }

            if (h == 12) h = 0;

            double angle = abs((30 * h - 5.5 * min));

            if ((angle == Math.floor(angle)) && !Double.isInfinite(angle)) {
                System.out.println("" + (int) angle);
                return;
            }
            System.out.println("" + angle);
        } catch (Exception e) {
            System.out.print("Error");
        }

    }

    public static void main(int[] args) {
        System.out.println("hello");
    }

    void display(Object o) {
        System.out.println("object");
    }

    void display(String s) {
        System.out.println("String");
    }
}
