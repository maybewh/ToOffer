package com.offer.face38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *  字符串的排列
 * 题目：输入一个字符串，打印出该字符中字符的所有排列。
 *    如：输入字符串abc,则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab、cba
 * @author admin
 *
 */
public class StringPermutation {
	
	ArrayList<String> result = new ArrayList<>();
	public ArrayList<String> Permutation(String str) {
		
		if(str == null || str.length() <= 0)
			return null;	
		permutationStr(str.toCharArray(),0,str.length() - 1);
		Collections.sort(result);
		return result;
	       
    }
	
	/**
	 * 
	 * @param strs 字符数组
	 * @param start 进行交换的起始位置
	 * @param end 从start开始到最后字符串结束的地方
	 */
	private void permutationStr(char[] strs,int start,int end) {
		
		if(start == end) {
			result.add(new String(strs));
		}else {
			for (int i = start; i <= end; i++) {
			  if(start == i || strs[i] != strs[start]) {
				  swap(strs,i,start);
				  permutationStr(strs, start + 1, end);
				  swap(strs,i,start);
			  }
				
			}
		}
	}
	
	private void swap(char[] strs, int i, int start) {
		char temp = strs[i];
		strs[i] = strs[start];
		strs[start] = temp;	
	}

	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		ArrayList<String> result = sp.Permutation("abc");
		for (String string : result) {
			System.out.println(string);
		}
	}
}
