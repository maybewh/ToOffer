package com.offer.face4;

/**
 * ������4����ά�����еĲ���
 * ��Ŀ����һ����ά�����У�ÿһ�ж����մ����ҵ�����˳�����У�ÿһ�ж���
 *   �մ��ϵ��µĵ�����˳�����С������һ������������������һ����ά�����һ���������ж��������Ƿ��и�����
 * @author admin
 *
 */
public class FindInPartiallySortedMatrix_04 {
	
	/**
	 * ˼·�������Ͻǵ�����Ϊ��׼��ͨ���޳�ĳһ�л�ĳһ�н���Χ��С
	 *   1.������Ͻǵ����ֵ���Ҫ���ҵ����֣�����ҽ�����
	 *   2.�����Ͻǵ����ִ���Ҫ���ҵ����֣����޳�����
	 *   3.�����Ͻǵ�����С��Ҫ���ҵ����֣����޳�����
	 *   ����ʱ��1)�ҵ���ȵ�Ԫ�أ����ؼ���
	 *    2)numsΪ��(û��ֵ)ʱ������
	 * @param nums
	 * @return
	 */
	boolean find(int[][] nums,int find) {
		int[][] matrix = nums;
		boolean found  =false;
		
		if(matrix != null && matrix[0].length >= 0 && matrix.length >= 0) {
			int rows = matrix.length;
			int columns = matrix[0].length;
			System.out.println("�У�" + rows);
			System.out.println("�У�" + columns);
			
			int row = 0;
			int column = columns - 1;
			while(row < rows && column >= 0) {
				int compare = matrix[row][column];
				if(compare == find) {
					found = true;
					break;
				}else if(compare > find) {
					//�޳�һ��
					column--;
				}else {
					//�޳�һ��
					row++;
				}
			}
		}
		return found;
		
	}
	
	public static void main(String[] args) {
		int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
		FindInPartiallySortedMatrix_04 fp = new FindInPartiallySortedMatrix_04();
		System.out.println(fp.find(matrix, 7));
	}
}
