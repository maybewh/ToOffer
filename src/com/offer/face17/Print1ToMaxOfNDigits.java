package com.offer.face17;

/**
 * 打印从1到n的最大值
 * 题目：输入数字n，按顺序打印从1到最大的n位十进制数。
 *   比如：输入3，则打印出1、2、3一直到最大的3位数999	
 * @author admin
 *
 */
public class Print1ToMaxOfNDigits {
	
	/**
	 * 由于n可能很大，会超过int long所表示的数，可以用字符串 来模拟数字
	 * 
	 * @param n
	 */
	public void print1ToMaxOfNDigits(int n) {
		if(n <= 0)
			return;
		
		StringBuffer number = new StringBuffer();
		
		for(int i = n; i> 0;i--) {
			number.append('0');
		}
		
		while(!increment(number)) {
			print(number);
		}
	}
	
    private boolean increment(StringBuffer number) {
    	boolean isOverflow = false;
    	int takeOver = 0;
    	int n = number.length() - 1;
    	
    	for(int i = n; i >= 0 ; i --) {
    		int nSum = number.charAt(i) - '0' + takeOver;
    		
    		if(i == n) {
    			nSum++;
    		}
    		
    		if(nSum >= 10) {
    			if(i == 0) {
    				isOverflow = true;
    			}else {
    				nSum -= 10;
        			takeOver = 1;
        			number.setCharAt(i, (char)('0' + nSum));
    			}
    		}else {
    			number.setCharAt(i, (char)('0' + nSum));
    			break;
    		}
    	}
    	
		return isOverflow;
	}
	
    /*
     * 去掉前面的0
     */
	private void print(StringBuffer number) {
		boolean isBeginning = true;
		int nLength = number.length();
		
		for(int i = 0 ; i < nLength;i++) {
			if(isBeginning && number.charAt(i) != '0') {
				isBeginning = false;
			}
			if(!isBeginning) {
				System.out.print(number.charAt(i));
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Print1ToMaxOfNDigits pn = new Print1ToMaxOfNDigits();
		pn.print1ToMaxOfNDigits(4);
	}
}
