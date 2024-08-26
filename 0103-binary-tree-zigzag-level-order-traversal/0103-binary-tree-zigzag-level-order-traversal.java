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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int i=1;
        List<Integer> subans= new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr==null){
                if(i%2==0){
                    Collections.reverse(subans);
                    ans.add(subans);
                }else{
                    ans.add(subans);
                }
                i++;
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    subans=new ArrayList<>();
                }
            }else{
                subans.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
        
    }
}