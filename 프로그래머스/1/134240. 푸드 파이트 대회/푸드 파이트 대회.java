class Solution {
    public String solution(int[] food) {
        String answer = "0";
        
        for(int i =food.length -1  ; i > 0; i-- ){
            int num = food[i]/2;
            String repeated = String.valueOf(i).repeat(num);
            answer = repeated + answer + repeated ;
        }
        return answer;
    }
}