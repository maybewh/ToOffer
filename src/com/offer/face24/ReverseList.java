package com.offer.face24;

import com.offer.face23.ListNode;

/**
 * 反转链表。输入一个链表，反转链表后，输出反转链表后的表头
 * @author admin
 *
 */
public class ReverseList {
	
    public ListNode reverseList(ListNode head) {
    	if(head == null)
    		return null;
    	if(head.next == null)
    		return head;
    	
    	//当前结点的前一个节点，当前节点，当前节点的下一个节点
    	ListNode prevNode = head;
    	ListNode current = head.next;
    	ListNode nextNode = null;
    	if(current.next != null)
    		nextNode = current.next;
    	
    	current.next = prevNode;
    	prevNode.next = null;
    	
    	while(nextNode.next != null) {
    		prevNode = current;
    		current = nextNode;
    		nextNode = nextNode.next;
    		current.next = prevNode;
    	}
    	
    	nextNode.next = current;
    	
		return nextNode;
    }
    
    public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		ListNode temp = first;
		while(temp != null) {
			System.out.print(temp.val +" ");
			temp = temp.next;
		}
		
		
		ReverseList rl = new ReverseList();
		ListNode result = rl.reverseList(first);
		
		
		
		System.out.println();
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
