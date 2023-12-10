class Solution {
    public boolean solution(String s) {
        try {
            if (!(s.length() == 4 || s.length() == 6)) return false;
            int num = Integer.parseInt(s);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
