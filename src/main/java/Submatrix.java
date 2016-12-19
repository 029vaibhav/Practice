import java.util.*;

public class Submatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int totali = in.nextInt();

        for (int o = 0; o < totali; o++) {


            int row = in.nextInt();
            int col = in.nextInt();


            List<String> lists = new ArrayList<>();

            for (int i = 0; i < row; i++) {
                String s = "";
                s = in.next();
                lists.add(s);
            }

            int srow = in.nextInt();
            int scol = in.nextInt();


            String k = "";
            List<String> slists = new ArrayList<>();
            for (int i = 0; i < srow; i++) {
                String next = in.next();
                k += next;
                slists.add(next);

            }


            HashMap<String, MyClass> map = new HashMap<>();

//            List<Integer> integerList = new ArrayList<>();
//            List<Integer> startIndex = new ArrayList<>();
            for (int i = 0; i < lists.size(); i++) {

                String s = slists.get(0);
                String s1 = lists.get(i);
                if (s1.contains(s)) {

                    for (int j = 0; j < s1.length(); j++) {
                        int instanceID = s1.indexOf(s, j);
                        if (instanceID != -1) {
                            MyClass myClass = new MyClass(i, instanceID);
                            map.put(i + "" + instanceID, myClass);
                        }

                    }
                }
            }


            Iterator<Map.Entry<String, MyClass>> iterator = map.entrySet().iterator();
            List<String> match = new ArrayList<>();
            for (int i = 0; i < map.size(); i++) {

                Map.Entry<String, MyClass> next = iterator.next();
                Integer integer = next.getValue().getRow();
                String s = "";

                int instanceID = integer + srow;
                for (int j = integer; j < instanceID; j++) {
                    if (j < lists.size()) {
                        String s1 = lists.get(j);
                        Integer integer1 = next.getValue().getIndex();
                        String substring = s1.substring(integer1, scol + integer1);
                        s += substring;
                    }

                }
                match.add(s);
                if (s.equals(k)) break;


            }


            System.out.println(match.contains(k) ? "YES" : "NO");

        }
    }

    private static class MyClass {

        int row;
        int index;

        public MyClass(int row, int index) {
            this.row = row;
            this.index = index;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }


}

