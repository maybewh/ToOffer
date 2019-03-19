package com.offer.face41;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * �������е���λ��
 * ��Ŀ����εõ�һ���������е���λ����
 *   ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 *   ������������ж���ż������ֵ����ô ��λ������������ֵ����֮���м���������ƽ��ֵ��
 *   
 *   ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 * @author admin
 *
 */
public class StreamMedian {
	
	private int count = 0;
	private Queue<Integer> minHeap = new PriorityQueue<>();
	private Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
		
	});
	/**
	 * �����е�����Ԫ��С����С���е�Ԫ��
	 * @param num
	 */
	public void Insert(Integer num) {
	    if(count % 2 == 0) {
	    	maxHeap.offer(num);
	    	int filter = maxHeap.poll();
	    	minHeap.offer(filter);
	    }else {
	    	minHeap.offer(num);
	    	int filter = minHeap.poll();
	    	maxHeap.offer(filter);
	    }
	    count++;
    }

    public Double GetMedian() {
    	Double result = 0.0;
    	if(count % 2 == 0) {
    		result = (double) (maxHeap.peek() + minHeap.peek()) / 2;
    	}else {
    		result = (double)minHeap.peek();
    	}
		return result; 
    }
}
