package com.offer.face20;

/**
 * 表示数值的字符串
 * @author admin
 *
 */
public class NumericStrings {
	
	int index = 0;
	
	public boolean isNumeric(char[] str) {
		
		if(str == null || str.length <= 0)
			return false;
		
		boolean numeric = scanInteger(str,index);
		
		if(index < str.length && str[index] == '.') {
			index++;
			numeric = scanUnsignedInteger(str,index) || numeric;
		}
		
		if(index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			numeric = scanInteger(str, index + 1) && numeric;
		}
		if(numeric && index == str.length) {
			return true;
		}
		return false;  
    }
	
	/**
	 * 判断是否为正整数
	 * @param str
	 * @param index2
	 * @return
	 */
	private boolean scanUnsignedInteger(char[] str, int index2) {
		index = index2;
		while(index < str.length && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		if(index > index2) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为整数
	 * @param str
	 * @param index2
	 * @return
	 */
	private boolean scanInteger(char[] str, int index2) {
		index = index2;
		if(index < str.length &&(str[index] == '+' || str[index] == '-')) {
			index++;
		}
		
		return scanUnsignedInteger(str, index);
	}
	
	public static void main(String[] args) {
		NumericStrings ns = new NumericStrings();
		System.out.println(ns.isNumeric("12e".toCharArray()));
	}
}
