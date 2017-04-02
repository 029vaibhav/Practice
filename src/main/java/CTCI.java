public class CTCI {

    public static void main(String[] args) {

        String s = "ABCD";

        char[] chars = s.toCharArray();

        for (int i = 0; i <chars.length/2 ; i++) {

           char te=  chars[i] ;
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i]= te;

        }


        System.out.println(chars);

    }
}
