class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;

        int left=0;
        int n = nums.length;

        for(int right=1; right<n; right++){
            if(nums[right]>nums[right-1]){
                result = Math.max(result, right-left+1);
            }else{
                left = right;
            }
        }
        left = 0;
        for(int right=1; right<n; right++){
            if(nums[right]<nums[right-1]){
                result = Math.max(result, right-left+1);
            }else{
                left = right;
            }
        }
        return result;
    }
}