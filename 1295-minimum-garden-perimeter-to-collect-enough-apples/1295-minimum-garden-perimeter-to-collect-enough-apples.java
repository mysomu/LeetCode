class Solution {
    public long minimumPerimeter(long neededApples) {
        long n=0;
        long total = 0;
        while(total<neededApples){
            n++;
            total += 12 * n * n;
            
        }
        return 8*n;
    }
}