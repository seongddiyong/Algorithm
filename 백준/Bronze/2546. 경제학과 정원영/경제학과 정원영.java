import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String black = br.readLine();
            PriorityQueue<Long> queue = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long sumOfone = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                long temp = Long.parseLong(st.nextToken());
                sumOfone += temp;
                queue.offer(temp);
            }
            double avgOne = (double) sumOfone / N;

            long sumOftwo = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                sumOftwo += Long.parseLong(st.nextToken());
            }
            double avgTwo = (double) sumOftwo / M;

            int answer = 0;
            while (queue.size() != 1 && !queue.isEmpty()) {
                long temp = queue.poll();
                if (temp < avgOne && avgTwo < temp) {
                    answer++;
                } else if (temp >= avgOne) {
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}