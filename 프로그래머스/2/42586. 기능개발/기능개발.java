import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();

        int index = 0;
        while(index < progresses.length) {
            int count = 0;

            for(int i = index; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            while(index < progresses.length && progresses[index] >= 100) {
                count++;
                index++;
            }

            if(count > 0) {
                answer.add(count);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
