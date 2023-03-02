public class SumOfNodes {
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
        static int sum = 0;
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

        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            // else {
            //     sum += root.data;
            // }

            // sumOfNodes(root.lchild);
            // sumOfNodes(root.rchild);

            // return sum;

            int lsum = sumOfNodes(root.lchild);
            int rsum = sumOfNodes(root.rchild);

            return lsum + rsum + root.data;
            
        }

    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.buildTree(nodes);
        int sum = BinaryTree.sumOfNodes(root);
        System.out.println(sum);
    }
}
