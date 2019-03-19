package com.offer.face26;

/**
 * �����ӽṹ��
 * 	  �������ö�����A,B,�ж�B�ǲ���A���ӽṹ��ps:����Լ��������������һ�������ӽṹ��
 * @author admin
 *
 */
public class SubstructInTree {
	
	//ʹ�õݹ�������
	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		
		boolean result = false;
		if(root1 == null || root2 == null)
			return false;
		
		//���
		if(equal(root1, root2)) {
			result = doesTree1HaveTree2(root1, root2);
		}
		//���ȣ�����
		if(!result) {
			result = hasSubtree(root1.left, root2);
		}
		//���ȣ��Һ���
		if(!result)
			result = hasSubtree(root1.right, root2);
		
		return result;
		
	}
	
	boolean doesTree1HaveTree2(TreeNode node1,TreeNode node2) {
		if(node2 == null)
			return false;
		if(node1 == null)
			return false;
        
		if(!equal(node1,node2))
			return false;
		
		return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
		
	}
	
	boolean equal(TreeNode num1,TreeNode num2) {
		if(num1.val == num2.val)
			return true;
		return false;
	}
}
