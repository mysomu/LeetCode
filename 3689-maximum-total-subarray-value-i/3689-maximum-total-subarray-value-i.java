class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mn = nums[0], mx = nums[0];
        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        return 1L * (mx - mn) * k;
    }
}