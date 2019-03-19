package com.offer.face41;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？
 *   如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *   如果从数据流中读出偶数个数值，那么 中位数就是所有数值排序之后中间两个数的平均值。
 *   
 *   我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
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
	 * 最大堆中的所有元素小于最小堆中的元素
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
