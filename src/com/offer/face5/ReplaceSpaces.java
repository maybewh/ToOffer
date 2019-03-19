package com.offer.face5;

/**
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 			则输出“We%20are%20happy.”
 * @author admin
 *
 */
public class ReplaceSpaces {
	
	/**
	 * 思路：时间复杂度为o(n),我们先遍历一次字符串，这样就能统计出字符串中空格的总数，并由此计算出替换之后的总长度。
	 *   每替换一个空格，长度增加2，因此替换以后字符串的长度等于原来的长度加上2乘以空格数目。
	 *   
	 *   首先准备两个指针：P1和P2.P1指向原始字符串的末尾。而P2指向替换之后的字符串的末尾。
	 * 接下来，我们向前移动指针P1，逐个把它指向的字符复制到P2指向的位置，直到碰到第一个空格为止。依次进行，
	 * 直到p1和p2指向同一个位置，则所有的空格已经替换完成
	 * @param str
	 * @return
	 */
	public char[] replaceSpace(String str) {
		
		if(str == null || str.length() == 0) {
			return null;
		}
		
		char[] strC = str.toCharArray();
		char[] strA = null;
		int spaceNum = 0;
		//1.计算出新字符数组的长度
		for (int i = 0; i < strC.length; i++) {
			char c = strC[i];
			if(c == ' ') {
				spaceNum++;
			}
		}
		strA = new char[strC.length + 2 * spaceNum];
		
		int p1 = strC.length - 1;
		int p2 = strA.length - 1;
		
		int end = p1;
		while(p1 != p2) {
			while(strC[p1] != ' ') {
				p1--;
			}
			for(int i = end; i >= p1 + 1 ; i --) {
				strA[p2--] = strC[i];
			}
			strA[p2] = '0';
			strA[--p2] = '2';
			strA[--p2] = '%';
			p2--;
			p1--;
			end = p1;
		}
		for(int i = 0;i <=p1; i++) {
			strA[i] = strC[i];
		}
		return strA;
		
	}
	
	public static void main(String[] args) {
		ReplaceSpaces res = new ReplaceSpaces();
		System.out.println(res.replaceSpace("We are happy"));
		System.out.println(res.replaceSpace("hello world"));
		System.out.println(res.replaceSpace(" helloworld"));
		System.out.println(res.replaceSpace("helloworld "));
		System.out.println(res.replaceSpace("hello  world"));
		System.out.println(res.replaceSpace(" "));
		System.out.println(res.replaceSpace("helloworld"));
		System.out.println(res.replaceSpace("   "));
	}
}
