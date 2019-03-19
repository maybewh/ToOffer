package com.offer.face50;

import java.util.ArrayList;

public class FirstCharacterInStream {
	
	int[] count = new int[256];
	ArrayList<Character> list = new ArrayList<>();
	
	public void insert(char ch) {
		list.add(ch);
		count[ch]++;
	}
	
	public char firstAppearOnce() {
		
		for(int i = 0;i < list.size();i++) {
			if(count[list.get(i)] == 1)
				return list.get(i);
		}
		
		return '#';
		
	}
}
