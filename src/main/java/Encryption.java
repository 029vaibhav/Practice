import java.nio.charset.StandardCharsets;

public class Encryption {

    static String key = "ZV3MLR/Rvi4BZo1bS0MxGClJLBNPmAW+xQZSlrNeFM/pqvCEM79ndlKO7Zi9q5hy84rfQm3sb";
    public static void main(String[] args) {


        RC4 rc4 = new RC4();
        rc4.setKey(key);
        long start = System.currentTimeMillis();
        System.out.println("intime " + start);
        byte[] bytes = rc4.encryptMessage(null, key);
        String s = new String(bytes, StandardCharsets.ISO_8859_1);
        System.out.println(bytes.length+" "+s);
        long end = System.currentTimeMillis();
        System.out.println("out " + (end - start));


        System.out.println("intime " + start);

        System.out.println("string "+s);
        System.out.println("bytes "+s.getBytes(StandardCharsets.ISO_8859_1));
         s = rc4.decryptMessage(s.getBytes(StandardCharsets.ISO_8859_1), key);
        System.out.println("decrpted "+s);
        end = System.currentTimeMillis();
        System.out.println("out " + (end - start));
    }




}
