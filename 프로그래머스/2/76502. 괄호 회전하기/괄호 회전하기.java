import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean check(String s) {
        Map<Character, Character> match = new HashMap<>();
        match.put('}', '{');
        match.put(']', '[');
        match.put(')', '(');
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (match.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != match.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (this.check(s)) answer++;
        }
        return answer;
    }
}
