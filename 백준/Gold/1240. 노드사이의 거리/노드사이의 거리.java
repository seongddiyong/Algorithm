import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static ArrayList<HashMap<Integer, Integer>> map = new ArrayList<>();
    static int end;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void dfs(int start, int sum) {
        if (start == end) {
            sb.append(sum).append("\n");
            return;
        }

        for (int key : map.get(start).keySet()) {
            if (!visited[key]) {
                visited[key] = true;
                dfs(key, sum + map.get(start).get(key));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) map.add(new HashMap<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            map.get(first).put(second, dist);
            map.get(second).put(first, dist);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            visited[s] = true;
            dfs(s, 0);
        }

        System.out.print(sb);
    }
}