package BinarySearchTree;

public class BST {
	
	public int value;
	
	public BST left;
	public BST right;

	public BST(){
		
	}
	
	public BST(int v,BST left, BST right ){
		this.value = v;
		this.left = left;
		this.right = right;		
	}
	
	public void add(Integer v){
		//node = add(v, node);
	}
	
	public BST add(Integer v, BST tree){
		if (tree == null){
			tree = new BST(v, null,null);
		}
		
		//Integer i = new Integer(v);
		if (v.compareTo(tree.value)<0){
			tree.left = add(v , tree.left);
		}
		
		if (v.compareTo(tree.value)>0){
			tree.left = add(v , tree.right);
		}
		
		return tree;
		
	}

}
