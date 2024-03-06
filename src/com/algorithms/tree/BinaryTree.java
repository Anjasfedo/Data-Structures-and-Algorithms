package com.algorithms.tree;

import java.util.LinkedList;
import java.util.Stack;

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

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void iterativePreOrder() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();

            System.out.print(temp.data + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
        
    }

    public void iterativeInOrder() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;

        while (!stack.isEmpty() || temp !=null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void PostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void iterativePostOrder() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;

                if (temp == null) {
                    temp = stack.pop();

                    System.out.print(temp.data + " ");

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        
                        System.out.print(temp.data + " ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }

        java.util.Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            
        }
    }

    public static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int result = root.data;

        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left > result) {
            result = left;
        }

        if (right > result) {
            result = right;
        }

        return result;
    }
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.createBinaryTree();

        // bt.preOrder(bt.root);
        // bt.inOrder(bt.root);

        // System.out.println();

        // bt.iterativePreOrder();
        // bt.iterativeInOrder();

        // System.out.println();

        // bt.PostOrder(bt.root);

        // System.out.println();

        // bt.iterativePostOrder();

        // System.out.println();

        // bt.levelOrder();

        System.out.println(findMax(bt.root));
    }
}
