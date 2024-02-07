import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            Queue<Integer> q = new LinkedList<>();
            Queue<Boolean> temp = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
                pq.offer(num);
                if(i == M) temp.offer(Boolean.TRUE);
                else temp.offer(Boolean.FALSE);
            }

            int present = pq.poll();
            int cnt = 0;
            while (true) {
                if (present == q.peek()) {
                    if (Boolean.TRUE.equals(temp.peek())) {
                        cnt++;
                        break;
                    } else {
                        q.poll();
                        temp.poll();
                        present = pq.poll();
                        cnt++;
                    }
                } else {
                    q.offer(q.poll());
                    temp.offer(temp.poll());
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}