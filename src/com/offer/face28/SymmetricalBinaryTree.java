package com.offer.face28;

import com.offer.face26.TreeNode;

/**
 * 面试题28：对称二叉树
 *  请实现一个函数，用来判断一颗二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的
 * @author admin
 *
 */
public class SymmetricalBinaryTree {
	
	boolean isSymmetrical(TreeNode pRoot)
    {
		
		return isSymmetrical(pRoot,pRoot);
    }

	private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot2) {
		
		if(pRoot == null && pRoot2 == null)
			return true;
		if(pRoot == null || pRoot2 == null)
			return false;
		
		TreeNode temp = pRoot.left;
		pRoot.left = pRoot.right;
		pRoot.right = temp;
		if(pRoot.val != pRoot2.val)
			return false;

		return isSymmetrical(pRoot.left, pRoot2.left) && isSymmetrical(pRoot.right, pRoot2.right);
	}
}
