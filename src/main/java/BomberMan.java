import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BomberMan {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        int seconds = in.nextInt();

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            strings.add(in.next());

        }

        int m = 1;
        for (int i = 1; i <= seconds; i++) {

            for (int j = 0; j < strings.size(); j++) {
                String s = strings.get(j);
                if (i % 2 == 0) {
                    strings.set(j, s.replace(".", "O"));
                }
                if (i % 3 == 0) {
                    while (s.contains("2")) {
                        int instanceID = s.indexOf("2");
                        StringBuilder myName = new StringBuilder(s);
                        myName.setCharAt(instanceID, '.');
                        if (s.length() - 1 > instanceID && myName.charAt(instanceID + 1) != '2')
                            myName.setCharAt(instanceID + 1, '.');
                        if (instanceID > 0 && myName.charAt(instanceID - 1) != '2')
                            myName.setCharAt(instanceID - 1, '.');
                        s = String.valueOf(myName);
                        strings.set(j, s);
                        if (j - 1 >= 0) {
                            String s1 = strings.get(j - 1);
                            myName = new StringBuilder(s1);
                            if (myName.charAt(instanceID) != '2') {
                                myName.setCharAt(instanceID, '.');
                                s1 = String.valueOf(myName);
                                strings.set(j - 1, s1);

                            }

                        }
                        if (j + 1 < strings.size()) {
                            String s1 = strings.get(j + 1);
                            myName = new StringBuilder(s1);
                            if (myName.charAt(instanceID) != '2') {
                                myName.setCharAt(instanceID, '.');
                                s1 = String.valueOf(myName);
                                strings.set(j + 1, s1);
                            }
                        }
                    }
                }
                if (m == 1) {
                    strings.set(j, s.replace("O", "2"));
                }
            }
            m++;
            if (m == 4) {
                m = 1;
            }


        }

        for (String s : strings) {
            String o = s.replace("2", "O");
            System.out.println(o);
        }

    }
}
