class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for( int i = 0 ; i< s.length() ; i++){
            if( s.charAt(i) == 'z'){
                s = s.substring(0,i) + '0' + s.substring(i+4);
            }
            else if ( s.charAt(i) == 'o'){
                 s = s.substring(0,i) + '1' + s.substring(i+3);
            }
            else if ( s.charAt(i) == 't' && s.charAt(i+1) =='w'){
                 s = s.substring(0,i) + '2' + s.substring(i+3);
            }
            else if ( s.charAt(i) == 't' && s.charAt(i+1) =='h'){
                 s = s.substring(0,i) + '3' + s.substring(i+5);
            }
            else if ( s.charAt(i) == 'f' && s.charAt(i+1) =='o'){
                 s = s.substring(0,i) + '4' + s.substring(i+4);
            }
            else if ( s.charAt(i) == 'f' && s.charAt(i+1) =='i'){
                 s = s.substring(0,i) + '5' + s.substring(i+4);
            }
            else if ( s.charAt(i) == 's' && s.charAt(i+1) =='i'){
                 s = s.substring(0,i) + '6' + s.substring(i+3);
            }
            else if ( s.charAt(i) == 's' && s.charAt(i+1) =='e'){
                 s = s.substring(0,i) + '7' + s.substring(i+5);
            }
            else if ( s.charAt(i) == 'e'){
                 s = s.substring(0,i) + '8' + s.substring(i+5);
            }
             else if ( s.charAt(i) == 'n'){
                 s = s.substring(0,i) + '9' + s.substring(i+4);
            }
        }
        return Integer.parseInt(s);
    }
}