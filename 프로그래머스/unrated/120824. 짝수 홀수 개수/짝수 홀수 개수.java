class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        
        int oddNum = 0, evenNum =0;
        for(int num : num_list){
            if( num%2==0)evenNum++;
            else oddNum++;
        }
        answer[0] = evenNum;
        answer[1] = oddNum;
        return answer;
    }
}