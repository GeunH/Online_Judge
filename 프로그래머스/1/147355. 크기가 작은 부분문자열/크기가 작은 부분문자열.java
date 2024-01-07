class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String subStr = t.substring(i, i + p.length());
            if (subStr.compareTo(p) <= 0) {
                answer++;
            }
        }

        return answer;
    }
}
