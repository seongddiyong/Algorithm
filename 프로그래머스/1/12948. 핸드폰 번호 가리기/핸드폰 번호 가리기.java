class Solution {
    public String solution(String phone_number) {
        char[] c = phone_number.toCharArray();
        for(int i=0; i<phone_number.length()-4; i++) {
            c[i] = '*';
        }
        return String.valueOf(c);
    }
}