import java.util.*;
import java.io.*;

class Solution {
    HashMap<String, String> recommend = new HashMap<>();
    HashMap<String, Integer> index = new HashMap<>();

    int[] answer;
    int len;

    public void dfs(String person, int cnt) {
        int nextCnt = (int) (cnt * 0.1);
        if (nextCnt == 0) {
            answer[index.get(person)] += cnt;
            return;
        } else if (recommend.get(person).equals("-")) {
            answer[index.get(person)] += cnt - (int) (cnt * 0.1);
            return;
        } else {
            answer[index.get(person)] += cnt - (int) (cnt * 0.1);
            String nextPerson = recommend.get(person);
            dfs(nextPerson, nextCnt);
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        len = enroll.length;
        answer = new int [len];
        for (int i = 0; i < len; i++) {
            recommend.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        for (int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }
        return answer;
    }
}