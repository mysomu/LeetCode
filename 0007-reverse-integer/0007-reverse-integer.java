class Solution {
    public int reverse(int x) {
        // find the absolute value of Org num
        int num = Math.abs(x);
        int rev = 0;
        while (num != 0) {
            int rem = num % 10;
            // Overflow check
            if (rev > (Integer.MAX_VALUE - rem) / 10) {
                return 0;
            }
            rev = rev * 10 + rem;
            num = num / 10;
        }
        return (x < 0) ? (-rev) : rev;
    }
}