class Solution {
    public int longestSubsequence(int[] nums) {
        int xorValue = 0;
        boolean hasNonZero = false;

        for (int x : nums) {
            xorValue ^= x;

            if (x != 0) {
                hasNonZero = true;
            }
        }

        if (xorValue != 0) {
            return nums.length;
        }

        if (hasNonZero) {
            return nums.length - 1;
        }

        return 0;
    }
}