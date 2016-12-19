import java.util.*;

public class MatrixRotation {
    static int[][] a;

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        int rotation = in.nextInt();

        a = new int[row][column];
        List<Stack<MyClass>> stacks = new ArrayList<>();


        for (int i = 0; i < row; i++) {

            Stack<MyClass> integers = new Stack<>();
            for (int j = 0; j < column; j++) {
                int instanceID = in.nextInt();
                MyClass myClass = new MyClass(i, j, instanceID);
                integers.push(myClass);
            }
            stacks.add(integers);
        }
        List<List<MyClass>> lists = strip2(stacks);

        List<List<MyClass>> lists2 = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {

            List<MyClass> integerList = lists.get(i);

            List<MyClass> integerList1 = new ArrayList<>(integerList);
            for (int j = 0; j < integerList.size(); j++) {
                int instanceID = j - rotation;
                if (instanceID < 0) {
                    int size = integerList.size();
                    instanceID = (instanceID % size + size) % size;

                }
                MyClass myClass = integerList.get(j);
                MyClass myClass1 = integerList.get(instanceID);
                integerList1.set(instanceID, new MyClass(myClass1.r, myClass1.c, myClass.i));
            }
            lists2.add(integerList1);
        }


        int[][] b = new int[row][column];

        for (int i = 0; i < lists2.size(); i++) {

            List<MyClass> integerList = lists2.get(i);
            for (int j = 0; j < integerList.size(); j++) {

                MyClass myClass = integerList.get(j);
                b[myClass.r][myClass.c] = myClass.i;

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                System.out.print(b[i][j] + " ");
            }
            System.out.println("");
        }


    }

    private static List<List<MyClass>> strip2(List<Stack<MyClass>> stacks) {


        List<List<MyClass>> lists1 = new ArrayList<>();


        while (stacks.size() != 0) {

            List<MyClass> lists = new ArrayList<>();
            Stack<MyClass> integerList = stacks.get(0);

            while (!integerList.empty()) {
                lists.add(integerList.remove(0));
            }
            stacks.remove(0);

            for (int i = 0; i < stacks.size(); i++) {

                Stack<MyClass> integers = stacks.get(i);
                if (!integers.isEmpty()) {
                    MyClass remove = integers.pop();
                    lists.add(remove);
                }


            }

            if (stacks.size() > 0) {
                integerList = stacks.get(stacks.size() - 1);
                while (!integerList.empty()) {

                    lists.add(integerList.pop());

                }
                stacks.remove(stacks.size() - 1);
            }

            for (int i = stacks.size() - 1; i >= 0; i--) {

                Stack<MyClass> integers = stacks.get(i);
                if (!integers.isEmpty()) {
                    MyClass remove = integers.remove(0);
                    lists.add(remove);
                }

            }


            if (lists.size() > 0)
                lists1.add(lists);

        }
        return lists1;
    }

    public static class MyClass {

        int r, c, i;

        public MyClass(int r, int c, int i) {
            this.r = r;
            this.c = c;
            this.i = i;
        }
    }


}
