import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        while( answer < d.length){
            if( budget - d[answer] >= 0) budget -= d[answer++];    
            else break;
        }
        return answer;
    }
}