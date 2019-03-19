package com.offer.face17;

/**
 * ��ӡ��1��n�����ֵ
 * ��Ŀ����������n����˳���ӡ��1������nλʮ��������
 *   ���磺����3�����ӡ��1��2��3һֱ������3λ��999	
 * @author admin
 *
 */
public class Print1ToMaxOfNDigits {
	
	/**
	 * ����n���ܴܺ󣬻ᳬ��int long����ʾ�������������ַ��� ��ģ������
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
     * ȥ��ǰ���0
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
