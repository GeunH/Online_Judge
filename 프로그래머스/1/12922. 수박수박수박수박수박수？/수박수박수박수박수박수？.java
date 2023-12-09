class Solution {
    public String solution(int n) {
        String answer = "수박";
        
        int cnt = n/2;
        
        answer = answer.repeat(cnt);
        if (n%2==1)return answer + "수";
        return answer;
    }
}