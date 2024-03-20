import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int [][] map;
    static int [][] dp;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int dfs(int x, int y) {
        if (dp[y][x] != 0) return dp[y][x];
        dp[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[ny][nx] > map[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(nx, ny) + 1);
            }
        }
        return dp[y][x];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        int max = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(dfs(j, i), max);
            }
        }
        System.out.println(max);
    }
}