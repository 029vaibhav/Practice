
import java.util.*;

public class Amazon {


    public static void main(String[] args) {



        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for (int i = 0; i < tc; i++) {

            System.out.println();
            int w = in.nextInt();
            String[] s = new String[w];
            for (int j = 0; j < w; j++) {
                s[j] = in.next();
            }
            int m = in.nextInt();
            int n = in.nextInt();
            int l = m * n;
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int k = 0; k < l; k++) {
                String next = in.next();
                Integer integer = hashMap.get(next);
                if (integer == null)
                    hashMap.put(next, 1);
                else {
                    hashMap.put(next, integer + 1);
                }
            }

            Set<String> strings = new HashSet<>();

            for (String s2 : s) {
                HashMap<String, Integer> hashMap2 = new HashMap<>(hashMap);
                char[] c = s2.toCharArray();
                boolean b = false;
                for (char c1 : c) {
                    Integer integer = hashMap2.get("" + c1);
                    if (integer == null || integer == 0) {
                        b = true;
                        break;
                    } else {
                        hashMap2.put("" + c1, integer - 1);
                    }
                }
                if (!b) strings.add(s2);


            }
            ArrayList<String> strings1 = new ArrayList<>(strings);
            Collections.sort(strings1);
            if (strings1.size() == 0) System.out.println("-1");
            else for (String s1 : strings1) System.out.print(s1 + " ");


        }
    }
}
