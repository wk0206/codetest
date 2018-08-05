package easy;

public class Q543 {
	public static int max= 0;
	
    public int diameterOfBinaryTree(TreeNode root) {
    	max= 1;
    	depth(root);
    	return max-1;
    	
    }
    
    public int depth(TreeNode node) {
    	if(node==null) return 0;
    	
    	int L = depth(node.left);
    	int R = depth(node.right);
    	
    	max = Math.max(L+R+1, max);
    	
    	return Math.max(L, R)+1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

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
class Solution {

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}