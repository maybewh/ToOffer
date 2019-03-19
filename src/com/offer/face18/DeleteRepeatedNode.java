package com.offer.face18;

import java.time.format.TextStyle;

/**
 * 删除重复的结点
 * 在一个排序的链表中，如何删除重复的节点
 * @author admin
 *
 */
public class DeleteRepeatedNode {
	
	public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead == null)
			return null;
		
		ListNode pPreNode = null;
		ListNode tempNode = pHead;
		
		while(tempNode != null) {
			boolean needDelete = false;
			ListNode pNext = tempNode.next;
			if(pNext != null && pNext.val == tempNode.val) {
				needDelete = true;
			}
			if(!needDelete) {
				pPreNode = tempNode;
			}else {
				while(tempNode.next != null && tempNode.val == tempNode.next.val) {
					tempNode = tempNode.next;
				}
				
				if(pPreNode == null) {//头部有重复
					pHead = tempNode.next;
				}else {
					pPreNode.next = tempNode.next;//关键点，由于pPreNode指向的引用就是pHead链表中节点的引用，故是一致的
				}
				
			}
			tempNode = tempNode.next;
		}
		return pHead;

    }
	
	public static void main(String[] args) {
		ListNode ll = new ListNode(6, null);
		ListNode first = new ListNode(5, ll);
		ListNode second = new ListNode(4,first);
		ListNode third = new ListNode(4,second);
		ListNode fourth = new ListNode(3,third);
		ListNode fifth = new ListNode(3,fourth);
		ListNode sixth = new ListNode(2,fifth);
		ListNode seventh = new ListNode(1,sixth);
		
		DeleteRepeatedNode dr = new DeleteRepeatedNode();
		ListNode result = dr.deleteDuplication(seventh);
		ListNode temp = result;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
