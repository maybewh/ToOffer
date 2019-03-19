package com.offer.face55;

import com.offer.face26.TreeNode;

/**
 * 每个节点只遍历一次的解法
 *  如果我们用后序遍历的方式遍历二叉树的每个节点，那么在遍历到一个节点之前我们就已经遍历了它的左、右子树。
 *  只要在遍历每个节点的时候，记录它的深度(某一节点的深度等于它到叶节点的路径长度)
 * @author admin
 *
 */
public class IsBalancedTree2 {
	
	int depth = 0;
	int leftDepth = 0;
	int rightDepth = 0;
	
	/**
	 * 后序遍历
	 * @param root
	 * @param depth
	 * @return
	 */
	 public boolean isBalanced(TreeNode root,DepthHolder depthHolder) {
		
		if(root == null) {
			depthHolder.depth = 0;
			return true;
		}
		
		DepthHolder leftHolder = new DepthHolder();
		DepthHolder rightHolder = new DepthHolder();
		if(isBalanced(root.left,leftHolder) && isBalanced(root.right,rightHolder)) {
			int diff = leftHolder.depth - rightHolder.depth;
			if(diff <= 1 || diff >= -1) {
				depthHolder.depth = 1 + (leftHolder.depth > rightHolder.depth ? leftHolder.depth : rightHolder.depth);
				return true;
			}
		}
		
		return false;
		 
	 }
	 
	 public static class DepthHolder {
	        int depth;
	  }
	 
}
