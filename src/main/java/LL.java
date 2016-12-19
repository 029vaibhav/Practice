import java.util.ArrayList;
import java.util.List;

public class LL {

    static int[] data = {2,1,4,3};
    static int[] pos = {0, 1, 2, 3, 1};

    public static void main(String[] ar) {

        Node node = null;
        for (int i = 0; i < data.length; i++) {
            node = SortedInsert(node, data[i]);
        }


        ReverseDobuly(node);
    }

    static Node Delete(Node head, int position) {
        // Complete this method

        if(head==null)
            return null;

        Node temp = head;
        if(position ==0)
        {
            head = temp.next;
            return head;

        }

        int count =0;

        while(count<position-1){

            temp = temp.next;
            count++;

        }

        temp = temp.next.next;
        head.next = temp;
        return head;





    }

  static   void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        List<Integer> l = new ArrayList<>();
        while(head!=null)
        {

            l.add(head.data);
            head = head.next;
        }

        for(int i = l.size() - 1; i >= 0; i--)
        {
            System.out.println(""+l.get(i));
        }


    }

    static Node Reverse(Node head) {



        if(head==null)return null;

        List<Integer> l = new ArrayList<>();
        while(head!=null){

            l.add(head.data);
            head = head.next;

        }

        Node n2 = new Node();
        Node temp = n2;
        for(int i = l.size() - 1; i >= 0; i--)
        {
            n2.data= l.get(i);
            if(i!=0){

                n2.next = new Node();
                n2 = n2.next;
            }
        }

        return temp;

    }

    static Node ReverseDobuly(Node head) {

        Node temp = head;
        Node newHead = head;

        while(temp!=null){

            Node x = temp.next;
            temp.next = temp.prev;
            temp.prev = x;
            newHead = temp;

            temp = temp.prev;

        }

        return newHead;


    }


    static Node SortedInsert(Node head,int data) {

        Node n = new Node();
        n.data = data;

        if(head==null)return n;

        Node temp = head;

        while(temp!=null){

            if(temp.next==null && temp.prev==null)
            {

                if(temp.data<data){
                    temp.next = n;
                    n.prev = temp;
                }
                else{
                    temp.prev = n;
                    n.next = temp;
                    head = n;
                }

                break;
            }
            if(temp.next==null)
            {
                temp.next = n;
                n.prev = temp;
                break;
            }

            if (temp.data < data && temp.next.data > data)
            {
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

        while (count < position-1) {

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
