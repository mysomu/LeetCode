class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int first = 0, last = 0;
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        int n = nums.size();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(int i = 0; i < n; i++){
            int mx = nums.get(i).get(0);
            max = Math.max(max, mx);
            pq.add(new Node(mx, i, 0));
        }
        while(pq.size() == n){
            Node curr = pq.poll();
           if(range > max - curr.val){
                first = curr.val;
                last = max;
                range = max - curr.val;
            }
            if(curr.col < nums.get(curr.row).size() - 1){
                pq.add(new Node(nums.get(curr.row).get(curr.col + 1), curr.row, curr.col + 1));
                max = Math.max(max, nums.get(curr.row).get(curr.col + 1));
            } else{
                break;
            }
        }
        return new int[]{first, last};
    }

    public class Node {
        int val;
        int row;
        int col;

        public Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}