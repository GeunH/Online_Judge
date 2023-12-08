import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                cnt++;
            }
        }

        if (cnt == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[cnt];

        cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[cnt++] = arr[i];
            }
        }
        
        return answer;
    }
}