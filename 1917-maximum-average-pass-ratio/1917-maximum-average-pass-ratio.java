class Solution {
    public static double nextPassRatioDiff(double pass, double total){
        return (pass + 1) / (total + 1) - (pass / total);
    }


    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[] > maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        //entry = {nextPassRatioDiff, pass, total}
        for(int[] arr: classes){
            int pass = arr[0];
            int total = arr[1];
            double next = nextPassRatioDiff(pass, total);
            maxHeap.offer(new double[]{next, pass, total});
        }
        while(extraStudents > 0){
            double[] top= maxHeap.poll();
            double pass = top[1] + 1;
            double total = top[2] + 1;
            double next = nextPassRatioDiff(pass, total);
            maxHeap.offer(new double[]{next, pass, total});
            extraStudents--;
        }
        double totalPassRatio = 0;
        while(!maxHeap.isEmpty()){
            double[] arr = maxHeap.poll();
            double pass = arr[1];
            double total = arr[2];
            totalPassRatio += (pass / total);
        }
        return totalPassRatio / n;
    }

}