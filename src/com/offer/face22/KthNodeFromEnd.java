package com.offer.face22;

public class KthNodeFromEnd {
	
	public ListNode FindKthToTail(ListNode head,int k) {
		
		if(head == null || k <= 0) {
			return null;
		}
		int sum = 0;
		ListNode temp = head;
		while(temp != null) {
			sum++;
			temp = temp.next;
		}
		int j = sum - k + 1;
		if(j <= 0)
			return null;
		
		temp = head;
		for(int i = 1; i < j; i++) {
			temp = temp.next;
		}
		return temp;
		
	}
}
