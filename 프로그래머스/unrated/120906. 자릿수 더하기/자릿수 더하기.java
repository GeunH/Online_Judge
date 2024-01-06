class Solution {
    public int solution(int n) {
        int answer = 0;
        String value = String.valueOf(n);

        for(int i=0; i< value.length(); i++){
            answer += (int)value.charAt(i) -'0';
        }
        return answer;
    }
}