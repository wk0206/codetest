package leetcode.easy;

public class Q530 {
	
	static int min = Integer.MAX_VALUE;
	static TreeNode prev = null;
	
	public static int getMinDif(TreeNode root) {
		
		inorder(root);
		return min;
	}
	
	public static void inorder(TreeNode root) {
		if(root==null)return;
		inorder(root.left);
		if(prev!=null) min = Math.min(min, root.val-prev.val);
		prev = root;
		inorder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
