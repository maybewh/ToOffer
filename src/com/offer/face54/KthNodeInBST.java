package com.offer.face54;

import java.util.ArrayList;

import com.offer.face26.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 * @author admin
 *
 */
public class KthNodeInBST {
	
	 ArrayList<TreeNode> list = new ArrayList<>();
	 
	/**
	 * 最简单的思路，中序遍历二叉树，然后直接从里面获取
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
