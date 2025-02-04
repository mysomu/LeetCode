class Solution {
    public int maxAscendingSum(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int res =0;
        int sum=0;
        int i=0;
        while(i<nums.length){
            if(st.isEmpty() || st.peek()<nums[i]){
                st.push(nums[i]);
            }else{
                while(!st.isEmpty()){
                    sum +=st.pop();
                }
            res = Math.max(res,sum);
            sum=0;
            st.push(nums[i]);
            }
            i++;
        }
        while(!st.isEmpty()){
            sum += st.pop();
        }
        res= Math.max(res,sum);
        
        return res;        
    }
}