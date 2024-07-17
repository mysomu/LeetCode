import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++) {
            lis.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            lis.add(nums2[i]);
        }
        
        Collections.sort(lis);
        
        int n = lis.size();
        if (n % 2 == 0) {
            return (lis.get(n / 2 - 1) + lis.get(n / 2)) / 2.0;
        } else {
            return lis.get(n / 2);
        }
    }
}
