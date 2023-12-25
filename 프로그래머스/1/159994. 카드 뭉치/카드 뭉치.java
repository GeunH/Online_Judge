class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {       
        int cards1cnt = 0, cards2cnt = 0;
        for(String word : goal){
            
            if(cards1cnt < cards1.length && cards1[cards1cnt].equals(word)){
                cards1cnt++;
            }
            else if (cards2cnt < cards2.length && cards2[cards2cnt].equals(word)){
                cards2cnt++;
            }
            else{
                return "No";
            }
        }
        return "Yes";
    }
}