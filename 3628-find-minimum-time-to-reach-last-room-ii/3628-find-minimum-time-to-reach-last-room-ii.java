class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;

        // minTime[i][j] stores the minimum time required to reach cell (i, j)
        int[][] minTime = new int[rows][cols];
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min-heap: {total_time_so_far, row, col, alternate_time}
        // alternate_time switches between 1 and 2 for each step
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        rooms.offer(new int[]{0, 0, 0, 1});  // Start at (0,0) with time = 0 and step = 1

        // Directions: down, up, right, left
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!rooms.isEmpty()) {
            int[] currRoom = rooms.poll();
            int time = currRoom[0];     // current time to reach (row, col)
            int row = currRoom[1];
            int col = currRoom[2];
            int altTime = currRoom[3];  // step cost: 1 or 2

            // If destination (bottom-right cell) is reached, return the time
            if (row == rows - 1 && col == cols - 1) {
                return time;
            }

            // Explore all adjacent cells
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Skip out-of-bound positions
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    // Calculate the earliest time to reach the next room
                    // Must consider the delay in moveTime and current step time
                    int newTime = Math.max(time + altTime, moveTime[newRow][newCol] + altTime);

                    // If this is a faster route to (newRow, newCol), update and enqueue it
                    if (newTime < minTime[newRow][newCol]) {
                        minTime[newRow][newCol] = newTime;
                        rooms.offer(new int[]{newTime, newRow, newCol, altTime == 1 ? 2 : 1});
                    }
                }
            }
        }

        // Destination not reachable
        return -1;
    }
}