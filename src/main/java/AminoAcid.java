import java.util.Scanner;

public class AminoAcid {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();


        for (int i = 0; i < n; i++) {

            String input  = s.next();
            int exp = s.nextInt();

            for (int j = 0; j < exp; j++) {

               String sub =  s.next();
                char[] chars = sub.toCharArray();
                for(Character character:chars)
                {
                    input.indexOf(character);
                }



            }



        }

    }
}
