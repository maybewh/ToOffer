package com.offer.face33;

import com.offer.face26.TreeNode;

/**
 * �����������ĺ����������
 *   ��Ŀ������һ���������飬�жϸ������ǲ���ĳ�����������ĺ������������Ƿ���true��
 *    ���򷵻�false.�������������������������ֶ�����ͬ
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
		
		//�ж��������ǲ��Ƕ�����
		boolean left = true;
		if(i > 0) {
			left = VerifySquenceOfBST(leftChildTree);
		}
		
		//�ж��������ǲ��Ƕ�����
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
