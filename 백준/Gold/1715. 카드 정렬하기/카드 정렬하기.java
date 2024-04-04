import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (q.size() != 1) {
            int a = q.poll();
            int b = q.poll();
            answer += a + b;
            q.offer(a+b);
        }
        System.out.println(answer);
    }
}