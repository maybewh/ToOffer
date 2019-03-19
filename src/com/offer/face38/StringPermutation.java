package com.offer.face38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *  �ַ���������
 * ��Ŀ������һ���ַ�������ӡ�����ַ����ַ����������С�
 *    �磺�����ַ���abc,���ӡ�����ַ�a��b��c�������г����������ַ���abc��acb��bac��bca��cab��cba
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
	 * @param strs �ַ�����
	 * @param start ���н�������ʼλ��
	 * @param end ��start��ʼ������ַ��������ĵط�
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
