import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void insertRoot(Object data) {
        if (this.root == null) {
            this.root = new TreeNode(data);
        }
    }

    public TreeNode search(Object data) {
        return searchRecursive(this.root, data);
    }

    private TreeNode searchRecursive(TreeNode node, Object data) {
        if (node == null) {
            return null;
        }
        if (node.data.equals(data)) {
            return node;
        }
        TreeNode leftResult = searchRecursive(node.left, data);
        if (leftResult != null) {
            return leftResult;
        }
        return searchRecursive(node.right, data);
    }

    public boolean insertLeft(Object parent, Object data) {
        TreeNode parentNode = search(parent);
        if (parentNode != null && parentNode.left == null) {
            parentNode.left = new TreeNode(data);
            return true;
        }
        return false;
    }

    public boolean insertRight(Object parent, Object data) {
        TreeNode parentNode = search(parent);
        if (parentNode != null && parentNode.right == null) {
            parentNode.right = new TreeNode(data);
            return true;
        }
        return false;
    }

    public void buildTree(Scanner scanner) {
        System.out.print("Raiz: ");
        String rootData = scanner.nextLine().trim();
        if (!rootData.isEmpty() && !rootData.equals("-")) {
            insertRoot(rootData);
            buildTreeRecursive(this.root, scanner);
        }
    }

    private void buildTreeRecursive(TreeNode node, Scanner scanner) {
        if (node == null) return;

        System.out.print("Hijo izquierdo de " + node.data + ": ");
        String leftData = scanner.nextLine().trim();
        if (!leftData.isEmpty() && !leftData.equals("-")) {
            node.left = new TreeNode(leftData);
        }

        System.out.print("Hijo derecho de " + node.data + ": ");
        String rightData = scanner.nextLine().trim();
        if (!rightData.isEmpty() && !rightData.equals("-")) {
            node.right = new TreeNode(rightData);
        }

        if (node.left != null) buildTreeRecursive(node.left, scanner);
        if (node.right != null) buildTreeRecursive(node.right, scanner);
    }

    public void printTree() {
        printTreeRecursive(this.root, "", true);
    }

    private void printTreeRecursive(TreeNode node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);
            List<TreeNode> children = new ArrayList<>();
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
            for (int i = 0; i < children.size() - 1; i++) {
                printTreeRecursive(children.get(i), prefix + (isTail ? "    " : "│   "), false);
            }
            if (!children.isEmpty()) {
                printTreeRecursive(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    public String preorder() {
        StringBuilder sb = new StringBuilder();
        preorderRecursive(this.root, sb);
        return sb.toString().trim();
    }

    private void preorderRecursive(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preorderRecursive(node.left, sb);
            preorderRecursive(node.right, sb);
        }
    }

    public String inorder() {
        StringBuilder sb = new StringBuilder();
        inorderRecursive(this.root, sb);
        return sb.toString().trim();
    }

    private void inorderRecursive(TreeNode node, StringBuilder sb) {
        if (node != null) {
            inorderRecursive(node.left, sb);
            sb.append(node.data).append(" ");
            inorderRecursive(node.right, sb);
        }
    }

    public String postorder() {
        StringBuilder sb = new StringBuilder();
        postorderRecursive(this.root, sb);
        return sb.toString().trim();
    }

    private void postorderRecursive(TreeNode node, StringBuilder sb) {
        if (node != null) {
            postorderRecursive(node.left, sb);
            postorderRecursive(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int balanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.right) - height(node.left);
    }

    public boolean isBalanced() {
        return unbalancedNodes().isEmpty();
    }

    public List<Object> unbalancedNodes() {
        List<Object> unbalanced = new ArrayList<>();
        findUnbalancedRecursive(this.root, unbalanced);
        return unbalanced;
    }

    private void findUnbalancedRecursive(TreeNode node, List<Object> unbalanced) {
        if (node != null) {
            int bf = balanceFactor(node);
            if (bf < -1 || bf > 1) {
                unbalanced.add(node.data);
            }
            findUnbalancedRecursive(node.left, unbalanced);
            findUnbalancedRecursive(node.right, unbalanced);
        }
    }

    public void printBalanceFactors() {
        printBalanceFactorsRecursive(this.root, "", true);
    }

    private void printBalanceFactorsRecursive(TreeNode node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data + " (FE: " + balanceFactor(node) + ")");
            List<TreeNode> children = new ArrayList<>();
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
            for (int i = 0; i < children.size() - 1; i++) {
                printBalanceFactorsRecursive(children.get(i), prefix + (isTail ? "    " : "│   "), false);
            }
            if (!children.isEmpty()) {
                printBalanceFactorsRecursive(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    public TreeNode rotateRight(TreeNode node) {
        if (node == null || node.left == null) return node;
        TreeNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    public TreeNode rotateLeft(TreeNode node) {
        if (node == null || node.right == null) return node;
        TreeNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    public TreeNode rotateLeftRight(TreeNode node) {
        if (node != null && node.left != null) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        return node;
    }

    public TreeNode rotateRightLeft(TreeNode node) {
        if (node != null && node.right != null) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void balance() {
        this.root = balanceRecursive(this.root);
    }

    private TreeNode balanceRecursive(TreeNode node) {
        if (node == null) return null;

        node.left = balanceRecursive(node.left);
        node.right = balanceRecursive(node.right);

        int bf = balanceFactor(node);

        if (bf > 1) {
            if (balanceFactor(node.right) < 0) {
                return rotateRightLeft(node);
            } else {
                return rotateLeft(node);
            }
        }

        if (bf < -1) {
            if (balanceFactor(node.left) > 0) {
                return rotateLeftRight(node);
            } else {
                return rotateRight(node);
            }
        }

        return node;
    }
}