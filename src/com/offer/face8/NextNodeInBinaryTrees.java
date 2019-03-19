package com.offer.face8;

/**
 * 二叉树的下一个节点
 * 题目：给定一个二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 * @author admin
 *
 */
public class NextNodeInBinaryTrees {
	
	//思路：
	public TreeLinkNode getNext(TreeLinkNode pNode) {
		TreeLinkNode temp = pNode;
		//1.该节点有右孩子,找右子树的左孩子
		if(temp.right != null) {
			temp = temp.right;
			while(temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}
        //2.该节点没有右孩子,回溯到该节点的根点上		
		while(temp.next != null) {
			TreeLinkNode test = temp;
			temp = temp.next;
			if(temp.left == test) {
				return temp;
			}
		}
		return null;
	}
}
