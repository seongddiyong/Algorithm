import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int k;
    static int[] S;
    static boolean[] visited;

    public static void permutation(int depth, int start) {
        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                if (visited[i]) sb.append(S[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[k];
            permutation(0, 0);
            System.out.println();
        }

    }

}