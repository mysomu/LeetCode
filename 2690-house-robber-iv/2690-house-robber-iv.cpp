class Solution {
public:
    int helper(int i,vector<int> &nums,int x,vector<int> &dp){
        if(i < 0){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int include, exclude;
        include = exclude = 0;
        if(nums[i] <= x){
            include = 1 + helper( i-2, nums, x, dp);
        }
        exclude = helper( i-1, nums, x, dp);
        return dp[i] = max( include, exclude);
    }
    bool predicate(vector<int> &nums,int k,int x){
        int n = nums.size();
        vector<int> dp(n,-1);
        // dp[i] : maximum number of non adjacent houses that can be robbed from nums(0...i) 
        // and each robbed houses must be lesser than equal to x
        helper( n-1, nums, x, dp);
        return dp[n-1] >= k;
    }
    int minCapability(vector<int>& nums, int k) {
        int l = INT_MAX;
        int r = INT_MIN;
        for(int num : nums){
            l = min( l, num);
            r = max( r, num);
        }
        int m;
        int ans = -1;
        while(l <= r){
            m = l + (r-l)/2;
            if(predicate( nums, k, m)){
                ans = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return ans;
    }
};