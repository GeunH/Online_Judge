import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        char[] result = new char[s.length()];
        
        
        for( int i = s.length() -1 ; i>= 0 ; i--){
            result[s.length() - 1 - i] = arr[i];
        }
        
        return  String.valueOf(result);
    }
}
