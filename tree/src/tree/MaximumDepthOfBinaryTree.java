package tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;
    TreeNodes() {}
    TreeNodes(int val) { this.val = val; }
    TreeNodes(int val, TreeNodes left, TreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

public static class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNodes root) {

        int level = 0;

        if (root == null) {
            return level;
        }

        Queue<TreeNodes> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodes currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        // Creating a test binary tree:
        //         3
        //        / \
        //       9  20
        //         /  \
        //        15   7

        TreeNodes root = new TreeNodes(3);
        root.left = new TreeNodes(9);
        root.right = new TreeNodes(20);
        root.right.left = new TreeNodes(15);
        root.right.right = new TreeNodes(7);

        System.out.println(maxDepth(root));
    }
}}
