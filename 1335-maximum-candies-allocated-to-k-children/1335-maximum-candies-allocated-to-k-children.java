class Solution {
    public int maximumCandies(int[] candies, long k) {
        if (sum(candies) < k) {
            return 0;
        }

        int low = 1, high = getMax(candies);
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canAllocate(candies, k, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean canAllocate(int[] candies, long k, int pileSize) {
        if (pileSize == 0)
            return true;
        long totalPiles = 0;
        for (int candy : candies) {
            totalPiles += candy / pileSize;
            if (totalPiles >= k)
                return true;
        }
        return false;
    }

    private long sum(int[] candies) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    private int getMax(int[] candies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}
