package com.offer.face50;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,
 * ����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 * @author admin
 *
 */
public class FirstNotRepeatingChar {
	/**
	 * ˼·������
	 * ʱ���е㳤
	 * @param str
	 * @return
	 */
	public int firstNotRepeatingChar(String str) {
		LinkedHashMap<Character, Integer> lsm = new LinkedHashMap<>();
		LinkedHashMap<Character, Integer> index = new LinkedHashMap<>();
		char[] cc = str.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			char c = cc[i];
			if(lsm.get(c) == null) {
				lsm.put(c, 1);
				index.put(c, i);
			}else {
				lsm.put(c,lsm.get(c)+1);
			}
		}
		
	  for (Entry<Character, Integer> c : lsm.entrySet()) {
		 if(c.getValue() == 1) {
			 return index.get(c.getKey());
		 }
	}
        return -1;
    }
	
	public static void main(String[] args) {
		FirstNotRepeatingChar fc = new FirstNotRepeatingChar();
		System.out.println(fc.firstNotRepeatingChar("google"));
	}
}
