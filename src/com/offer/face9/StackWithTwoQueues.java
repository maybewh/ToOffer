package com.offer.face9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现一个栈,插入不为空的队列，移除时用另一个空队列存储其他不被移除的元素
 * @author admin
 *
 */
public class StackWithTwoQueues {
	
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();
	
	public void push(int val) {
		if(queue2.isEmpty()) {
			queue1.add(val);
		}else {
			queue2.add(val);
		}
	}
	
	public Integer pop() throws Exception {
		if(queue1.isEmpty() && queue2.isEmpty()) {
			throw new Exception("There is not an element.");
		}
		if(queue1.isEmpty()) {
			int size =  queue2.size();
			for(int i = 0;i < size; i++) {
				if(i == size - 1) {
					return queue2.poll();
				}else {
					queue1.add(queue2.poll());
				}
			}
		}else {
			int size =  queue1.size();
			for(int i = 0;i < size; i++) {
				if(i == size - 1) {
					return queue1.poll();
				}else {
					queue2.add(queue1.poll());
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		StackWithTwoQueues st = new StackWithTwoQueues();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.print(st.pop() +"-ok-");
		st.push(4);
		st.push(5);
		System.out.print(st.pop() +" ");
		System.out.print(st.pop() +" ");
		System.out.print(st.pop() +" ");
		System.out.print(st.pop() +" ");
	}
}
