class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph and indegree array
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Initialize stack with nodes having indegree 0
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                stack.push(i);
            }
        }

        // Process nodes in LIFO order (stack)
        while (!stack.isEmpty()) {
            int current = stack.pop();
            ans.add(current);

            // Reduce indegree of neighbors and push if indegree becomes 0
            for (int nextCourse : adj.get(current)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    stack.push(nextCourse);
                }
            }
        }

        // If all courses were processed, return true (no cycle)
        return ans.size() == n;
    }
}