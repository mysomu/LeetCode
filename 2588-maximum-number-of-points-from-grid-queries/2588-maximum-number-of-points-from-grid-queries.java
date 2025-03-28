class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int R=grid.length;
        int C=grid[0].length;
        int Q=queries.length;
        int[]ans=new int[Q];
        int[][]A=new int[Q][2];
        for(int i=0;i<Q;i++){
            A[i]=new int[]{queries[i],i};
        }
        Arrays.sort(A,(a,b)->Integer.compare(a[0],b[0]));
        Queue<int[]>next=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        boolean[][]vis=new boolean[R][C];
        vis[0][0]=true;
        next.offer(new int[]{grid[0][0],0,0});
        int total=0;
        for(int i=0;i<Q;i++){
            int query=A[i][0];
            int idx=A[i][1];
            Queue<int[]>q=new LinkedList<>();
            while(!next.isEmpty() && next.peek()[0]<query){
                int[]el=next.poll();
                q.offer(new int[]{el[1],el[2]});
            }
            while(!q.isEmpty()){
                int[]curr=q.poll();
                int r0=curr[0],c0=curr[1];
                if(grid[r0][c0]>=query){
                    next.offer(curr);
                    continue;
                }
                total++;
                int[]dirs={0,1,0,-1,0};
                for(int d=0;d<4;d++){
                    int r1=r0+dirs[d];
                    int c1=c0+dirs[d+1];
                    if(r1<0 || r1>=R || c1<0 || c1>=C || vis[r1][c1])continue;
                    vis[r1][c1]=true;
                    if(grid[r1][c1]>=query){
                        next.offer(new int[]{grid[r1][c1],r1,c1});
                    }else{
                        q.offer(new int[]{r1,c1});
                    }
                }
            }
            ans[idx]=total;
        }
        return ans;
    }
}