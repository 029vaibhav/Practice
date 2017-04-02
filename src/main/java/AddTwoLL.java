public class AddTwoLL {

    public static void main(String[] args) {

        Node ll1 = new Node(3,new Node(1,new Node(5,null)));
        Node ll5 = new Node(5,new Node(9,new Node(2,null)));

        Node node = addList(ll1, ll5, 0);
        System.out.println(node.toString());


    }

    private static Node addList(Node ll1, Node ll2, int carry) {

        int value = 0;
        if (ll1 == null && ll2 == null) {
            return null;
        }
        if (ll1 != null) {
            value += ll1.data;
        }

        if (ll2 != null) {
            value = value + ll2.data;
        }

        Node result = new Node();
        result.data = (value+carry) % 10;

        Node s = addList(ll1.next, ll2.next, value >= 10 ? 1 : 0);
        result.next = s;
        return result;

    }

    static class Node {

        int data;
        Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
