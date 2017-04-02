import java.util.*;

public class OrderPairs {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 2, 1 };
        int k = 2;
        int x = 1;
        int y = 0;
        System.out.println(solve(arr, k, x, y));
    }

    public static int solve(int[] arr, int k, int x, int y) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            Integer key = new Integer(arr[i]);
            if (map.get(key) != null) {
                List<Integer> list = map.get(key);
                list.add(new Integer(i));
                map.put(key, list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(new Integer(i));
                map.put(key, list);
            }
        }
        Set<Integer> keys = map.keySet();
        List<Set<Integer>> pairs = findPairs(keys, k, x, y);
        int pairsSize = 0;
        for (Set<Integer> set : pairs) {
            Iterator<Integer> it = set.iterator();
            if (it.hasNext()) {
                Integer integerA = it.next();
                if (it.hasNext()) {
                    Integer integerB = it.next();
                    List<Integer> listA = map.get(integerA);
                    List<Integer> listB = map.get(integerB);
                    pairsSize += listA.size() * listB.size();
                }
            }
        }
        return pairsSize;

    }

    public static List<Set<Integer>> findPairs(Set<Integer> keys, int k, int x,
                                               int y) {
        List<Set<Integer>> pairs = new ArrayList<Set<Integer>>();
        Iterator<Integer> it = keys.iterator();
        Set<Integer> markout = new HashSet<Integer>();
        while (it.hasNext()) {
            Integer i = it.next();
            markout.add(i);
            findPairsI(i, keys, markout, k, x, y, pairs);
        }
        return pairs;
    }

    public static void findPairsI(Integer i, Set<Integer> keys,
                                  Set<Integer> markout, int k, int x, int y, List<Set<Integer>> pairs) {
        for (Integer n : keys) {
            if (markout.contains(n)) {
                continue;
            }
            if ((n + i) % k == x && (i * n) % k == y) {
                Set<Integer> pair = new HashSet<Integer>();
                pair.add(n);
                pair.add(i);
                pairs.add(pair);
            }
        }
    }
}