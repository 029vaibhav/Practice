import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    static Node n = null;
    static Queue<Node> queue = new LinkedList<Node>();

    public static void main(String[] args) {

        Node node = new Node(3, new Node(5, new Node(1, new Node(4, null, null), null), new Node(15, null, null)), new Node(2, new Node(6, null, null), null));
        Node node1 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)), new Node(7, null,null));

// Node copyNode = new Node();
//        getLeft(node, copyNode, 0);
//

        n = node;
        Node temp = node1;
        Node node2 = insertBinary(temp, 6);
        node2.data = 6;


    }

    static Node insertBinary(Node node, int value) {


        if (value > node.data) {
            if (node.right == null) {
                node.right = new Node();
                return node;
            }
            node = node.right;
        } else {
            if (node.left == null) {
                node.left = new Node();
                return node;
            }
            node = node.left;
        }
        node = insertBinary(node, value);
        return node;
    }

    static void levelOrder(Node root) {

        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node tree = queue.remove();
            System.out.print(tree.data + " ");

            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
        }


    }

    static void topView(Node node) {
        printLeftNode(node.left);
        System.out.println(node.data);
        printRightNode(node.right);
    }


    static void printLeftNode(Node node) {

        if (node != null) {
            System.out.println(node.data);
            printLeftNode(node.left);
        }
    }

    static void printRightNode(Node node) {

        if (node != null) {
            printRightNode(node.right);
            System.out.println(node.data);
        }
    }

    static Node getLeft(Node root, Node copy, int left) {

        copy.data = root.data;

        switch (left) {
            case 0:
                if (root.left != null) {
                    copy.left = new Node();
                    copy = copy.left;
                    getLeft(root.left, copy, 0);
                    getLeft(root.right, copy, 1);

                    return copy;
                } else return null;
            case 1:
                if (root.right != null) {
                    copy.right = new Node();
                    copy = copy.right;
                    getLeft(root.left, copy, 0);
                    getLeft(root.right, copy, 1);

                    return copy;
                } else return null;
        }
        return null;

    }

    static void postOrder(Node root) {

        if (root == null) {
            return;
        }
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private static void inorder(Node node) {

        if (node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);

        }

    }

    static int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }

    }


    private static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node() {
        }
    }
}
