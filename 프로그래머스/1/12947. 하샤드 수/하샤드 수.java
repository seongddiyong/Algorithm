class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int a = x;
        int s = 0;
        while(a>=1){
            s += a%10;
            a /= 10;
        }
        if (x%s != 0) answer = false;
        return answer;
    }
}