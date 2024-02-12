class Solution {
    public int solution(int n) {
        int num = (int)Math.sqrt(n);
        if( num*num == n)return 1;
        return 2;
    }
}