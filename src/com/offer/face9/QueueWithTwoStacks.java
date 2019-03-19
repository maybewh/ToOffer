package com.offer.face9;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 题目：用两个栈实现队列。队列的声明如下：请实现它的两个函数appendTail和deleteHead,
 *    分别完成在队列尾部插入节点和在队列头部删除节点的功能
 * @author admin
 *
 */
public class QueueWithTwoStacks {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //思路：在添加节点进去时，添加到stack1，当删除节点时，先判断stack2是否为空，若为空，则把stack1
    //中所有元素压入stack2中，若不为空，则直接从中取出。则满足先进先出的要求。
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
