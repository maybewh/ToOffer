package com.offer.face23;

public class EntryNodeInListLoop {
	
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		ListNode meetNode = meetingNode(pHead);
		if(meetNode == null)
			return null;
		
		//得到环中结点个数
		int nodesInLoop = 1;
		ListNode pNode1 = meetNode;
		while(pNode1.next != meetNode) {
			nodesInLoop++;
			pNode1 = pNode1.next;
		}
		
		ListNode firstNode = pHead;
		ListNode secondNode = pHead;//第二个节点先移动nodesInLoop步
		
		for(int i = 0; i < nodesInLoop; i++) {
			secondNode = secondNode.next;
		}
		while(firstNode != secondNode) {
			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}
		
		return firstNode;
        
    }

	private ListNode meetingNode(ListNode pHead) {
		
		if(pHead == null)
			return null;
		
		ListNode pSlow = pHead.next;
		if(pSlow == null)
			return null;
		ListNode pFast = pSlow.next;
		
		while(pFast != null && pSlow != null) {
			if(pFast == pSlow) 
				return pFast;
			
			pSlow = pSlow.next;
			pFast = pFast.next;
			if(pFast.next != null)
				pFast = pFast.next;
		}
		
		return null;
	}
}
