class Solution {
    public String[] solution(String[] strArr) {
        
        int cnt =0;
        for(String a : strArr){
            if( !a.contains("ad")){
                cnt++;
            }
        }
        String[] answer = new String[cnt];
        
        cnt = 0;
        for(String a : strArr){
            if( !a.contains("ad")){
                answer[cnt++] = a;
            }
        }
        return answer;
    }
}