class Solution {
    public long countPairs(int[] nums,int range){
        long count=0;
        int i=0,j=nums.length-1;
        while(i < j){
            while(j > i && nums[i]+nums[j] > range)j--;
            count+=j-i;
            i++;
        }
        return count;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
      Arrays.sort(nums);
      return countPairs(nums,upper)-countPairs(nums,lower-1);  
    }
}