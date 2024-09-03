class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int prefix=1,suffix=1;
        int ans=nums[0];
        
        for(int i=0;i<n;i++){
            
			//if any of l or suffix become 0 then update it to 1
            prefix = prefix ==0 ? 1 : prefix;
            suffix = suffix==0 ? 1 : suffix;
            
            prefix *= nums[i];   //prefix product
            suffix *= nums[n-1-i];    //suffix product
            
            ans = Math.max(ans,Math.max(prefix,suffix));
            
        }
        
        return ans;

    }
}