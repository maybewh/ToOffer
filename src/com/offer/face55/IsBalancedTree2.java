package com.offer.face55;

import com.offer.face26.TreeNode;

/**
 * ÿ���ڵ�ֻ����һ�εĽⷨ
 *  ��������ú�������ķ�ʽ������������ÿ���ڵ㣬��ô�ڱ�����һ���ڵ�֮ǰ���Ǿ��Ѿ���������������������
 *  ֻҪ�ڱ���ÿ���ڵ��ʱ�򣬼�¼�������(ĳһ�ڵ����ȵ�������Ҷ�ڵ��·������)
 * @author admin
 *
 */
public class IsBalancedTree2 {
	
	int depth = 0;
	int leftDepth = 0;
	int rightDepth = 0;
	
	/**
	 * �������
	 * @param root
	 * @param depth
	 * @return
	 */
	 public boolean isBalanced(TreeNode root,DepthHolder depthHolder) {
		
		if(root == null) {
			depthHolder.depth = 0;
			return true;
		}
		
		DepthHolder leftHolder = new DepthHolder();
		DepthHolder rightHolder = new DepthHolder();
		if(isBalanced(root.left,leftHolder) && isBalanced(root.right,rightHolder)) {
			int diff = leftHolder.depth - rightHolder.depth;
			if(diff <= 1 || diff >= -1) {
				depthHolder.depth = 1 + (leftHolder.depth > rightHolder.depth ? leftHolder.depth : rightHolder.depth);
				return true;
			}
		}
		
		return false;
		 
	 }
	 
	 public static class DepthHolder {
	        int depth;
	  }
	 
}
