package CTCI.TreesAndGraphs;

public class in_order {
	void inOrderTraversal(TreeNode node) {
		if(node != null) {
			inOrderTraversal(node.left);
			visit(node);
			inOrderTraversal(node.right);
		}
	}

	private void visit(TreeNode node) {
		
	}
}
