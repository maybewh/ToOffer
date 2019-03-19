package com.offer.face35;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35：复杂链表的复制
 *    题目：输入一个复杂链表(每个节点中有节点值，以及两个指针，一个指向下一个节点，
 *        另一个特殊指针指向任意一个节点)，返回结果为复制后复杂链表的head.(注意，输出
 *         结果中请不要返回参数中的 节点引用，否则判题程序直接返回空)
 * @author admin
 *
 */
public class CopyComplexList {
	
	/**
	 * 
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead)
    {	
		if(pHead == null)
			return null;
		
		Map<RandomListNode,RandomListNode> map = new HashMap<>();
		
		RandomListNode temp = pHead;

		while(temp != null) {
			RandomListNode returnHead = new RandomListNode(temp.label);
			map.put(temp, returnHead);
			temp = temp.next;
		}
		
		RandomListNode temp2 = pHead;
		while(temp2 != null) {
			RandomListNode copyNode = map.get(temp2);
			copyNode.next = map.get(temp2.next);
			copyNode.random = map.get(temp2.random);
			
			temp2 = temp2.next;
		}
		return map.get(pHead);
        
    }
}
