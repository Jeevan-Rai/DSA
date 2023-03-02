public class HeightOfTree {
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
        static int count = 0;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.lchild = buildTree(nodes);
            newNode.rchild = buildTree(nodes);

            return newNode;
        }

        public static int Height(Node root) {
            if (root == null) {
                return 0;
            }

            int lheight = Height(root.lchild);
            int rheight = Height(root.rchild);

            return Math.max(lheight, rheight) + 1;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.buildTree(nodes);
        System.out.println(BinaryTree.Height(root));
    }
}
