package com.offer.face50;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @author admin
 *
 */
public class FirstNotRepeatingChar {
	/**
	 * 思路：遍历
	 * 时间有点长
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
