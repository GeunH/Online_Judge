class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length];
        String[] answer = new String[n];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i] | arr2[i];

            String element = "";
            for (int j = 0; j < n; j++) {
                int bit = arr[i] & (1 << (n - j - 1));
                element += (bit > 0) ? "#" : " ";
            }
            answer[i] = element;
        }
        
        return answer;
    }
}
