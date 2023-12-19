class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            char a = arr[i];

            if ('a' <= a && a <= 'z') {
                a = (char) ((a - 'a' + n) % 26 + 'a');
            } else if ('A' <= a && a <= 'Z') {
                a = (char) ((a - 'A' + n) % 26 + 'A');
            }

            arr[i] = a;
        }

        return String.valueOf(arr);
    }
}
