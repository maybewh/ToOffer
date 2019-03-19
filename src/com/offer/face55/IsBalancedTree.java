package com.offer.face55;

import com.offer.face26.TreeNode;

public class IsBalancedTree {
	TreeDepth tp = new TreeDepth();
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        
        int leftDepth = tp.treeDepth(root.left);
        int rightDepth = tp.treeDepth(root.right);
        
        int diff = leftDepth - rightDepth;
        if(diff > 1 || diff < -1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}
