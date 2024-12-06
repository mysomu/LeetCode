class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        ArrayList<Integer> list = new ArrayList<>();
        // Create a list of numbers not in banned
        for (int i = 1; i <= n; i++) {
            boolean isBanned = false;
            for (int j = 0; j < banned.length; j++) {
                if (i == banned[j]) {
                    isBanned = true;
                    break;
                }
            }
            if (!isBanned) {
                list.add(i);
            }
        }
        // Calculate the maximum count of numbers within maxSum
        int count = 0;
        int sum = 0;
        for (int num : list) {
            if (sum + num > maxSum) {
                break;
            }
            sum += num;
            count++;
        }
        return count;
    }
}
