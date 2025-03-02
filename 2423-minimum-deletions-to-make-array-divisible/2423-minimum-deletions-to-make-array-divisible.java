class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gc = numsDivide[0];
        for (int val : numsDivide) {
            gc = gcd(gc, val);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (gc % nums[i] == 0)
                return i;
        }
        return -1;
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}