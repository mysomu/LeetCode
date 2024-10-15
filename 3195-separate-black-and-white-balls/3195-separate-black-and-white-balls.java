class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
        long swapCount=0;
        int last=0;
        for(int cur=0; cur<n; cur++){
            if(s.charAt(cur)=='0'){
                swapCount+=(cur-last);
                last++;
            }
        }
        return swapCount;
    }
}