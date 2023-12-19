class Solution {
    private int answer = 0;

    private void makeZero(int[] number, int now, int cnt, int total) {
        if (cnt == 3) {
            if (total == 0) answer++;
            return;
        }
        if (now == number.length) return;

        for (int i = now; i < number.length; i++) {
            makeZero(number, i + 1, cnt + 1, total + number[i]);
        }
    }

    public int solution(int[] number) {
        answer = 0; 
        makeZero(number, 0, 0, 0);
        return answer;
    }
}
