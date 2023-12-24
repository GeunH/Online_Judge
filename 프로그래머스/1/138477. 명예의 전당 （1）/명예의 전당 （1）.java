import java.util.LinkedList;

class Solution {
    public int[] solution(int k, int[] score) {
        LinkedList<Integer> answer = new LinkedList<>();
        int[] returnArray = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            int insertIndex = 0;
            while (insertIndex < answer.size() && answer.get(insertIndex) > score[i]) {
                insertIndex++;
            }
            answer.add(insertIndex, score[i]);
            if (answer.size() > k) {
                answer.removeLast();
            }
            returnArray[i] = answer.getLast();
        }

        return returnArray;
    }
}
