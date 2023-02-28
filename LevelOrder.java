import java.util.*;

public class LevelOrder {
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
        
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            if (curNode == null) {
                System.out.println();

                if (q.isEmpty()) {
                    break;
                }

                else {
                    q.add(null);
                }
            }

            else {

                System.out.print(curNode.data + " ");
                if (curNode.lchild != null) {
                    q.add(curNode.lchild);
                }

                if (curNode.rchild != null) {
                    q.add(curNode.rchild);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.BuildTree(nodes);
        levelOrder(root);
    }
}
