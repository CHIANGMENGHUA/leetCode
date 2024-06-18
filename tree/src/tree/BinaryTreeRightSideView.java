package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNodess {
    int val;
    TreeNodess left;
    TreeNodess right;
    TreeNodess() {}
    TreeNodess(int val) { this.val = val; }
    TreeNodess(int val, TreeNodess left, TreeNodess right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeRightSideView {

    public static ArrayList<Integer> rightSideView(TreeNodess root) {

        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNodess> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodess currentNode = queue.poll();
                if (i == size - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a binary tree for testing
        //         1
        //        / \
        //       2   3
        //        \   \
        //         5   4
        TreeNodess root = new TreeNodess(1);
        root.left = new TreeNodess(2);
        root.right = new TreeNodess(3);
        root.left.right = new TreeNodess(5);
        root.right.right = new TreeNodess(4);

        System.out.println(rightSideView(root));
    }
}
