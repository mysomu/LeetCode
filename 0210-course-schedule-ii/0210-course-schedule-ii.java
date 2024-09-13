import java.util.*;

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
        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

        Stack<Integer> mystack = new Stack<>();

        // Traverse each course
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0) {
                if (detectCycleDFS(adj, visited, i, mystack)) {
                    return new int[0]; // Return empty array if a cycle is detected
                }
            }
        }

        // Fill the result array by popping elements from the stack
        int index = 0;
        while (!mystack.isEmpty()) {
            ans[index++] = mystack.pop();
        }

        return ans;
    }

    // Detects cycles and performs DFS for topological sort
    private boolean detectCycleDFS(List<List<Integer>> adj, int[] visited, int v, Stack<Integer> mystack) {
        visited[v] = 1; // Mark the node as visiting
        for (int neighbor : adj.get(v)) {
            if (visited[neighbor] == 0) {
                if (detectCycleDFS(adj, visited, neighbor, mystack)) {
                    return true;
                }
            } else if (visited[neighbor] == 1) {
                return true; // Cycle detected
            }
        }
        visited[v] = 2; // Mark the node as fully visited
        mystack.push(v); // Push the course to the stack after visiting all its dependencies
        return false;
    }
}
