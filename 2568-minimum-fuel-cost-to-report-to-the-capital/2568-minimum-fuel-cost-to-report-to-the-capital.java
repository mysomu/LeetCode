class Solution {
    long totalFuel;

    public long dfs(int node, int parent, List<List<Integer>> adj, int seats) {
        int people = 1;

        for (int child : adj.get(node)) {
            if (child != parent) {
                people += dfs(child, node, adj, seats);
            }
        }

        if (node != 0) {
            totalFuel += (long) Math.ceil((double) people / seats);
        }
        return people;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            int u = r[0], v = r[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        totalFuel = 0;
        dfs(0, -1, adj, seats);
        return totalFuel;
    }
}
