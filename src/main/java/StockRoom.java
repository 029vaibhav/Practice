import java.util.HashMap;
import java.util.Scanner;

public class StockRoom {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int p = in.nextInt();


        HashMap<Integer, Node> hashMap = new HashMap<>();
        for (int i = 0; i < p; i++) {

            int instanceID = in.nextInt();
            int instanceID1 = in.nextInt();
            Node node1 = hashMap.get(instanceID);
            Node node2 = hashMap.get(instanceID1);
            int instanceID2 = in.nextInt();
            if (node1 == null && node2 == null) {
                Node node = new Node();
                node.setData(instanceID);
                node.setPath(instanceID2);
                Node node3 = new Node();
                node3.setData(instanceID1);
                node.setNode(node3);
                node3.setBackNode(node);
                hashMap.put(instanceID, node);
                hashMap.put(instanceID1, node3);
            } else if (node1 == null & node2 != null) {
                Node node = new Node(instanceID, instanceID2, null);
                hashMap.put(instanceID, node);
                node2.setNode(node);
                node.setBackNode(node2);

            } else if (node1 != null & node2 == null) {
                Node node = new Node(instanceID1, instanceID2, null);
                hashMap.put(instanceID1, node);
                node1.setNode(node);
                node.setBackNode(node1);

            }

        }

        String wTraverse = "";
        int wc = 0;
        if (w < d) {
            wTraverse = "" + w;
            Node node = hashMap.get(w);
            wc = wc + node.path;
            while (node.data != d) {
                node = node.node;
                wc = wc + node.path;
                wTraverse = wTraverse + " " + node.data;
            }


        } else {
            wTraverse = "" + w;
            Node node = hashMap.get(d);
            wc = wc + node.path;
            while (node.data != w) {
                node = node.node;
                wc = wc + node.path;
                wTraverse = wTraverse + " " + node.data;
            }
        }

        String cTraverse = "";
        int cc = 0;
        if (c < d) {
            cTraverse = "" + c;
            Node node = hashMap.get(c);
            cc = cc + node.path;
            while (node.data != d) {
                node = node.node;
                cc = cc + node.path;
                cTraverse = cTraverse + " " + node.data;
            }


        } else {
            cTraverse = "" + c;
            Node node = hashMap.get(d);
            cc = cc + node.path;
            while (node.data != c) {
                node = node.node;
                cc = cc + node.path;
                cTraverse = cTraverse + " " + node.data;
            }
        }

        if (wc > cc) {
            System.out.println("Wolverine " + (wc - cc));
        } else {
            System.out.println("Cyclops " + (cc - wc));
        }


    }


    static class Node {

        int data, path;
        Node node;
        Node backNode;

        public Node() {
        }

        public Node(int data, int path, Node node) {
            this.data = data;
            this.path = path;
            this.node = node;
        }

        public Node getBackNode() {
            return backNode;
        }

        public void setBackNode(Node backNode) {
            this.backNode = backNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return getData() == node.getData();

        }

        @Override
        public int hashCode() {
            return getData();
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getPath() {
            return path;
        }

        public void setPath(int path) {
            this.path = path;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }
    }
}
