class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 =0, xor2=0;
        // xor all elements nums1
        for(int num : nums1)
            xor1 ^= num;
        
        // xor all elements nums2
        for(int num : nums2)
            xor2 ^= num;
        
        int res = 0;
        // If nums2's length is odd, xor1 contributes; 
        if(nums2.length%2!=0)
             res ^= xor1;
        //if nums1's length is odd, xor2 contributes
        if(nums1.length%2!=0)
            res ^= xor2;
        
        return res;
    }
}