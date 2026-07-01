class Solution {
    int n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    boolean check(int[][] distNearestThief, int sf) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        que.add(new int[]{0, 0});
        visited[0][0] = true;

        if(distNearestThief[0][0] < sf)
            return false;

        while(!que.isEmpty()) {
            int[] curr = que.poll();
            int curr_i = curr[0];
            int curr_j = curr[1];

            if(curr_i == n-1 && curr_j == n-1) {
                return true;
            }

            for(int[] dir : directions) {
                int new_i = curr_i + dir[0];
                int new_j = curr_j + dir[1];

                if(new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && !visited[new_i][new_j]) {
                    if(distNearestThief[new_i][new_j] < sf) {
                        continue; //reject this cell
                    }
                    que.add(new int[]{new_i, new_j});
                    visited[new_i][new_j] = true;
                }
            }
        }

        return false;
    }

    int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();

        // Step-1 Precalculation of distNearestThief - for each cell
        int[][] distNearestThief = new int[n][n];
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        // Push all cells in queue where thieves are present
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    que.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-- > 0) {
                int[] curr = que.poll();
                int curr_i = curr[0];
                int curr_j = curr[1];

                distNearestThief[curr_i][curr_j] = level;

                for(int[] dir : directions) {
                    int new_i = curr_i + dir[0];
                    int new_j = curr_j + dir[1];

                    if(new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j]) {
                        continue;
                    }

                    que.add(new int[]{new_i, new_j});
                    visited[new_i][new_j] = true;
                }
            }
            level++;
        }

        // Step-2 Apply binary search on SF
        int l = 0;
        int r = 400;
        int result = 0;

        while(l <= r) {
            int mid_sf = l + (r - l) / 2;

            if(check(distNearestThief, mid_sf)) {
                result = mid_sf;
                l = mid_sf + 1;
            } else {
                r = mid_sf - 1;
            }
        }

        return result;
    }
}