package com.offer.face6;

import java.util.Stack;

//从尾到头打印链表的所有元素
public class PrintListInReversedOrder {
	//思路：从头到尾遍历链表中的元素并将其放入到栈中
	void printListReverseingly_Iteratively(Node head) {
		if(head == null)
			return;
		Stack<Integer> stack = new Stack<>();
		Node firstNode = head;
		while(firstNode != null) {
			stack.push(firstNode.value);
			firstNode = firstNode.next;
		}
		int j = stack.size();
		for (int i = 0; i < j; i++) {
			System.out.print(stack.pop() + " ");
			
		}
	}
	
	
	class Node{
		Integer value;
		Node next;
		
		Node(Integer value,Node next){
			this.value = value;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		PrintListInReversedOrder pl = new PrintListInReversedOrder();
		Node node5 = pl.new Node(5,null);
		Node node4 = pl.new Node(4,node5);
		Node node3 = pl.new Node(3,node4);
		Node node2 = pl.new Node(2,node3);
		Node node1 = pl.new Node(1,node2);
		pl.printListReverseingly_Iteratively(node1);
	}
}
