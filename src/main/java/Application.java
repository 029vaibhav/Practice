import java.util.*;

public class Application {


    public static String addToList(Node node, int count) {


        String character = null;
        Iterator<Map.Entry<Character, Node>> iterator = node.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry<Character, Node> next = iterator.next();
//            if (next.getValue().size() == count) {
            character = character(next.getValue(), "" + next.getKey());
            character = next.getKey() + "" + character;
//            } else

            if (next.getValue().size() > 0) {
                character = addToList(next.getValue(), count);
            }

        }

        return character;
    }

    public static String character(Node node2, String s) {

        Iterator<Map.Entry<Character, Node>> iterator2 = node2.entrySet().iterator();

        if (iterator2.hasNext()) {
            Map.Entry<Character, Node> next2 = iterator2.next();
            s = s + next2.getKey();
            if (next2.getValue().getSize() > 0) {
                character(next2.getValue(), s);
            }
        }
        return s;
    }

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int noOfStrings = input.nextInt();

        String[] inputStrings = new String[noOfStrings];

//        Set<String> stringSet = new TreeSet<>();
        System.out.println(System.currentTimeMillis());

        SuffixTree suffixTree = new SuffixTree();
        for (int i = 0; i < noOfStrings; i++) {
            String s = inputStrings[i] = input.next();
            suffixTree.createSuffixTree(s);
        }
        System.out.println(System.currentTimeMillis());


        List<String> strings = new ArrayList<>();
        strings.add(addToList(suffixTree.root, 0));

        int noOfResults = input.nextInt();

        for (int i = 0; i < noOfResults; i++) {

            int count = 0;
            int i1 = input.nextInt();
            if (getSize(suffixTree.root, 0) >= i1 - 1) {

                String s = addToList(suffixTree.root, i1 - 1);
                if (s == null)
                    System.out.println("INVALID");
                else {
                    System.out.println(s);
                }
            } else {
                System.out.println("INVALID");
            }

        }


    }

    public static int getSize(Node node, int count) {

        Iterator<Map.Entry<Character, Node>> iterator = node.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character, Node> next = iterator.next();
            count = count + node.getSize();
            count = getSize(next.getValue(), count);
        }
        return count;

    }

    private static class Node extends HashMap<Character, Node> {

        int size = 0;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        /**
         * Follows a link to get a child node.  If no such link
         * exists, then create and attach an empty child node.
         */
        Node getOrPut(char c) {
            Node child = this.get(c);

            if (child == null) {
                this.put(c, child = new Node());
            }
            child.setSize(child.getSize());
            return child;
        }


    }

    public static class SuffixTree {

        private Node root;


        public SuffixTree() {
            this.root = new Node();
        }

        /**
         * Creates the suffix tree from the given string.
         */
        public void createSuffixTree(CharSequence source) {

            for (int i = 0; i < source.length(); i++) {
                Node n = this.root.getOrPut(source.charAt(i));
                for (int j = i + 1; j < source.length(); j++) {
                    n = n.getOrPut(source.charAt(j));
                }
            }
        }


        public boolean contains(CharSequence target) {
            Node n = this.root;
            for (int i = 0; i < target.length(); i++) {
                n = n.get(target.charAt(i));
                if (n == null) {
                    return false;
                }
            }
            return true;
        }

        public void getNode(int i) {
            Iterator<Map.Entry<Character, Node>> iterator = root.entrySet().iterator();
            int count = 0;
            while (iterator.hasNext() && count == i) {

                Map.Entry<Character, Node> next = iterator.next();
            }
        }

        public Node getNode(CharSequence target) {
            Node n = this.root;
            for (int i = 0; i < target.length(); i++) {
                n = n.get(target.charAt(i));
                if (n == null) {
                    return null;
                }
            }
            return n;
        }


    }
}

