package com.offer.face55;

import java.util.ArrayList;
import java.util.List;

import com.offer.face26.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
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
