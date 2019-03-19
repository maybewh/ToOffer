package com.offer.face18;

import java.time.format.TextStyle;

/**
 * ɾ���ظ��Ľ��
 * ��һ������������У����ɾ���ظ��Ľڵ�
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
				
				if(pPreNode == null) {//ͷ�����ظ�
					pHead = tempNode.next;
				}else {
					pPreNode.next = tempNode.next;//�ؼ��㣬����pPreNodeָ������þ���pHead�����нڵ�����ã�����һ�µ�
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
