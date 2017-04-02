import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuadrapleSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        for (int f = 0; f < t; f++) {

            int n = in.nextInt();
            int k = in.nextInt();

            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }

            List<SumPair> sumPairs = new ArrayList<>();
            for (int i = 0; i < x.length; i++) {

                int a = x[i];
                for (int j = i + 1; j < x.length; j++) {
                    int b = x[j];
                    SumPair sumPair = new SumPair();
                    sumPair.sum = a + b;
                    sumPair.first = i;
                    sumPair.second = j;
                    sumPairs.add(sumPair);

                }
            }
            Collections.sort(sumPairs, (o1, o2) -> o1.sum - o2.sum);

            int i = 0;
            int j = (n * (n - 1) / 2) - 1;
            String m = "-1";
            while (i < sumPairs.size() && j >= 0) {

                SumPair is = sumPairs.get(i);
                SumPair js = sumPairs.get(j);
                if (is.sum + js.sum == k && noCommon(is, js)) {
                    m = "";
                    System.out.print(x[is.first] + " " + x[is.second] + " " + x[js.first] + " " + x[js.second] + "$");
                    i++;
                    j--;
                } else if (is.sum + js.sum > k) {
                    j--;
                } else i++;
            }
            System.out.println(m);

        }


    }

    static boolean noCommon(SumPair a, SumPair b) {
        return !(a.first == b.first || a.second == b.second || a.first == b.second || a.second == b.first);
    }

    public static class SumPair {
        int sum, first, second;
    }
}
