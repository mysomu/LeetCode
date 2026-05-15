class Solution {
    public int[] separateDigits(int[] nums) {
        Stack<Integer> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            while(num>0){
                int rem = num%10;
                st.push(rem);
                num = num/10;
            }
            while(!st.isEmpty()){
                res.add(st.pop());
            }
        }
        int[] arr = new int[res.size()];
        int i=0;
        for(int n:res){
            arr[i++]=n;

        }
        return arr;
        
    }
}