package com.offer.face5;

/**
 * ������5���滻�ո�
 * ��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"���������롰We are happy.����
 * 			�������We%20are%20happy.��
 * @author admin
 *
 */
public class ReplaceSpaces {
	
	/**
	 * ˼·��ʱ�临�Ӷ�Ϊo(n),�����ȱ���һ���ַ�������������ͳ�Ƴ��ַ����пո�����������ɴ˼�����滻֮����ܳ��ȡ�
	 *   ÿ�滻һ���ո񣬳�������2������滻�Ժ��ַ����ĳ��ȵ���ԭ���ĳ��ȼ���2���Կո���Ŀ��
	 *   
	 *   ����׼������ָ�룺P1��P2.P1ָ��ԭʼ�ַ�����ĩβ����P2ָ���滻֮����ַ�����ĩβ��
	 * ��������������ǰ�ƶ�ָ��P1���������ָ����ַ����Ƶ�P2ָ���λ�ã�ֱ��������һ���ո�Ϊֹ�����ν��У�
	 * ֱ��p1��p2ָ��ͬһ��λ�ã������еĿո��Ѿ��滻���
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
		//1.��������ַ�����ĳ���
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
