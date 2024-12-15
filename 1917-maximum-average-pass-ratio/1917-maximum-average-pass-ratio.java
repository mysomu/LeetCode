import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double diff = (double) (pass + 1) / (total + 1) - (double) pass / total;
            maxHeap.offer(new double[]{diff, pass, total});
        }

        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            double diff = top[0];
            int pass = (int) top[1];
            int total = (int) top[2];
            
            pass++;
            total++;
            diff = (double) (pass + 1) / (total + 1) - (double) pass / total;

            maxHeap.offer(new double[]{diff, pass, total});
            extraStudents--;
        }

        double ans = 0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            ans += (double) top[1] / top[2];
        }
        return ans / classes.length;
    }
}