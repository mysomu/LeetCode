class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create the adjacency list for graph representation
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list based on prerequisites
        for (int i = 0; i < prerequisites.length; ++i) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Initialize the result array
        int[] ans = new int[numCourses];

        // Detect if there's a cycle, return an empty array if found
        if (detectCycle(adj, numCourses)) {
            return new int[0];
        }

        // Perform topological sorting using DFS
        Stack<Integer> mystack = new Stack<>();
        boolean[] visited = new boolean[numCourses];

        // Traverse each course
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                dfs(adj, i, visited, mystack);
            }
        }

        // Fill the result array by popping elements from the stack
        int index = 0;
        while (!mystack.isEmpty()) {
            ans[index++] = mystack.pop();
        }

        return ans;
    }

    // Cycle detection method using DFS
    private boolean detectCycle(List<List<Integer>> adj, int n) {
        int[] visited = new int[n];
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                if (detectCycleUtil(adj, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Utility method for detecting cycles recursively
    private boolean detectCycleUtil(List<List<Integer>> adj, int[] visited, int v) {
        visited[v] = 1; // mark as visiting
        for (int i = 0; i < adj.get(v).size(); ++i) {
            int nextCourse = adj.get(v).get(i);
            if (visited[nextCourse] == 0) {
                if (detectCycleUtil(adj, visited, nextCourse)) {
                    return true;
                }
            } else if (visited[nextCourse] == 1) {
                return true; // a cycle is detected
            }
        }
        visited[v] = 2; // mark as fully visited
        return false;
    }

    // Topological sort method using DFS
    private void dfs(List<List<Integer>> adj, int v, boolean[] visited, Stack<Integer> mystack) {
        visited[v] = true;
        for (int i = 0; i < adj.get(v).size(); ++i) {
            if (!visited[adj.get(v).get(i)]) {
                dfs(adj, adj.get(v).get(i), visited, mystack);
            }
        }
        mystack.push(v); // push the course to the stack after visiting all its dependencies
    }
}
