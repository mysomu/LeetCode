class Solution {
    public int singleNumber(int[] nums) {
        int idx=0;
        for(int num: nums){
            idx = idx^num;
        }
        return idx;
    }
}