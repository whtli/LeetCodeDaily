package it101.isSymmetric;

/**
 * @author :
 * @2020/4/4 9:10
 * @title :
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // �� 1 -- �ݹ�
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val)&& (isMirror(t1.left, t2.right))&&(isMirror(t1.right, t2.left));
    }
}
