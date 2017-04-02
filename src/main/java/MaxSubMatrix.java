import java.util.Scanner;

public class MaxSubMatrix {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();


        int[][] maxtrix = new int[m][n];
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                maxtrix[i][j] = in.nextInt();
            }
        }


        int ulmitate = 0;

        int x = 0;
        int y = 0;
        int i = 0;
        int j = 0;
        while (x  <= m && y <= n) {
            int max = 0;
            for (i = x; i < x + a; i++) {
                for (j = y; j < y + b; j++) {
                    if (i < m && j < n)
                        max += maxtrix[i][j];
                }
            }
            if (y + b > n) {
                x++;
                y = 0;
            }
            else {
                y++;
            }
            if (max > ulmitate)
                ulmitate = max;

        }
        System.out.println(ulmitate);


    }


}
