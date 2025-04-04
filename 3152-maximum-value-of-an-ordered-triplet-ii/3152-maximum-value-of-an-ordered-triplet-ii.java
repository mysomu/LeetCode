class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int max_diff = 0, max_num = 0;

        for(int i = 0; i < nums.length; i++) {
            res = Math.max(res, (long) max_diff * nums[i]);
            max_diff = Math.max(max_diff, max_num - nums[i]);
            max_num = Math.max(max_num, nums[i]);
        }
        return res;
    }
}