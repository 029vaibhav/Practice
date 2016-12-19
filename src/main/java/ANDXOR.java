import java.util.Scanner;
import java.util.Stack;

public class ANDXOR {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Stack<Integer> stk = new Stack<>();
        // int result=0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty()) {
                max = Math.max(max, xor(arr[i], stk.peek()));
                if (arr[i] < stk.peek()) {
                    stk.pop();
                    //if(result)
                    // break;
                } else
                    break;
            }
            stk.push(arr[i]);
        }
        System.out.println(max);
    }


    private static int xor(int m1, int m2) {

        return ((m1 & m2) ^ (m1 | m2)) & (m1 ^ m2);
    }
}
