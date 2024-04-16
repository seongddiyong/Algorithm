import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int [] arr = new int [N+1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            int answer = 1;
            int standard = arr[1];
            for (int i = 2; i <= N; i++) {
                if (arr[i] < standard) {
                    answer++;
                    standard = arr[i];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}