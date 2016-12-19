import java.util.Scanner;

public class HackerRank {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int _arr_rows = 0;
        int _arr_cols = 0;
        _arr_rows = in.nextInt();
        _arr_cols = in.nextInt();

        int[][] _arr = new int[_arr_rows][_arr_cols];
        for (int _arr_i = 0; _arr_i < _arr_rows; _arr_i++) {
            for (int _arr_j = 0; _arr_j < _arr_cols; _arr_j++) {
                _arr[_arr_i][_arr_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        countNumbers(_arr);

    }

    static void countNumbers(int[][] arr) {


        for (int i = 0; i < arr.length; i++) {

            int instanceID = arr[i][0];
            int instanceID2 = arr[i][1];

            int count = 0;
            int instanceID3 = instanceID2 - instanceID+1;
            for (int j = 0; j < instanceID3; j++) {

                int instanceID1 = instanceID + j;
                if (instanceID1 % 11 != 0) {
                    count++;
                }

            }
            System.out.println("" + count);
        }

    }


}
