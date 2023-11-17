import java.util.*;

class Solution {
    public long solution(long n) {
        ArrayList<Long> arr = new ArrayList<>();
        while (n>0) {
            arr.add(n%10);
            n /= 10;
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        StringBuilder sb = new StringBuilder();
        for (long num : arr) {
            sb.append(num);
        }
        return Long.parseLong(sb.toString());
    }
}