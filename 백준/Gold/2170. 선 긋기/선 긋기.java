import java.io.*;
import java.util.*;

public class Main {

    static class Pos implements Comparable<Pos> {
        int start, end;

        public Pos(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pos other) {
            if (this.start == other.start) {
                return this.end - other.end;
            } else {
                return this.start - other.start;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Pos pos = queue.poll();
        int start = pos.start;
        int end = pos.end;
        int answer = 0;
        while (!queue.isEmpty()) {
            pos = queue.poll();
            if (pos.start > end) {
                answer += end - start;
                start = pos.start;
                end = pos.end;
                continue;
            } else if (pos.end > end) {
                end = pos.end;
            }
        }
        answer += end - start;
        System.out.println(answer);
    }
}