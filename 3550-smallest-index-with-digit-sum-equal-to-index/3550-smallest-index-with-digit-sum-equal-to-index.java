class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int digitSum = 0;

            while (value > 0) {
                digitSum += value % 10;
                value /= 10;
            }

            if (digitSum == i) {
                return i;
            }
        }

        return -1;
    }
}