import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class hacker2 {


    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
//        String _s;
//        try {
//            _s = in.nextLine();
//        } catch (Exception e) {
//            _s = null;
//        }
        String s = "1226#";

        res = frequency(s);

    }


    static int[] frequency(String s) {

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            hashMap.put(alphabet[i], 0);
        }

        char[] chars = s.toCharArray();
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '#') {
                String pop = strings.pop();
                String pop1 = strings.pop();
                char c = alphabet[Integer.parseInt(pop1) * 10 + Integer.parseInt(pop)-1];
                Integer integer = hashMap.get(c);
                hashMap.put(c, integer + 1);
            } else {
                strings.push("" + aChar);
            }


        }

        while (!strings.empty()) {
            String pop = strings.pop();
            char c = alphabet[Integer.parseInt(pop)-1];
            Integer integer = hashMap.get(c);
            hashMap.put(c, integer + 1);
        }

        while (!strings.isEmpty()) {
            strings.pop();
        }

        int[] a = new int[26];
        for (int i = 0; i < a.length; i++) {

            Integer integer = hashMap.get(alphabet[i]);
            a[i] = integer;
        }

        return a;
    }


}
