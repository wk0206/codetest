package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

public class TreeNode{
	private int nodeValue = 0;
	private int nodeId = 0;
	private int parentId = 0;
	
	List<TreeNode> leaves = new ArrayList<TreeNode>();
	
	public TreeNode(int nodeId){
		this.nodeId = nodeId;
	}
	public TreeNode(int nodeId, int parentId){
		this.nodeId=nodeId;
		this.parentId = parentId;
	}
	
	    public int getNodeId() {  
        return nodeId;  
    }  
  
    public void setNodeId(int nodeId) {  
        this.nodeId = nodeId;  
    }  
  
    public int getParentId() {  
        return parentId;  
    }  
  
    public void setParentId(int parentId) {  
        this.parentId = parentId;  
    }  
  
}