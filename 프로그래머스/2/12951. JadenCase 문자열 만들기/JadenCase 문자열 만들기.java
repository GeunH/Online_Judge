class Solution {
    public String solution(String s) {
        String[] answer = s.toLowerCase().split(" ", -1);
        for (int i = 0; i < answer.length; i++) {
            if (answer[i].length() > 0) {
                answer[i] = answer[i].substring(0, 1).toUpperCase() + answer[i].substring(1);
            }
        }
        return String.join(" ", answer);
    }
}
