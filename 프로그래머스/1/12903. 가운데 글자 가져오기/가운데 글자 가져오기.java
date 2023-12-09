class Solution {
    public String solution(String s) {
        String answer = "";
        if( s.length() % 2 == 0){
            char[] arr = new char[2];
            arr[0] = s.charAt((s.length()-1)/2);
            arr[1] = s.charAt((s.length())/2);
            return String.valueOf(arr);
        }
        else{
            return String.valueOf(s.charAt((s.length())/2));
        }
    }
}