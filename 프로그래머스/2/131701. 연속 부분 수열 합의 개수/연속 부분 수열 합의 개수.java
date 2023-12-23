import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> uniqueSums = new HashSet<>();
        List<Integer> sumsList = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + elements.length; j++) {
                sum += elements[j % elements.length];
                if (uniqueSums.add(sum)) {
                    sumsList.add(sum);
                }
            }
        }

        return sumsList.size();
    }
}
