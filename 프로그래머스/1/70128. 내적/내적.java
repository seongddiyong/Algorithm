class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++) {
            if (a[i] == 0 || b[i] == 0) {
                continue;
            } else {
                answer += (a[i]*b[i]);
            }
        }
        return answer;
    }
}