class Solution {
    public String solution(String s) {
        String[] answer = s.split(" ");
        
        int[] nums = new int[answer.length];
            
        int minNum,maxNum;
        minNum = maxNum = Integer.parseInt(answer[0]);
        for ( int i=1; i< answer.length;i++) {
            nums[i] = Integer.parseInt(answer[i]);
            if(minNum > nums[i]) minNum =nums[i];
            else if (maxNum < nums[i] ) maxNum = nums[i];
        }
        
        return minNum + " " + maxNum;
    }
}