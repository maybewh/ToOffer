package com.offer.face61;

import java.util.Arrays;

/**
 * ÆË¿ËÅÆË³Ðò
 * @author admin
 *
 */
public class ContinousCard {
	public boolean isContinuous(int [] numbers) {
       
		if(numbers == null || numbers.length < 1) {
			return false;
		}
		Arrays.sort(numbers);
 
        int zeroCount = 0;
        int before = numbers[0];
        int after = numbers[1];
        for(int i = 0; i < numbers.length;i ++) {
        	if(numbers[i] == 0) {
        		zeroCount++;
        	}else {
        		if(i < numbers.length - 1) {
        			before = numbers[i];
        			after = numbers[i + 1];
        			if(after - before == 0 || (after - before > 1 && after - before - 1 > zeroCount)) {
        				return false;
        			}else {
        				 if(after - before - 1 <= zeroCount){
                             zeroCount -= after - before - 1;
                         }
        			}
        		}
        	}
        }
		return true;
    }
	
	public static void main(String[] args) {
		ContinousCard cc = new ContinousCard();
		System.out.println(cc.isContinuous(new int[] {1,0,0,1,0}));
	}
}
