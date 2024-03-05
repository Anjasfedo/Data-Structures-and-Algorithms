package com.algorithms.tree;

public class BinaryTree {

    private TreeNode root;
    
    public class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;

        return first;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.root = bt.createBinaryTree();

        bt.preOrder(bt.root);
    }
}
