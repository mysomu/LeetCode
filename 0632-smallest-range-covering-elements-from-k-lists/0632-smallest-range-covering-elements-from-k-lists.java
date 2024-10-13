class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[] pointers = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] result = new int[2];
        int range = Integer.MAX_VALUE;

        while (true) {

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            int minListIndex = -1;

            for (int i = 0; i < n; i++) {
                int number = nums.get(i).get(pointers[i]);
                if (number < min) {
                    min = number;
                    minListIndex = i;
                }
                if (number > max) {
                    max = number;
                }
            }

            if (max - min < range) {
                range = max - min;
                result[0] = min;
                result[1] = max;
            }

            pointers[minListIndex]++;

            if (pointers[minListIndex] >= nums.get(minListIndex).size()) {
                break;
            }
        }

        return result; // Return the smallest range found
    }
}