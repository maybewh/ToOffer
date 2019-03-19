package com.offer.face24;

import com.offer.face23.ListNode;

/**
 * ��ת��������һ��������ת����������ת�����ı�ͷ
 * @author admin
 *
 */
public class ReverseList {
	
    public ListNode reverseList(ListNode head) {
    	if(head == null)
    		return null;
    	if(head.next == null)
    		return head;
    	
    	//��ǰ����ǰһ���ڵ㣬��ǰ�ڵ㣬��ǰ�ڵ����һ���ڵ�
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
