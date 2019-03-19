package com.offer.face37;


import com.offer.face26.TreeNode;

/**
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
 * @author admin
 *
 */
public class SerializeBinaryTrees {
	
	StringBuffer sb = new StringBuffer();
	
	String Serialize(TreeNode root) {
		if(root == null) {
			sb.append("$,");
			return sb.toString();
		}
		sb.append(root.val+",");
		Serialize(root.left);
		Serialize(root.right);
		
		return sb.toString();
        
	}
	
	TreeNode head = null;
	public int index = -1;
	TreeNode Deserialize(String str) {
		index++;
		String[] strs = str.split(",");
		TreeNode node = null;
		if(!strs[index].equals("$")) {
			node = new TreeNode(Integer.parseInt(strs[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	       
	}
	public void sequence(TreeNode node) {
		if(node != null) {
			System.out.print(node.val + " ");
			if(node.left != null) {
				sequence(node.left);
			}
			if(node.right != null) {
				sequence(node.right);
			}
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
		
		SerializeBinaryTrees sbt = new SerializeBinaryTrees();
		String ss = sbt.Serialize(root);
		System.out.println(ss);
		
		TreeNode node = sbt.Deserialize(ss);
		sbt.sequence(node);
	}
	

}
