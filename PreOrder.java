class preorder {

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

        public static Node BuildTree(int Nodes[]) {
            idx++;

            if (Nodes[idx] == -1) {
                return null;
            }

            Node NewNode = new Node(Nodes[idx]);
            NewNode.lchild = BuildTree(Nodes);
            NewNode.rchild = BuildTree(Nodes);

            return NewNode;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.lchild);
        preorder(root.rchild);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.BuildTree(nodes);
        preorder(root);
    }
}