package com.offer.face34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.offer.face26.TreeNode;

/**
 * 面试题34：二叉树中和为某一值的路径
 *  题目：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
 * @author admin
 *
 */
public class PathInTree {
	
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	ArrayList<Integer> path = new ArrayList<>();
	/**
	 * 二叉树的前序遍历从根开始
	 * @param root
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
		if(root == null)
			return result;	
		generatePath(root, target);
		return result;
        
    }
	
	public void generatePath(TreeNode root,int target) {
		
		path.add(root.val);
		int nextTarget = target - root.val;
		if(root.left == null && root.right == null && nextTarget == 0) {
			ArrayList<Integer> insert = new ArrayList<>(Arrays.asList(new Integer[path.size()]));
			Collections.copy(insert, path);
			result.add(insert);
			
		}
		if(root.left != null) {
			generatePath(root.left, nextTarget);
		}
			
		if(root.right != null) {
			generatePath(root.right, nextTarget);		
		}
		path.remove(path.size() - 1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode first = new TreeNode(5);
		TreeNode second = new TreeNode(12);
		TreeNode third = new TreeNode(4);
		TreeNode fourth = new TreeNode(7);
	/*	TreeNode fifth = new TreeNode(9);
		TreeNode sixth = new TreeNode(11);*/
		
		root.left = first;
		root.right = second;
		first.left = third;
		first.right = fourth;
		PathInTree pit = new PathInTree();
		ArrayList<ArrayList<Integer>> re = pit.FindPath(root, 22);
		
		for (ArrayList<Integer> arrayList : re) {
			for (Integer integer : arrayList) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
}
