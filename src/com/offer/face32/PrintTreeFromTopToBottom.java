package com.offer.face32;

import java.util.ArrayList;

import com.offer.face26.TreeNode;

/**
 * 从上向下打印二叉树的每个节点，同一层节点按照从左向右顺序打印
 * @author admin
 *
 */
public class PrintTreeFromTopToBottom {
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		
		if(root == null)
			return null;
		
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<TreeNode> aux = new ArrayList<>();
		aux.add(root);
		
		while(!aux.isEmpty()) {
			TreeNode now = aux.get(0);
			if(now.left != null) {
				aux.add(now.left);
			}
			if(now.right != null) {
				aux.add(now.right);
			}
			result.add(now.val);
			aux.remove(0);
		}
		
		
		return result;
    }
}
