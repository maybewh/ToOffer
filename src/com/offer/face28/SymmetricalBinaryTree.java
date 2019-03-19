package com.offer.face28;

import com.offer.face26.TreeNode;

/**
 * ������28���Գƶ�����
 *  ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô���ǶԳƵ�
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
