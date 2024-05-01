import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] dp = new int [M + 1];
        Arrays.fill(dp, -1);
        dp[S] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if (dp[j] == i - 1) {
                    int front = j + temp;
                    int back = j - temp;
                    if (0 <= front && front <= M) arr.add(front);
                    if (0 <= back && back <= M) arr.add(back);
                }
            }
            for (int k : arr) dp[k] = i;
        }
        int max = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == N) {
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }
}