import java.util.ArrayList;
import java.util.List;

public class LL {

    static int[] data = {2, 1, 4, 3};
    static int[] pos = {0, 1, 2, 3, 1};
    static Node x = new Node();
    static Node temp = x;

    public static void main(String[] ar) {

        Node node = null;
        for (int i = 0; i < data.length; i++) {
            node = SortedInsert(node, data[i]);
        }

        reverseRecursive(node);
         deleteNode(node.next);

        Reverse(node);
    }

    private static void deleteNode(Node Node_ptr) {

        Node_ptr.data = Node_ptr.next.data;
        Node_ptr.next = Node_ptr.next.next;


    }

    static Node Delete(Node head, int position) {
        // Complete this method

        if (head == null)
            return null;

        Node temp = head;
        if (position == 0) {
            head = temp.next;
            return head;

        }

        int count = 0;

        while (count < position - 1) {

            temp = temp.next;
            count++;

        }

        temp = temp.next.next;
        head.next = temp;
        return head;


    }

    static void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        List<Integer> l = new ArrayList<>();
        while (head != null) {

            l.add(head.data);
            head = head.next;
        }

        for (int i = l.size() - 1; i >= 0; i--) {
            System.out.println("" + l.get(i));
        }


    }

    static Node reverseRecursive(Node head)
    {
        if(head==null)return head;

        reverseRecursive(head.next);
        if (head!=null){
        temp.data =head.data;
        temp.next = new Node();
        temp = temp.next;}
        return temp;

    }

    static Node Reverse(Node head) {

        Node newNode = head;
        Node prev = null, next;

        while (newNode != null) {
            next = newNode.next;
            newNode.next = prev;
            prev = newNode;
            newNode = next;
        }
        return head;

    }

    static Node ReverseDobuly(Node head) {

        Node temp = head;
        Node newHead = head;

        while (temp != null) {

            Node x = temp.next;
            temp.next = temp.prev;
            temp.prev = x;
            newHead = temp;

            temp = temp.prev;

        }

        return newHead;


    }


    static Node SortedInsert(Node head, int data) {

        Node n = new Node();
        n.data = data;

        if (head == null) return n;

        Node temp = head;

        while (temp != null) {

            if (temp.next == null && temp.prev == null) {

                if (temp.data < data) {
                    temp.next = n;
                    n.prev = temp;
                } else {
                    temp.prev = n;
                    n.next = temp;
                    head = n;
                }

                break;
            }
            if (temp.next == null) {
                temp.next = n;
                n.prev = temp;
                break;
            }

            if (temp.data < data && temp.next.data > data) {
                temp.next.prev = n;
                n.next = temp.next;
                temp.next = n;
                n.prev = temp;
                break;
            }

            temp = temp.next;


        }
        return head;


    }


    static Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        Node n = new Node();
        n.data = data;
        int count = 0;
        if (head == null) {
            return n;
        }

        Node temp = head;


        if (position == 0) {
            n.next = head;
            return n;
        }

        while (count < position - 1) {

            temp = temp.next;
            count++;
        }

        Node tempNode;
        tempNode = temp.next;

        temp.next = n;
        n.next = tempNode;


        return head;


    }

    public static class Node {
        public int data;
        public Node next;
        public Node prev;
    }

}
