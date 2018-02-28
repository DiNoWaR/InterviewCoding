package com.denis.interview.binarytree.morristraversal;

/**
 * Using Morris Traversal, we can traverse the tree without using stack and recursion.
 * The idea of Morris Traversal is based on Threaded Binary Tree.
 * In this traversal, we first create links to InOrder successor and print the data using these links,
 * and finally revert the changes to restore original tree.
 */
class MorrisTraversal {

    private TNode root;

    /**
     * Function to traverse binary tree without recursion and
     * without stack
     */
    public void MorrisTraversalAlgorithm(TNode root) {

        TNode current, predecessor;

        if (root == null)
            return;

        current = root;

        while (current != null) {

            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                predecessor = current.left;

                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;

                }

                /* Make current as right child of its inorder predecessor */
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }

                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                else {
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition predecessor->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */

    }

    public static void main(String args[]) {

        /* Constructed binary tree is
               1
             /   \
            2      3
          /  \
        4     5
        */

        MorrisTraversal tree = new MorrisTraversal();

        tree.root = new TNode(1);
        tree.root.left = new TNode(2);
        tree.root.right = new TNode(3);
        tree.root.left.left = new TNode(4);
        tree.root.left.right = new TNode(5);

        tree.MorrisTraversalAlgorithm(tree.root);
    }
}
