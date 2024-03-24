import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int minusMax = numbers[0] * numbers[1];
        int plusMax = numbers[numbers.length-1] * numbers[numbers.length-2];
        int answer = Math.max(minusMax,plusMax);
        return answer;
    }
}