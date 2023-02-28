public class BinTree {
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


    static class BuildTree {
        static int idx = -1;

        public static Node BinaryTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.lchild = BinaryTree(nodes);
            newNode.rchild = BinaryTree(nodes);

            return newNode;
        }


        public static void preorder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.lchild);
            preorder(root.rchild);

        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }

            inorder(root.lchild);
            System.out.print(root.data + " ");
            inorder(root.rchild);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }

            postorder(root.lchild);
            postorder(root.rchild);

            System.out.print(root.data + " ");
            
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BuildTree.BinaryTree(nodes);
        System.out.println("\nRoot of the node is: ");
        System.out.println(root.data);
        System.out.println("Preorder Sequence: ");
        BuildTree.preorder(root);
        System.out.println();
        System.out.println("Inorder Sequence: ");
        BuildTree.inorder(root);
        System.out.println();
        System.out.println("Postorder Sequence: ");
        BuildTree.postorder(root);
    }
}
