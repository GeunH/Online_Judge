import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[26];
        
        Arrays.fill(answer, -1);
        
        List<Integer> list = new ArrayList<>();
        
        for (int i =0; i<s.length(); i++){
            if(answer[s.charAt(i)-'a'] == -1){
                list.add(answer[s.charAt(i)-'a']);
            }  
            else{
                list.add(i-answer[s.charAt(i)-'a'] );   
            }
            answer[s.charAt(i)-'a'] = i;
        }
        
        int [] value  = new int[list.size()];
        
        for(int i =0; i< list.size() ; i++){
            value[i] = list.get(i);
        }
        return value;
    }
}