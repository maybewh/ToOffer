package com.offer.face33;

import com.offer.face26.TreeNode;

/**
 * 二叉搜索树的后序遍历序列
 *   题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历。如果是返回true，
 *    否则返回false.假设输入的数组的任意两个数字都不相同
 * @author admin
 *
 */
public class SequenceOfBST {
	public boolean VerifySquenceOfBST(int [] sequence) {
		
		if(sequence == null || sequence.length <= 0)
			return false;
		
		int root = sequence[sequence.length - 1];
		
		int[] leftChildTree = new int[sequence.length - 1];
		int[] rightChildTree = new int[sequence.length - 1];
		
		int rightIndex = 0;
		int leftIndex = 0;
		int i = 0;
		for(;i < sequence.length - 1 ; i++) {
			if(sequence[i] < root) {
				leftChildTree[leftIndex] = sequence[i];
				leftIndex++;
			}else {
				break;
			}
		}
		for(int j = i; j < sequence.length - 1;j ++) {
			if(sequence[j] < root) {
				return false;
			}else {
				rightChildTree[rightIndex] = sequence[j];
				rightIndex++;
			}
		}
		
		//判断左子树是不是二叉树
		boolean left = true;
		if(i > 0) {
			left = VerifySquenceOfBST(leftChildTree);
		}
		
		//判读右子树是不是二叉树
		boolean right = true;
		if(i < sequence.length - 1) {
			right = VerifySquenceOfBST(rightChildTree);
		}
		if(left && right)
			return true;
		
		return false;
    }
	
	public static void main(String[] args) {
		
		SequenceOfBST sob = new SequenceOfBST();
		int[] test = new int[] {5,7,6,9,11,10,8};
		int[] test2 = new int[] {7,4,6,5};
		System.out.println(sob.VerifySquenceOfBST(test));
		System.out.println(sob.VerifySquenceOfBST(test2));
	}
}
