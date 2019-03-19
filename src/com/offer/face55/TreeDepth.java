package com.offer.face55;

import java.util.ArrayList;
import java.util.List;

import com.offer.face26.TreeNode;

/**
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * @author admin
 *
 */
public class TreeDepth {
	int depth = 0;
    public int treeDepth(TreeNode root) {
        if(root == null)
            return 0;
        List<TreeNode> list = new ArrayList<>();
        depth = 1;
        if(root.left != null){
            list.add(root.left);
        }
        if(root.right != null){
            list.add(root.right);
        }
        return getDepth(list);
    }
    
    public int getDepth(List<TreeNode> list){
        if(list == null || list.size() == 0)
            return depth;
         depth = depth + 1;
         List<TreeNode> aux = new ArrayList<>();
        for(int i = 0;i < list.size(); i++){
            TreeNode temp = list.get(i);
            if(temp.left != null){
                aux.add(temp.left);
            }
            if(temp.right != null){
                aux.add(temp.right);
            }
        }
        getDepth(aux);
        return depth;
    }
}
