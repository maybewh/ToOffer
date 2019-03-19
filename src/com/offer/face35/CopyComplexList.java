package com.offer.face35;

import java.util.HashMap;
import java.util.Map;

/**
 * ������35����������ĸ���
 *    ��Ŀ������һ����������(ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬
 *        ��һ������ָ��ָ������һ���ڵ�)�����ؽ��Ϊ���ƺ��������head.(ע�⣬���
 *         ������벻Ҫ���ز����е� �ڵ����ã������������ֱ�ӷ��ؿ�)
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
