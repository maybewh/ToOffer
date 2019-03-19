package com.offer.face51;

/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
	/**
	 * 分治--递归
	 * @param array
	 * @return
	 */
	public int inversePairs(int [] array) {
		int length = array.length;
		int[] aux = new int[length];
		for (int i = 0; i < array.length; i++) {
			aux[i] = array[i];
		}
		int result = inverseParisCore(array,aux,0,length - 1);
		return result;
        
    }

	private int inverseParisCore(int[] array, int[] aux,int start, int end) {
		
		if(start == end) {
			aux[start] = array[start];
			return 0;
		}
		
		int middle = (end - start) / 2;
		
		int left = inverseParisCore(aux, array,start, start + middle);
		int right = inverseParisCore(aux, array,start + middle + 1, end);
		
		
		//i初始化为前半段最后一个数字的下标
		int i = start + middle;
		//j初始化为后半段最后一个数字的下标
		int j = end;
		
		int indexCopy = end;
		
		int count = 0;
		while(i >= start && j >= start + middle + 1) {
			if(array[i] > array[j]) {
				aux[indexCopy--] = array[i--];
				count += j - start - middle;
			}else {
				aux[indexCopy--] = array[j--];
			}
		}
		
		for(;i >= start;i --) {
			aux[indexCopy--] = array[i];
		}
		
		for(;j >= start + middle + 1;--j)
			aux[indexCopy--] = array[j];
		return left + right + count;
	}
	
	public static void main(String[] args) {
		InversePairs ip = new InversePairs();
		System.out.println(ip.inversePairs(new int[] {1,2,3,4,5,6,7,0}));
	}
}
