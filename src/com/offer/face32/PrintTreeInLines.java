package com.offer.face32;

import java.util.ArrayList;

import com.offer.face26.TreeNode;

/**
 * 分行从上向下打印二叉树。
 *   从上向下打印二叉树，同一层的节点按从左向右顺序打印，每一层打印到一行
 * @author admin
 *
 */
public class PrintTreeInLines {
	
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		int toBePrinted = 0;
		int nextLevelNodeNums = 0;
		
		ArrayList<TreeNode> aux = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(pRoot == null) {
			return result;
		}
		
		aux.add(pRoot);
		nextLevelNodeNums = 0;
		toBePrinted = 1;
		ArrayList<Integer> level = new ArrayList<>();
		while(true) {
			TreeNode now = null;
			if(aux.isEmpty()) {
				result.add(level);
				break;
			}else {
				now = aux.get(0);
			}
			
			if(toBePrinted > 0) {
				level.add(now.val);
				toBePrinted--;
				aux.remove(0);
			}else {
				result.add(level);
				level = new ArrayList<>();
				toBePrinted = nextLevelNodeNums;
				nextLevelNodeNums = 0;
				continue;
			}
			
			if(now.left != null) {
				aux.add(now.left);
				nextLevelNodeNums++;
			}
			if(now.right != null) {
				aux.add(now.right);
				nextLevelNodeNums++;
			}
			
		}
		
		return result;
	    
    }
	
	public static void main(String[] args) {
		PrintTreeInLines ptl = new PrintTreeInLines();
		
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
