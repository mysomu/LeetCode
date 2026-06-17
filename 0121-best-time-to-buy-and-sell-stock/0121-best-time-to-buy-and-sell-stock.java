class Solution {
    public int maxProfit(int[] a) {
        int b=a[0],p=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<b){
                b=a[i];
            }else{
                p=Math.max(p,a[i]-b);
            }
        }
        return p;
        
    }
}