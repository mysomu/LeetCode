/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    class Pair {
        int val;
        int x;
        int y;

        Pair(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    PriorityQueue<Pair> pq;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.x != b.x)
                return a.x - b.x;
            else if (a.y != b.y)
                return a.y - b.y;
            else
                return a.val - b.val;
        });
        dfs(root, 0, 0);
        // while(!pq.isEmpty()){
        // System.out.println(pq.peek().val+"\t"+pq.poll().x);
        // }
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Pair poll = pq.poll();
            list.add(poll.val);
            while (!pq.isEmpty() && pq.peek().x == poll.x) {
                list.add(pq.poll().val);
            }
            result.add(list);
        }
        return result;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null)
            return;
        pq.offer(new Pair(root.val, x, y));
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }
}