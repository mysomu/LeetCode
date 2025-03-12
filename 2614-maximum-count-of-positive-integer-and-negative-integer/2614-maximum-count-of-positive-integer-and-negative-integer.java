class Solution {
    public int maximumCount(int[] nums) {
        int p = 0, n=0,res = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                p++;
            }else if(nums[i]<0){
                n++;
            }
            res = Math.max(n,p);
        }
        return res;
    }
}