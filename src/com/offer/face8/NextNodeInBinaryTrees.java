package com.offer.face8;

/**
 * ����������һ���ڵ�
 * ��Ŀ������һ�������������е�һ���ڵ㣬����ҳ�����������е���һ���ڵ㣿
 * ���еĽڵ�����������ֱ�ָ�������ӽڵ��ָ�룬����һ��ָ�򸸽ڵ��ָ��
 * @author admin
 *
 */
public class NextNodeInBinaryTrees {
	
	//˼·��
	public TreeLinkNode getNext(TreeLinkNode pNode) {
		TreeLinkNode temp = pNode;
		//1.�ýڵ����Һ���,��������������
		if(temp.right != null) {
			temp = temp.right;
			while(temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}
        //2.�ýڵ�û���Һ���,���ݵ��ýڵ�ĸ�����		
		while(temp.next != null) {
			TreeLinkNode test = temp;
			temp = temp.next;
			if(temp.left == test) {
				return temp;
			}
		}
		return null;
	}
}
