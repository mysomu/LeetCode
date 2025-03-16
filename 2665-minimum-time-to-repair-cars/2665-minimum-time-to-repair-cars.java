class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) ranks[0] * cars * cars;
        while(left < right)
        {
            long mid = (left + right)/2;
            long currCars = 0;
            for(int rank : ranks)
            {
                currCars += (long) Math.sqrt(mid/rank);
            }
            if(currCars < cars)
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return left;
    }
}