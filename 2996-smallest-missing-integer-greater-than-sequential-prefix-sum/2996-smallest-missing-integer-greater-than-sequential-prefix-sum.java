class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        int sequentialSum = nums[0];

        // Find sequential prefix sum
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1] + 1)
                sequentialSum += nums[i];
            else
                break;
        }

        // Brute force search
        while(true){
            boolean found = false;

            for(int num : nums){
                if(num == sequentialSum){
                    found = true;
                    break;
                }
            }

            if(!found)
                return sequentialSum;

            sequentialSum++;
        }
    }
}