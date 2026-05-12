class Solution {
    boolean isPossible(int[][]tasks, int energy ){
        for(int [] task: tasks){
            int actual = task[0];
            int minimum = task[1];
            //If current energy is less than required minimum
            if(energy<minimum){
                return false;
            }
            energy -= actual;
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        // Sort by (minimum - actual) in descending order
        Arrays.sort(tasks,(task1,task2)->{
            int diff1 = task1[1]-task1[0];
            int diff2 = task2[1]-task2[0];
            return diff2-diff1;

        });
        int l=0;
        int r = (int) 1e9;
        int res = Integer.MAX_VALUE;
        //Binary Search
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(tasks,mid)){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
}