import java.math.BigInteger;
import java.util.*;

public class ClearTrip {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        final BigInteger[] count = {BigInteger.ZERO};
        HashMap<Integer, Integer> hash = new HashMap<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int instanceID = sc.nextInt();
            if (hash.get(instanceID) != null) {
                Integer integer = hash.get(instanceID);
                hash.put(instanceID, integer + 1);
            } else {
                hash.put(instanceID, 1);
            }
        }
        hash.forEach((integer, integer2) -> {
            integerList.add(integer);
        });

        Collections.sort(integerList);

        for (int i = 0; i < integerList.size(); i++) {

            if (hash.get(integerList.get(i)) > 1) {
                if ((integerList.get(i) + integerList.get(i)) % K == x && (integerList.get(i) * integerList.get(i)) % K == y) {
                    int min = hash.get(integerList.get(i));
                    int instanceID = min * (min - 1) / 2;
                    count[0] = count[0].add(new BigInteger("" + instanceID));
                }
            }
            for (int j = i + 1; j < integerList.size(); j++) {

                if ((integerList.get(i) + integerList.get(j)) % K == x && (integerList.get(i) * integerList.get(j)) % K == y) {
                    int min = Math.multiplyExact(hash.get(integerList.get(i)), hash.get(integerList.get(j)));
                    count[0] = count[0].add(new BigInteger("" + min));
                }
            }

        }


        System.out.print(count[0].toString());

    }
}
