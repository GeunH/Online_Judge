import java.math.BigInteger;

class Solution {

    public static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    public int[] solution(int n, int m) {
        int[] answer =  { gcd(n,m), lcm(n,m)};
        return answer;
    }
}