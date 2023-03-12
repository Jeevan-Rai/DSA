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

    static class TreeInfo {
        int ht;
        int diam;

        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }

    }

    public static TreeInfo diameter(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter(root.lchild);
        TreeInfo right = diameter(root.rchild);

        int myhight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(myhight, mydiam);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.BuildTree(nodes);
        System.out.println(diameter(root).diam);
    }
}
