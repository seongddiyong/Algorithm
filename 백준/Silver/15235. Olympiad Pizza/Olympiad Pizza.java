import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        int [] arr = new int[N];
        int [] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            queue.offer(i);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int p = queue.poll();
            if (arr[p] == 1) {
                answer[p] = cnt;
            } else {
                arr[p] -= 1;
                queue.offer(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) sb.append(a).append(" ");
        System.out.println(sb);
    }
}