class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max_p = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                max_p = Math.max(max_p, (nums[i]-1)*(nums[j]-1) );
            }
        }
        return max_p;
    }
}