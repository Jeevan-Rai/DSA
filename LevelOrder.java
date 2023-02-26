import javax.sound.sampled.SourceDataLine;
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

        class BinaryTree {
            static int idx = -1;

            public Node BuildTree(int[] nodes) {
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
        
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(nodes);

        // System.out.println(root.data);
    }
}
