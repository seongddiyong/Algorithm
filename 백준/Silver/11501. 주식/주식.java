import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int [] arr = new int [N];
            long [] dp = new long [N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int std = arr[N-1];
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] <= std) {
                    dp[i] += std - arr[i] + dp[i+1];
                } else {
                    std = arr[i];
                    dp[i] = dp[i+1];
                }
            }
            sb.append(dp[0]).append("\n");
        }
        System.out.println(sb);
    }

}
