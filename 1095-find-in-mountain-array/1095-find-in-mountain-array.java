/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Find peek element
        int len = mountainArr.length();
        int left =0, right = len-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(mountainArr.get(mid)>=mountainArr.get(mid+1)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        int peek = left;
        //Check target index left of peek()
        int l=0, r=peek;
        while(l<=r){
            int mid = l + (r-l)/2;
            int curr = mountainArr.get(mid);
            if(curr == target){
                return mid;
                
            }else if(curr>target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        //check target index right of peek
        l = peek+1; r=len-1;
        while(l<=r){
            int mid = l + (r-l)/2;
           int curr = mountainArr.get(mid);
           if(curr == target){
               return mid;                
           }else if(curr>target){
               l=mid+1;
           }else{
               r = mid-1;
           }
        }
        return -1;
    }
}