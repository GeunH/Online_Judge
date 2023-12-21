class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while( n >= a ){
            int changeNum = (n/a)*b;
            int restNum = n%a;
            n = changeNum + restNum;
            answer += changeNum;
        }
        return answer;
    }
}