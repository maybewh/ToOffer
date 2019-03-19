package com.offer.face32;

import java.util.ArrayList;
import java.util.Stack;

import com.offer.face26.TreeNode;

/**
 * ֮���д�ӡ��������
 *   ��ʵ��һ����������֮ ����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ��
 *  �ڶ��㰴�մ��������˳���ӡ���������ٰ��մ������ҵ�˳���ӡ���������Դ�����
 * @author admin
 *
 */
public class PrintTreeInZigzag {
	
	 public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {		
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(pRoot == null) {
			return result;
		}
		int level = 1;
		Stack<TreeNode> auxOdd = new Stack<>();
		Stack<TreeNode> auxEven = new Stack<>();
		
		auxOdd.push(pRoot);
		
		while(!auxOdd.empty() || !auxEven.empty()) {
			ArrayList<Integer> now = new ArrayList<>();
			if(level % 2 == 0) {//ż����
				//��ӡ��ǰ�㣬�����������Ҵ�ӡ
				while(!auxEven.empty()) {
					
					now.add(auxEven.peek().val);
					
					TreeNode nowNode = auxEven.pop();
					//�����������Ԫ�أ���ȡ��ʱ�����Ǵ�������
					if(nowNode.right != null) {
						auxOdd.push(nowNode.right);
					}
					if(nowNode.left != null) {
						auxOdd.push(nowNode.left);
					}
					if(auxEven.empty()) {
						level++;
						result.add(now);
					}
				}
			}else {//������
				//��ӡ��ǰ�㣬�������������ӡ
				while(!auxOdd.empty()) {
					now.add(auxOdd.peek().val);
					
					TreeNode nowNode = auxOdd.pop();
					//�����������Ԫ��
					if(nowNode.left != null) {
						auxEven.push(nowNode.left);
					}
					if(nowNode.right != null) {
						auxEven.push(nowNode.right);
					}
					if(auxOdd.empty()) {
						level++;
						result.add(now);
					}
				}
			}
		}
		
			
	    return result;
	 }
	 
	 public static void main(String[] args) {
			PrintTreeInZigzag ptl = new PrintTreeInZigzag();
			
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
			
			ArrayList<ArrayList<Integer>> ll = ptl.Print(root);
			for (ArrayList<Integer> arrayList : ll) {
				for (Integer integer : arrayList) {
					System.out.print(integer +" ");
				}
				System.out.println();
			}
		}
}
