class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> products = new HashMap<>();
        int ans = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                ans += products.getOrDefault(prod, 0);
                products.put(prod, products.getOrDefault(prod, 0) + 1);
            }
        }
        return ans * 8;
    }
}