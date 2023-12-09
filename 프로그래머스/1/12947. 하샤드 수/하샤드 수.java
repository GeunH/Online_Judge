class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        String stringX = String.valueOf(x);
        
        int hashadNum = 0;
        
       for (int i = 0; i < stringX.length(); i++) {
            hashadNum += Integer.parseInt(String.valueOf(stringX.charAt(i)));
        }
        
        if( x % hashadNum == 0)answer = true;
        return answer;
    }
}