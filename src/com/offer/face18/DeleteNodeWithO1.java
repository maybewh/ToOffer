package com.offer.face18;

/**
 * ��Ŀ1����O��1����ʱ����ɾ������ڵ�
 * @author admin
 *
 */
public class DeleteNodeWithO1 {
	
	/**
	 * ����Ҫɾ���Ľ��i����һ������ֵ��ֵ��i��Ȼ��ɾ��i����һ���ڵ�
	 * ����ɾ��������β�ڵ㣬��ʱ�临�Ӷ�ΪO(n)�����ܴ��ڽ�㲻�������е����
	 * @param pListHead
	 * @param pToBeDeleted
	 */
	void deleteNode(ListNode pListHead,ListNode pToBeDeleted) {
		
		//ֻ��һ���ڵ�
		if(pListHead == pToBeDeleted) {
			pListHead = null;
		}
		//����β�ڵ�
		else if(pToBeDeleted.next != null) {
		    ListNode nextNode = pToBeDeleted.next;
		    ListNode pointNextNode = nextNode.next;
		    pToBeDeleted.val = nextNode.val;
		    pToBeDeleted.next = pointNextNode;
		}
		//�ж���ڵ㣬ɾ��β�ڵ�
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
