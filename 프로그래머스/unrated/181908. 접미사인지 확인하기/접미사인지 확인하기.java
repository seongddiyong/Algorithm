class Solution {
    public int solution(String my_string, String is_suffix) {
        int a = my_string.length();
        int b = is_suffix.length();
        if (a < b) return 0;
        for (int i = 1; i <= b; i++) {
            if (my_string.charAt(a-i) != is_suffix.charAt(b-i)) {
                return 0;
            }
        }
        return 1;
    }
}