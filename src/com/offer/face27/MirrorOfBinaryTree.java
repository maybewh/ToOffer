package com.offer.face27;

import com.offer.face26.TreeNode;

/**
 * ǰ�����������Ľڵ㣬����������Ľڵ����ӽڵ㣬�򽻻����������ӽڵ㣬
 * 	�����������з�Ҷ�ڵ�������ӽڵ�󣬾͵õ������ľ���
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
		//�Ƚ������ٱ���
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null)
			Mirror(root.left);
		if(root.right != null)
			Mirror(root.right);		
    }
}
