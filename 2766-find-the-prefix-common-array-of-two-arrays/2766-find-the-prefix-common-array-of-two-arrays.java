import java.util.HashSet;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] result = new int[len];
        HashSet<Integer> hs = new HashSet<>();
        int commonCount = 0;

        for (int n = 0; n < len; n++) {
            // Add current elements of A and B to the hash set
            if (!hs.add(A[n])) {
                commonCount++;
            }
            if (!hs.add(B[n])) {
                commonCount++;
            }
            // Store the current common count in the result array
            result[n] = commonCount;
        }
        return result;
    }
}
