package com.offer.face9;

import java.util.Stack;

/**
 * ������ջʵ�ֶ���
 * ��Ŀ��������ջʵ�ֶ��С����е��������£���ʵ��������������appendTail��deleteHead,
 *    �ֱ�����ڶ���β������ڵ���ڶ���ͷ��ɾ���ڵ�Ĺ���
 * @author admin
 *
 */
public class QueueWithTwoStacks {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //˼·������ӽڵ��ȥʱ����ӵ�stack1����ɾ���ڵ�ʱ�����ж�stack2�Ƿ�Ϊ�գ���Ϊ�գ����stack1
    //������Ԫ��ѹ��stack2�У�����Ϊ�գ���ֱ�Ӵ���ȡ�����������Ƚ��ȳ���Ҫ��
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() throws Exception{
        
        if(stack2.empty()){
            while(!stack1.empty()) {
			 stack2.push(stack1.pop());
		    }
        }
		if(!stack2.empty()) {
			return stack2.pop();
		}
        throw new Exception("queue is empty");
    }
	
}
