import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxDistance {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Node node = new Node();
        node.data = "root";
        for (int i = 0; i < (n - 1); i++) {


            String d1 = s.next();
            String d2 = s.next();
            if (d1.equals("root")) {

                Node node1 = new Node();
                node1.data = "/" + d2;
                node.nodes.add(node1);


            } else {
                List<Node> search = search(d1, node.nodes);
                Node node1 = new Node();
                for (int i1 = 0; i1 < search.size(); i1++) {
                    Node node11 = search.get(i1);
                    String[] split = node11.data.split("/");
                    String s1 = split[split.length - 1];
                    if (s1.equals(d1)) {
                        node1.data = node11.data + "/" + d2;
                        search.add(node1);
                    }
                }


            }


        }

        n = s.nextInt();


        for (int i = 0; i < n; i++) {

            boolean found = false;
            String next = s.next();
            if (next.equals("root")) System.out.println("/");
            else {
                for (Node node1 : node.nodes) {
                    if (node1.data.contains(next)) {
                        System.out.println(node1.data);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("No such file or directory!");

            }
        }


    }


    private static List<Node> search(String data, List<Node> node) {
        if (node != null && node.size() > 0) {
            for (int i = 0; i < node.size(); i++) {
                if (node.get(i).data.contains(data)) {
                    return node;
                }
            }
        } else {
            return null;
        }
        return null;
    }


    public static class Node {

        List<Node> nodes = new ArrayList<>();
        String data;

        public Node() {
        }

        public Node(Node right, String data) {
            nodes.add(right);
            this.data = data;
        }
    }

    // Function to find maximum distance between equal elements
}
