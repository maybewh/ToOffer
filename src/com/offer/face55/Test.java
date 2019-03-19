package com.offer.face55;

import java.util.ArrayList;

public class Test {
	 public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	        if(array == null || array.length == 0){
	            return;
	        }
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int i = 0; i < array.length; i++){
	            if(list.contains(array[i])){
	                list.remove(Integer.valueOf(array[i]));
	            }else{
	                list.add(array[i]);
	            }
	        }
	        System.out.println(list.get(0));
	        System.out.println(list.get(1));
	 }
	 
	 public static void main(String[] args) {
		Test test = new Test();
		test.FindNumsAppearOnce(new int[] {2,4,3,6,3,2,5,5}, new int[] {0,0}, new int[] {0,0});
	}
}
