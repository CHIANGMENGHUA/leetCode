package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeLevelOrderTraversal {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {

	    ArrayList<List<Integer>> result = new ArrayList<>();
	    
	    if (root == null) {
	        return result;
	    }

	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    
	    while (!queue.isEmpty()) {

	        int size = queue.size();
	        ArrayList<Integer> level = new ArrayList<>();

	        for (int i = 0; i < size; i++) {
	            TreeNode currentNode = queue.poll();
	            level.add(currentNode.val);

	            if (currentNode.left != null) {
	                queue.offer(currentNode.left);
	            }

	            if (currentNode.right != null) {
	                queue.offer(currentNode.right);
	            }
	        }

	        result.add(level);
	    }

	    return result;
	}

	public static void main(String[] args) {
		
        // Create a sample binary tree:
        //         3
        //       /   \
        //      9    20
        //          /  \
        //         15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        // Get the level order traversal result
        List<List<Integer>> result = levelOrder(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
