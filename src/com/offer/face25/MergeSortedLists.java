package com.offer.face25;

import com.offer.face23.ListNode;

/**
 * 合并链表：输入两个单调递增的链表，输出两个链表合成后的链表，合并后的链表满足单调不减性
 * @author admin
 *
 */
public class MergeSortedLists {
	
	public ListNode merge(ListNode list1,ListNode list2) {
    	if(list1 == null && list2 == null)
    		return null;
    	
    	if(list1 == null)
    		return list2;
    	
    	if(list2 == null)
    		return list1;
    	
    	ListNode temp = list1;
    	if(list1.val > list2.val) {
    		list1 = list2;
    		list2 = list2.next;
    		list1.next = temp;	
    	}
    	
    	ListNode firstListNode = list1;
    	ListNode secondListNode = list2;
    	ListNode firstListCurrent = null;
    	ListNode secondListCurrent = null;
    	
    	
    	//将链表2合并到链表1上
    	flag:
    	while(firstListNode != null && secondListNode != null) {
    		
    		while(firstListNode.val <= secondListNode.val ) {
    			if(firstListNode.next == null) {
    				break flag;
    			}else if(firstListNode.next.val <= secondListNode.val) {
    				firstListNode = firstListNode.next;
    			}
    			break;
    		}
    		
    		firstListCurrent = firstListNode;
    		secondListCurrent = secondListNode;
    		
    		secondListNode = secondListNode.next;
    		
    		
    		secondListCurrent.next = firstListCurrent.next;
    		firstListCurrent.next = secondListCurrent;
    		firstListNode = secondListCurrent;
    	}
    	
    	if(firstListNode.next == null && secondListNode != null) {
    		firstListNode.next = secondListNode;
    	}
    	
		return list1;
    }
    
    public static void main(String[] args) {
    	
    	ListNode first = new ListNode(1);
		ListNode third = new ListNode(3);
		ListNode fifth = new ListNode(5);
		
		ListNode second = new ListNode(2);
		ListNode fourth = new ListNode(4);
		ListNode sixth = new ListNode(6);
		ListNode seventh = new ListNode(7);
		first.next = third;
		third.next = fifth;
		
		
		second.next = fourth;
		fourth.next = sixth;
		sixth.next = seventh;
		
		MergeSortedLists ms = new MergeSortedLists();
		ListNode result = ms.merge(first, second);
		
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
