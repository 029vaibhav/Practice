import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(System.in);

        String c = in.next();
        String d = in.next();


        String[] s1 = c.split(",");

        List<Category> cats = new ArrayList<>();
        List<Deal> deals = new ArrayList<>();

        for (String s2 : s1) {
            Category category = new Category();
            String[] rs = s2.split("R");
            category.category = rs[0];
            category.rank = Integer.parseInt(rs[1]);
            cats.add(category);

        }
        s1 = d.split(",");

        for (String s2 : s1) {
            Deal deal = new Deal();

            String[] ds = s2.split("D");

            char[] chars = ds[0].toCharArray();
            int index = giveIndex(chars, 0);
            String substring = s2.substring(0, index);
            s2 = s2.substring(index, s2.length());
            deal.deal = "D" + substring;


        }

        Collections.sort(deals, new Comparator<Deal>() {
            @Override
            public int compare(Deal o1, Deal o2) {
                return o1.rank - o2.rank;
            }
        });


    }

    private static int giveIndex(char[] chars, int prev) {

        char ch = chars[prev];
        int index = 0;
        while (ch != 'C' || ch != 'R') {
            ch = chars[index++];
        }
        return index;

    }

    private void split(String s, String sp) {

        String[] split = s.split(sp);
        if (split.length == 1) {
            // no split;
        }
    }

    static class Category {
        String category;
        int rank;

    }

    static class Deal {

        String deal;
        List<String> category;
        int rank;

    }
}
