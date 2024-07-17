import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]);
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}
