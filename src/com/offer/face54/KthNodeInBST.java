package com.offer.face54;

import java.util.ArrayList;

import com.offer.face26.TreeNode;

/**
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8��    �У�
 * �������ֵ��С˳�����С����ֵΪ4��
 * @author admin
 *
 */
public class KthNodeInBST {
	
	 ArrayList<TreeNode> list = new ArrayList<>();
	 
	/**
	 * ��򵥵�˼·�����������������Ȼ��ֱ�Ӵ������ȡ
	 * @param pRoot
	 * @param k
	 * @return
	 */
	TreeNode kthNode(TreeNode pRoot, int k)
    {
		if(pRoot == null)
			return null;
		travelTree(pRoot);
		if(k > list.size())
			return null;
		return list.get(k - 1);
    }

	private void travelTree(TreeNode pRoot) {
		
		if(pRoot.left != null) {
			travelTree(pRoot.left);
		}
		list.add(pRoot);
		if(pRoot.right != null) {
			travelTree(pRoot.right);
		}
		
	}
}
