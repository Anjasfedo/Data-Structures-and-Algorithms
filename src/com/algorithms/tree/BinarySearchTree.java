package com.algorithms.tree;

public class BinarySearchTree {
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

    public void insert(int data) {
        root = insert(root, data);
    }

    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public boolean search(int data) {
        if (search(root, data) != null) {
            return true;
        } else {
            return false;
        }
    }

    public TreeNode search(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        boolean left = isValid(root.left, min, root.data);

        if (left) {
            boolean right = isValid(root.right, root.data, max);
            return right;
        }

        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(7);

        bst.inOrder();

        System.out.println();

        System.out.println(bst.search(5));
        System.out.println(bst.search(1));

        System.out.println();

        System.out.println(bst.isValid(bst.root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
