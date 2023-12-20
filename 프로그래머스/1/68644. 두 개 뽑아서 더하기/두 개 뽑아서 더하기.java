import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0 ; i <numbers.length ; i++) {
            for(int j = i+1 ; j < numbers.length ; j++ ){
                if( !list.contains(numbers[i] + numbers[j]))list.add(numbers[i] + numbers[j]);   
            }
        }

        int[] answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
