class Solution {
    public boolean uniformArray(int[] nums1) {
        // Find the minimum element in the array
        int mn = nums1[0];
        for (int num : nums1) {
            if (num < mn) {
                mn = num;
            }
        }
        
        // If the minimum element is odd, we can make all elements odd
        if (mn % 2 != 0) {
            return true;
        } else {
            // If the minimum is even, all elements MUST already be even
            for (int num : nums1) {
                if (num % 2 != 0) {
                    return false; // Found an odd number, impossible to convert
                }
            }
        }
        return true;
    }
}