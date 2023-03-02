import java.util.*;

public class DiameterOfTree {
    static class Node {
        int data;
        Node lchild;
        Node rchild;

        public Node(int data) {
            this.data = data;
            this.lchild = null;
            this.rchild = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.lchild = BuildTree(nodes);
            newnode.rchild = BuildTree(nodes);

            return newnode;
        }
    }

    class TreeInfo {
        int ht;
        int diam;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.BuildTree(nodes);

    }
}
