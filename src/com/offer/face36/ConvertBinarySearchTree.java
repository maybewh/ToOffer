package com.offer.face36;

import com.offer.face26.TreeNode;

/**
 *  ������36������������
 *  ��Ŀ������һ�ö��������������ö���������ת����һ�������˫������
 *  Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 * @author admin
 *
 */
public class ConvertBinarySearchTree {
	TreeNode pLastTreeNode = null;
	/**
	 * ����������������������������
	 * �ݹ�
	 * @param pRootOfTree
	 * @return
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		
		if(pRootOfTree == null)
			return null;
		
		
		convertNode(pRootOfTree);
		
		TreeNode pHead = pLastTreeNode;
		while(pHead != null && pHead.left != null) {
			pHead = pHead.left;
		}
		return pHead;
    }

	private void convertNode(TreeNode pRootOfTree) {
		
		if(pRootOfTree == null)
			return;
		
		TreeNode pCurrent = pRootOfTree;
		
		if(pCurrent.left != null) {
			convertNode(pCurrent.left);
		}

		pCurrent.left = pLastTreeNode;
		if(pLastTreeNode != null) {
			pLastTreeNode.right = pCurrent;
		}
		
		pLastTreeNode = pCurrent;
		
		if(pCurrent.right != null) {
			convertNode(pCurrent.right);
		}
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		TreeNode first = new TreeNode(6);
		TreeNode second = new TreeNode(10);
		TreeNode third = new TreeNode(5);
		TreeNode fourth = new TreeNode(7);
		TreeNode fifth = new TreeNode(9);
		TreeNode sixth = new TreeNode(11);
		
		root.left = first;
		root.right = second;
		
		first.left = third;
		first.right = fourth;
		
		second.left = fifth;
		second.right =sixth;
		
		ConvertBinarySearchTree cbs = new ConvertBinarySearchTree();
		
		TreeNode result = cbs.Convert(root);
		
		TreeNode temp = result;
		while(temp != null && temp.right != null) {
			System.out.print(temp.val +" ");
			temp = temp.right;
		}
		System.out.print(temp.val);
		System.out.println();
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.left;
		}
	}
}
