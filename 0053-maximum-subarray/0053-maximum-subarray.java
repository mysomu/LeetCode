// Kadane's Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        // Start with the first element
        int currSum = nums[0];
        //Initilize maxSum with the first elememnt
        int maxSum = nums[0];
        //Travers the array from the second element
        for(int i=1; i<nums.length; i++){
            //If currSum is -ve reset to curr element
            currSum = Math.max(nums[i],currSum+nums[i]);
            //Update maxSum if currSum is greater
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}