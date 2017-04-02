import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentArrangement {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int noOfStud = in.nextInt();
        int rows = in.nextInt();
        int columns = in.nextInt();

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < noOfStud; i++) {
            integerList.add(in.nextInt());
        }

        int count = 0;
        int matrix[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = -1;
            }
        }

        for (Integer integer : integerList) {

            integer = integer - 1;
            boolean sitted = false;
            for (int j = 0; j < columns; j++) {
                if (matrix[integer][j] == -1) {
                    matrix[integer][j] = 0;
                    sitted = true;
                    break;
                }
            }
            if (!sitted) {
                count++;

                do {

                    if (integer + 1 == rows) {
                        integer = 0;
                    }

                    label:
                    for (int j = integer; j < rows; j++) {
                        for (int k = 0; k < columns; k++) {
                            if (matrix[j][k] == -1) {
                                matrix[j][k] = 0;
                                sitted = true;
                                break label;
                            }
                        }
                    }
                } while (sitted);

            }
        }

        int instanceID = noOfStud - (rows * columns);
        if (instanceID > 0) {
            count = count + instanceID;
        }

        System.out.println("" + count);


    }

}
