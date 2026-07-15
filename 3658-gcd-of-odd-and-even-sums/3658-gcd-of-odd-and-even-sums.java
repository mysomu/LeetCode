class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;
        for (int i = 1; i <= n * 2; i++) {
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }
        //gcd 
        int a = sumEven, b = sumOdd;
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;

    }
}