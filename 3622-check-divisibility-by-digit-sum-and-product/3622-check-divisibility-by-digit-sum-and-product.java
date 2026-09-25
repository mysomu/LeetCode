class Solution {
    public boolean checkDivisibility(int n) {
        return (n%(sum(n)+product(n)))==0;
    }
    public int sum(int n){
        int sum=0,val=n;
        while(val>0){
            sum+=val%10;
            val/=10;
        }
        return sum;
    }
    public int product(int n){
        int pro=1,val=n;
        while(val>0){
            pro*=val%10;
            val/=10;
        }
        return pro;
    }
}