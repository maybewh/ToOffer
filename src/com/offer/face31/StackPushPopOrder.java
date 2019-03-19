package com.offer.face31;

import java.util.Stack;

/**
 * 
 * @author admin
 *
 */
public class StackPushPopOrder {
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		
		if(pushA == null || popA == null || pushA.length <= 0 || popA.length <= 0){
			return false;
		}
		
		Stack<Integer> aux  = new Stack<>();
		
		int indexA = 0;
		int indexB = 0;
		
		while(indexA < pushA.length && indexB < popA.length) {
			aux.push(pushA[indexA]);
			while(!aux.empty() && aux.peek() == popA[indexB]) {
				aux.pop();
				indexB++;
			}
			indexA++;
		}
		
		return aux.empty();  
    }
	
	public static void main(String[] args) {
		
		int push[] = {1, 2, 3, 4, 5};
	    int pop[] = {4, 5, 3, 2, 1};
	    
	    StackPushPopOrder sppo = new StackPushPopOrder();
	    System.out.println(sppo.IsPopOrder(push, pop));
	}
}
