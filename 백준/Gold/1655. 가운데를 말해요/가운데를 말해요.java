import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                maxq.offer(temp);
                if (!minq.isEmpty() && (maxq.peek() > minq.peek())) {
                    minq.offer(maxq.poll());
                    maxq.offer(minq.poll());
                }
            }
            else {
                minq.offer(temp);
                if (maxq.peek() > minq.peek()) {
                    minq.offer(maxq.poll());
                    maxq.offer(minq.poll());
                }
            }
            sb.append(maxq.peek()).append("\n");
        }
        System.out.println(sb);
    }
}