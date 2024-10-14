class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        int sum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        rightSum = sum;

        // Iterate through the array to find the pivot index
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];          
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        // Return -1 if no pivot index is found
        return -1;
    }
}
