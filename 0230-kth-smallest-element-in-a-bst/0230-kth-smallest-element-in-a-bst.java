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
    private int solve(TreeNode root, int[] k) {
        if (root == null)
            return 0;

        int left = solve(root.left, k); // Traverse left subtree

        if (left != 0) // If kth smallest element is found in the left subtree, return it
            return left;

        k[0] -= 1; // Decrement k since we are visiting a node

        if (k[0] == 0) // If k becomes 0, we have found the kth smallest element
            return root.val;

        int right = solve(root.right, k); // Traverse right subtree

        return right; // Return the result from the right subtree
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] kArr = {k}; // Wrap k in an array to make it mutable
        return solve(root, kArr); // Start the recursive process
    }
}
