class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int l=0, cursum=0, maxSum=0;
        for(int r=0; r<nums.length; r++){
            while(hs.contains(nums[r])){
                hs.remove(nums[l]);
                cursum -= nums[l];
                l++;
            }
            hs.add(nums[r]);
            cursum += nums[r];
            maxSum=Math.max(maxSum,cursum);
        }
        return maxSum;
    }
}