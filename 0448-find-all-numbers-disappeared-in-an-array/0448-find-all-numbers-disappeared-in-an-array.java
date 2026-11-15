class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for(int num:nums){
            vis.add(num);
        }
        for(int i=1; i<=nums.length; i++){
            if(!vis.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}