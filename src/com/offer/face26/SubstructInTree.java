package com.offer.face26;

/**
 * 树的子结构：
 * 	  输入两棵二叉树A,B,判断B是不是A的子结构（ps:我们约定空树不是任意一个树的子结构）
 * @author admin
 *
 */
public class SubstructInTree {
	
	//使用递归来处理
	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		
		boolean result = false;
		if(root1 == null || root2 == null)
			return false;
		
		//相等
		if(equal(root1, root2)) {
			result = doesTree1HaveTree2(root1, root2);
		}
		//不等，左孩子
		if(!result) {
			result = hasSubtree(root1.left, root2);
		}
		//不等，右孩子
		if(!result)
			result = hasSubtree(root1.right, root2);
		
		return result;
		
	}
	
	boolean doesTree1HaveTree2(TreeNode node1,TreeNode node2) {
		if(node2 == null)
			return false;
		if(node1 == null)
			return false;
        
		if(!equal(node1,node2))
			return false;
		
		return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
		
	}
	
	boolean equal(TreeNode num1,TreeNode num2) {
		if(num1.val == num2.val)
			return true;
		return false;
	}
}
