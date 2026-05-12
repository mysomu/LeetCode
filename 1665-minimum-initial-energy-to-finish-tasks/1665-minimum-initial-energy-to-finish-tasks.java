class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int energy = 0;
        int curr = 0;

        for (int[] task : tasks) {
            if (curr < task[1]) {
                energy += task[1] - curr;
                curr = task[1];
            }

            curr -= task[0];
        }

        return energy;
    }
}