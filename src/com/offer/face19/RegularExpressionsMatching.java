package com.offer.face19;

/**
 * 正则表达式匹配
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 *  而‘*’表示他前面的字符可以出现任意次
 * @author admin
 *
 */
public class RegularExpressionsMatching {
	public boolean match(char[] str, char[] pattern)
    {	
		if(str == null || pattern == null) {
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str,strIndex,pattern,patternIndex);
    }

	private boolean matchCore(char[] str,int strIndex, char[] pattern,int patternIndex) {
		 if (strIndex == str.length && patternIndex == pattern.length)   // 同时结束
	            return true;        
	     if (strIndex < str.length && patternIndex >= pattern.length)     // pattern 先结束
	            return false;
	   

	     if (patternIndex < pattern.length - 1) {
	    	//分为两种情况，第一种：第二个字符不是* 和 第二字符是*
	 		if(pattern[patternIndex + 1] == '*') {
	 			if((strIndex < str.length) && (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex < str.length))){
	 				return  //模式不动
	 						matchCore(str, strIndex + 1, pattern, patternIndex) ||
	 						//模式向前走2位
	 						matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
	 						//ignore
	 						matchCore(str, strIndex, pattern, patternIndex + 2);
	 			}else {
	 				//0到多位，此处忽略* 前面的字符
	 				return matchCore(str, strIndex, pattern, patternIndex + 2);
	 			}
	 		}
	 		
	     }
		if((strIndex < str.length) && (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex < str.length))){
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String a ="";
		String b = ".";
		RegularExpressionsMatching r = new RegularExpressionsMatching();
		System.out.println(a.toCharArray().length);
		System.out.println(r.match(a.toCharArray(), b.toCharArray()));
	}
	
}
