package com.offer.face19;

/**
 * ������ʽƥ��
 * ��Ŀ����ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
 *  ����*����ʾ��ǰ����ַ����Գ��������
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
		 if (strIndex == str.length && patternIndex == pattern.length)   // ͬʱ����
	            return true;        
	     if (strIndex < str.length && patternIndex >= pattern.length)     // pattern �Ƚ���
	            return false;
	   

	     if (patternIndex < pattern.length - 1) {
	    	//��Ϊ�����������һ�֣��ڶ����ַ�����* �� �ڶ��ַ���*
	 		if(pattern[patternIndex + 1] == '*') {
	 			if((strIndex < str.length) && (str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex < str.length))){
	 				return  //ģʽ����
	 						matchCore(str, strIndex + 1, pattern, patternIndex) ||
	 						//ģʽ��ǰ��2λ
	 						matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
	 						//ignore
	 						matchCore(str, strIndex, pattern, patternIndex + 2);
	 			}else {
	 				//0����λ���˴�����* ǰ����ַ�
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
