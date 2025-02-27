class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int maxSum = nums[0];
        int minSum = nums[0];

        int currSumMax = nums[0];
        int currSumMin = nums[0];

        for (int i = 1; i < n; i++) {
            //Kadane's Algo for finding max subarray sum
            currSumMax = Math.max(nums[i], currSumMax + nums[i]);
            maxSum = Math.max(maxSum, currSumMax);

            //Kadane's Algo for finding min subarray sum
            currSumMin = Math.min(nums[i], currSumMin + nums[i]);
            minSum = Math.min(minSum, currSumMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}