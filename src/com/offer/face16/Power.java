package com.offer.face16;

/**
 * 数值的整数次方--考虑基数为0和负数，指数为0和负数的情况
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
	 * 改进的powerWithUnsigned 时间复杂度降为了O(logn)
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
