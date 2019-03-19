package com.offer.face7;

/**
 * ��Ŀ������ĳ��������ǰ���������������Ľ�������ؽ��ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡����磬�����
 * ǰ������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6},���ؽ���ͼ
 * 2.6��ʾ�Ķ��������������ͷ�ڵ㡣
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
		
		//��ʼ��
		for (int i = inStart; i <= inEnd; i++) {
			int j = inOrder[i];
			if(j == preOrder[preStart]) {
				//����������,������������ǰ������Ľ����㣬�����������������Ԫ�صĸ����������
				root.leftNode = constructCore(preOrder, preStart + 1, preStart + i - inStart, inOrder, inStart, i - 1);
				//�����������������������ǰ���������ʼ�㣬������Ԫ�ؽ���ֵ+1
				root.rightNode = constructCore(preOrder, preStart + i - inStart + 1, preEnd, inOrder, i + 1, inEnd);
			}
		}
		
		return root;
	}
}
