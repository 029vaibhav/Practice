import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();

        boolean continuex = true;
//        while (continuex) {
////            char[] a = s.toCharArray();
//
            char[] chars = s.toCharArray();
            List<Character> a = new ArrayList<Character>();
            for (char c : chars) {
                a.add(c);
            }
//
//            String abc = reducedString(a).toString();
//            if (s.equals(abc)) {
//                continuex = false;
//            }
//            s = abc;
//
//
//        }
        System.out.println(reducedString(a).toString());


    }

    public static List<Character> reducedString(List<Character> a) {

        List<Character> characters = new ArrayList<>();
        int j = 0;
        if (a.size() <= 2) {
            return a;
        }
        int i;
        boolean continuex = false;
        for ( i = 0; i < a.size() - 2; i++) {
            if (a.get(i) == a.get(i+1) && a.get(i) == a.get(i+2)) {
                i = i + 2;
                continuex = true;
            } else {
                characters.add(a.get(i));
            }
        }

        for(; i<a.size(); ++i)
            characters.add(a.get(i));
        if(!continuex) return characters;
        return reducedString(characters);
    }


}