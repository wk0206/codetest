package easy;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[Integer.MAX_VALUE];
		for(int i = 0; i < Integer.MAX_VALUE ; i++) {
			test[i]=1;
		}
		

	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
    
    	
    	return null;
    }
    
    public void DFS(TreeNode node, List<String> res, StringBuilder builder) {
    	if(node == null) return;
    	if(node.left == null && node.right == null) {
    		//output this to res
    		builder.append(node.val);
    	}
    }

}

