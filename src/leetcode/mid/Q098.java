package leetcode.mid;

public class Q098 {

	public boolean isValidBST_leetCode(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.val >= maxVal || root.val <= minVal)
			return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	private static boolean flag = true;

	public static boolean isValidBST(TreeNode root) {
		// input check
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;

		// check flag
		if (!flag)
			return false;

		TreeNode left = root.left == null ? null : root.left;
		TreeNode right = root.right == null ? null : root.right;

		if (left != null && left.val > root.val) {
			flag = false;
			return false;
		} else {
			flag = isValidBST(left);
		}

		if (right != null && root.val > right.val) {
			flag = false;
			return false;
		} else {
			flag = isValidBST(right);
		}

		return flag;
	}

	public static void main(String[] args) {
		Q098 instance = new Q098();
//		TreeNode tn = instance.new TreeNode();
//		TreeNode(new String[] { "0", "-1" });
		
		TreeNode tn = instance.new TreeNode(new String[] { "0", "-1" });
		isValidBST(tn);
	}

	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}

		TreeNode(Integer x) {
			this.val = x;
		}

		TreeNode(String[] input) {
			if (input.length == 1) {
				val = Integer.valueOf(input[0]);
				left = null;
				right = null;
			}

			if (input.length == 2) {
				val = Integer.valueOf(input[0]);
				left = input[1] == null ? null : new TreeNode(Integer.valueOf(input[1]));
				right = null;
			}

			if (input.length == 3) {
				val = Integer.valueOf(input[0]);
				left = input[1] == null ? null : new TreeNode(Integer.valueOf(input[1]));
				right = input[2] == null ? null : new TreeNode(Integer.valueOf(input[2]));
			}

		}

		public TreeNode(String[] input, int root, int left, int right) {
			String rootVal = input[root];
			String leftVal = input[left];
			String rightVal = input[right];
			if (rootVal != null) {
				this.val = Integer.valueOf(leftVal);
			}
			this.left = leftVal == null ? null : new TreeNode(Integer.valueOf(leftVal));
			this.right = rightVal == null ? null : new TreeNode(Integer.valueOf(rightVal));

		}
	}

}
