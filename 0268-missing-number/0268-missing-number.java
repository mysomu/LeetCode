class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumofnums = (n *(n+1))/2;
        int sum=0;
        for (int num: nums){
            sum += num;
        }
        int missingnum = sumofnums- sum;

        return missingnum;

    }
}