import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (queue.size() < N) {
                    queue.offer(Integer.parseInt(st.nextToken()));
                    flag = true;
                } else {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp > queue.peek()) {
                        queue.offer(temp);
                        queue.poll();
                        flag = true;
                    }
                }
            }
            if (!flag) break;
        }
        System.out.println(queue.peek());
    }
}