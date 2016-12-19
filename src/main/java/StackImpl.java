import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackImpl {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            integers.add(in.nextInt());
        }

        long rect = 0;
        for (int i = 0; i < count; i++) {
            int finalI = i;
            Integer integer = integers.get(finalI);

            int count1 = 0;
            for (int i1 = finalI; i1 < integers.size(); i1++) {
                if (integer <= integers.get(i1)) {
                    count1++;
                } else break;
            }

            for (int i1 = finalI-1; i1 >= 0; i1--) {
                if (integer <= integers.get(i1)) {
                    count1++;
                } else break;
            }

            long l = integer * (count1);
            if (l > rect) {
                rect = l;
            }
        }
        System.out.println("" + rect);


    }

    private static class Stack {

        List<Integer> value = new ArrayList<>();
        //        List<Integer> maxNo = new ArrayList<>();
        int currentMax = 0;


        void push(int a) {
//            if (value.size() == 0 || maxNo.size() == 0) {
//                maxNo.add(a);
//            } else {
//
//                if (maxNo.size() > 0) {
//                    int max = this.maxNo.stream().max(Integer::compareTo).get();
//                    if (a >= max) {
//                        this.maxNo.add(a);
//                        currentMax =
//
//                    }
//                }
//            }
            if (a > currentMax) {
                currentMax = a;
            }
            value.add(a);

        }

        void pop() {

            if (value.size() > 0) {
                value.remove(value.size() - 1);
                if (value.size() > 0)
                    currentMax = this.value.stream().max(Integer::compareTo).get();
                else currentMax = 0;


            }
        }

        int max() {
            return currentMax;
        }

    }

}
