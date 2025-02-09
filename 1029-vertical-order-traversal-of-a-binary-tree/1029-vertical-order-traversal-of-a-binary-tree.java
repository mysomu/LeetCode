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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>(); // Maintain sorted order of columns
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int col = current.col;

                levelMap.putIfAbsent(col, new ArrayList<>());
                levelMap.get(col).add(node.val);

                if (node.left != null)
                    queue.offer(new Pair(node.left, col - 1));
                if (node.right != null)
                    queue.offer(new Pair(node.right, col + 1));
            }

            // Sort the level values to maintain order
            for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
                List<Integer> list = entry.getValue();
                Collections.sort(list);
                map.putIfAbsent(entry.getKey(), new ArrayList<>());
                map.get(entry.getKey()).addAll(list);
            }
        }

        // Add sorted map values to result
        for (List<Integer> values : map.values()) {
            result.add(values);
        }

        return result;
    }

    // Helper class for BFS traversal
    private static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}