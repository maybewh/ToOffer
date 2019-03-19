package com.offer.face7;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果。请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如，输入的
 * 前序序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6},则重建如图
 * 2.6所示的二叉树并输出它的头节点。
 * @author admin
 *
 */
public class ConstructBinaryTree {
	
	public BinaryTreeNode construct(int[] preOrder,int[] inOrder) {
		if(preOrder == null || inOrder == null ||preOrder.length <= 0 || inOrder.length <= 0) {
			return null;
		}

		BinaryTreeNode root = constructCore(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
		return root;
		
	}
	
	public BinaryTreeNode constructCore(int[] preOrder,int preStart,int preEnd,
			int[] inOrder,int inStart,int inEnd) {
		if(preStart > preEnd || inStart > inEnd) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(preOrder[preStart]);
		
		//起始点
		for (int i = inStart; i <= inEnd; i++) {
			int j = inOrder[i];
			if(j == preOrder[preStart]) {
				//构建左子树,根结点的左子树前序遍历的结束点，由中序遍历左子树的元素的个数计算出来
				root.leftNode = constructCore(preOrder, preStart + 1, preStart + i - inStart, inOrder, inStart, i - 1);
				//构建右子树，根结点右子树前序遍历的起始点，左子树元素结束值+1
				root.rightNode = constructCore(preOrder, preStart + i - inStart + 1, preEnd, inOrder, i + 1, inEnd);
			}
		}
		
		return root;
	}
}
