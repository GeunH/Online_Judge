import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String[] solution(String my_string) {
        String[] splitStrings = my_string.split("\\s+");
        return Arrays.stream(splitStrings)
                     .filter(s -> !s.isEmpty())
                     .toArray(String[]::new);
    }
}
