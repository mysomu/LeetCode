class Solution {
    public long gridGame(int[][] grid) {
        long topSum = 0, botSum = 0, min2 = Long.MAX_VALUE;
        for (int num : grid[0]) topSum += num;
        for (int col = 0; col < grid[0].length; col++) {
            topSum -= grid[0][col];
            min2 = Math.min(min2, Math.max(topSum, botSum));
            botSum += grid[1][col];
        }
        return min2;
    }
}