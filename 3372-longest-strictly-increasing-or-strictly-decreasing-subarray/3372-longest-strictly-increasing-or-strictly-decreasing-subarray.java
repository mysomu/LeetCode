class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int maxLength = 1;
        int inc = 1, dec = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc += 1;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec += 1;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }

            maxLength = Math.max(maxLength, Math.max(inc, dec));
        }

        return maxLength;
    }
}