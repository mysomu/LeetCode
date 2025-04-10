class Solution {
    private long cnt(long x, long suf, long inc, int limit) {
        long ans = x % inc < suf ? 0 : 1;
        x /= inc;
        long digitValue = 1;
        while (x > 0L) {
            long d = x % 10;
            x /= 10;
            if (d > limit) // all lower powerful integers are lost
                ans = (limit + 1) * digitValue;
            else
                ans += d * digitValue;
            digitValue *= limit + 1;
        }
        return ans;
    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {    
        long suf = Long.valueOf(s), inc = 10L;
        for (int i = 1; i < s.length(); ++i)
            inc *= 10L; // inc = 10 ^ s.length();
        return cnt(finish, suf, inc , limit) - cnt(start - 1, suf, inc , limit);
    }
}