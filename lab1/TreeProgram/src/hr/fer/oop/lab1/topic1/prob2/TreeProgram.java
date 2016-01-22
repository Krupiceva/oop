package hr.fer.oop.lab1.topic1.prob2;

/**
 *
 * @author Dora Mlinarić 0036480184
 * @version 1.0
 */
class TreeProgram {

    static class TreeNode {

        /**
         * left node
         */
        TreeNode left;
        /**
         * right node
         */
        TreeNode right;
        /**
         * node data
         */
        String data;
    }

    /**
     * This method is called once the program is run. Arguments are described
     * below
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        TreeNode node = null;
        node = insert(node, "Jasna");
        node = insert(node, "Ana");
        node = insert(node, "Ivana");
        node = insert(node, "Anamarija");
        node = insert(node, "Vesna");
        node = insert(node, "Kristina");
        System.out.println("Writing tree inorder:");
        writeTree(node);
        node = reverseTreeOrder(node);
        System.out.println("Writing reversed tree inorder:");
        writeTree(node);
        int size = sizeOfTree(node);
        System.out.println("Number of nodes in tree is " + size + ".");
        boolean found = containsData(node, "Ivana");
        System.out.println("Searched element is found: " + found);
    }

    /**
     * Examines whether there is data in the tree
     *
     * @param treeRoot is root of a tree
     * @param data is data that is requested
     * @return true if there is data in the tree, false if not
     */
    static boolean containsData(TreeNode treeRoot, String data) {

        if (treeRoot != null) {
            if (data.compareTo(treeRoot.data) == 0) {
                return true;
            } else {
                boolean found = containsData(treeRoot.right, data);
                if (found == false) {
                    found = containsData(treeRoot.left, data);
                }
                return found;
            }
        } else {
            return false;
        }
    }

    /**
     * Calculate number of nodes in tree
     *
     * @param treeRoot is start node
     * @return number of nodes
     */
    static int sizeOfTree(TreeNode treeRoot) {
        if (treeRoot == null) {
            return 0;
        } else {
            return 1 + sizeOfTree(treeRoot.right) + sizeOfTree(treeRoot.left);
        }
    }

    /**
     * Method which insert a data in tree
     *
     * @param treeRoot is root of a tree
     * @param data is data that needs to write in a tree
     * @return the root
     */
    static TreeNode insert(TreeNode treeRoot, String data) {
        if (treeRoot == null) {
            TreeNode newNode = new TreeNode();
            newNode.data = data;
            newNode.right = null;
            newNode.left = null;
            return newNode;
        } else if (data.compareTo(treeRoot.data) < 1) {
            treeRoot.right = insert(treeRoot.right, data);
        } else {
            treeRoot.left = insert(treeRoot.left, data);
        }

        return treeRoot;
    }

    /**
     * Write inorder tree
     *
     * @param treeRoot is start node
     */
    static void writeTree(TreeNode treeRoot) {
        if (treeRoot != null) {
            writeTree(treeRoot.left);
            System.out.println(treeRoot.data);
            writeTree(treeRoot.right);
        }
    }

    /**
     * Metod which reverse order of a tree
     *
     * @param treeRoot is root of a tree
     * @return the root
     */
    static TreeNode reverseTreeOrder(TreeNode treeRoot) {
        if (treeRoot == null) {
            return null;
        }

        TreeNode tempNode = new TreeNode();

        tempNode = treeRoot.left;
        treeRoot.left = treeRoot.right;
        treeRoot.right = tempNode;

        reverseTreeOrder(treeRoot.right);
        reverseTreeOrder(treeRoot.left);

        return treeRoot;
    }

}
