package com.offer.face27;

import com.offer.face26.TreeNode;

/**
 * 前序遍历这棵树的节点，如果遍历到的节点有子节点，则交换它的两个子节点，
 * 	当交换完所有非叶节点的左右子节点后，就得到了树的镜像
 * @author admin
 *
 */
public class MirrorOfBinaryTree {
	
	public void Mirror(TreeNode root) {
        
		if(root == null)
			return;
		if(root.left == null && root.right == null)
			return;
		
		TreeNode temp = root.left;
		//先交换，再遍历
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null)
			Mirror(root.left);
		if(root.right != null)
			Mirror(root.right);		
    }
}
