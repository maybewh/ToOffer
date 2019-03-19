package com.offer.face30;

import java.util.Stack;

/**
 * ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min������
 *  �ڸ�ջ�У�����min��push����pop��ʱ�临�Ӷȶ���O(1)
 * @author admin
 *
 */
public class MinFunctionInStack {
	
	Stack<Integer> data = new Stack<>();
	Stack<Integer> min = new Stack<>();
	
	public void push(int node) {
		
		data.push(node);
        if(min.isEmpty()) {	
        	min.push(node);
        }else {
        	if(node < min()) {
        		min.push(node);
        	}else {
        		min.push(min());
        	}
        }
        
    }
    
    public void pop() {
        data.pop();
        min.pop();
    }
    
    public int top() {
    	return data.peek();
    }
    
    public int min() {
    	return min.peek();
    }
}
