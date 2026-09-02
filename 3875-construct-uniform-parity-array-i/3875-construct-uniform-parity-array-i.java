class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int [] nums2 = new int[n];
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums2[i]==nums1[i] && nums2[j]!=nums1[j]){
                    return true;
                }else{
                    if(nums2[i]==nums1[i] - nums1[j]){
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
