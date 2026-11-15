class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = Arrays.copyOf(nums, nums.length);

        Arrays.sort(arr);
        for(int i =0;i< arr.length;i++){
            int j = i;
            while(j>=0 && arr[j]>=arr[i]){
                j--;
            }
            map.put(arr[i], j+ 1);
        }

        for (int i = 0 ;i< nums.length;i++){
            // System.out.print(nums[i] + " -> ");
            nums[i]= map.get(nums[i]);
        }
        
        return nums;
    }
}