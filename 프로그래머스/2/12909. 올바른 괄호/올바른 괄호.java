import java.util.Stack;



class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int cnt = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for( int i= 0; i< s.length(); i++){
            if(s.charAt(i) == ')' && cnt <= 0){
                answer = false;
                break;
            }
            else if( s.charAt(i) == '('){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        if( cnt != 0 ) answer= false;
                    
        return answer;
    }
}