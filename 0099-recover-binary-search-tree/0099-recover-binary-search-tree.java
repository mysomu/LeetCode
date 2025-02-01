/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void inorder(TreeNode curr){
        if(curr==null)
            return;
        inorder(curr.left);
        if(prev != null && prev.val> curr.val){
            if(first==null){
                first = prev;
            }
            second = curr;
        }
        prev = curr;
        inorder(curr.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
}