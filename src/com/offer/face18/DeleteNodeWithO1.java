package com.offer.face18;

/**
 * 题目1：在O（1）的时间内删除链表节点
 * @author admin
 *
 */
public class DeleteNodeWithO1 {
	
	/**
	 * 将需要删除的结点i的下一个结点的值赋值给i，然后删除i的下一个节点
	 * 但是删除的若是尾节点，则时间复杂度为O(n)，可能存在结点不在链表中的情况
	 * @param pListHead
	 * @param pToBeDeleted
	 */
	void deleteNode(ListNode pListHead,ListNode pToBeDeleted) {
		
		//只有一个节点
		if(pListHead == pToBeDeleted) {
			pListHead = null;
		}
		//不是尾节点
		else if(pToBeDeleted.next != null) {
		    ListNode nextNode = pToBeDeleted.next;
		    ListNode pointNextNode = nextNode.next;
		    pToBeDeleted.val = nextNode.val;
		    pToBeDeleted.next = pointNextNode;
		}
		//有多个节点，删除尾节点
		else {
			ListNode tempNode = pListHead;
			while(tempNode.next != pToBeDeleted) {
				tempNode = tempNode.next;
			}
			tempNode.next = null;
		}
	}
	
	public static void main(String[] args) {
		ListNode first = new ListNode(1, null);
		/*ListNode second = new ListNode(2,first);
		ListNode third = new ListNode(3,second);
		ListNode fourth = new ListNode(4,third);*/
		
		DeleteNodeWithO1 dl = new DeleteNodeWithO1();
		dl.deleteNode(first, first);
		
		ListNode temp = first;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
