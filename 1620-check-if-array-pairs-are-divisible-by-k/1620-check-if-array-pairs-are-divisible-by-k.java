class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderFreq = new int[k];
        
        // Count the remainders of each element modulo k
        for (int num : arr) {
            int remainder = (num % k + k) % k;  // Handle negative numbers correctly
            remainderFreq[remainder]++;
        }
        
        // Check pairs for remainder 0
        if (remainderFreq[0] % 2 != 0) {
            return false;
        }
        
        // Check pairs for remainders from 1 to k/2
        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                if (remainderFreq[i] % 2 != 0) {
                    return false;
                }
            } else if (remainderFreq[i] != remainderFreq[k - i]) {
                return false;
            }
        }
        
        return true;
    }
}
