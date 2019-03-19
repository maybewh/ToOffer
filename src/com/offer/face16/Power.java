package com.offer.face16;

/**
 * ��ֵ�������η�--���ǻ���Ϊ0�͸�����ָ��Ϊ0�͸��������
 * @author admin
 *
 */
public class Power {
	
	public double power(double base, int exponent) {
        double result = 0.00;
		if(exponent == 0) 
			return 1;
		if(exponent < 0) {
			result = 1 / powerWithUnsigned(base, Math.abs(exponent));
		}else {
			result = powerWithUnsigned(base, exponent);
		}
		
		
		return result;
	}
	
	/**
	 * 
	 * @param base
	 * @param exponet
	 * @return
	 */
	public double powerWithUnsigned(double base,int exponent) {
		
		double result = 1;
		if(exponent > 0) {
			for(int i = 0; i < exponent;i++) {
				result = result * base;
			}
		}else {
			return 0;
		}
		
		return result;
	}
	
	/**
	 * �Ľ���powerWithUnsigned ʱ�临�ӶȽ�Ϊ��O(logn)
	 * @param args
	 */
	public double powerWithUnsignedLogn(double base,int exponent) {
		double result = 1.00;
		if(exponent > 0) {
			result = powerWithUnsignedLogn(base, exponent >> 1);
			result *= result;
			if((exponent & 0x1) == 1) {
				result *= base;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Power p = new Power();
		System.out.println(p.power(2, 3));
	}
}
