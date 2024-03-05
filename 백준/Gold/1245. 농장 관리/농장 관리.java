import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {-1,0,1,-1,1,-1,0,1};
    static int [] dy = {1,1,1,0,0,-1,-1,-1};
    static LinkedList<Pos> queue = new LinkedList<>();

    static class Pos {
        int x, y, value;
        public Pos(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static boolean canGo(int nx, int ny) {
        if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
            return true;
        }
        return false;
    }

    public static int checkRound(int x, int y, int value) {
        visited[y][x] = true;
        queue.offer(new Pos(x, y, value));
        boolean flag = false;
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            int sx = p.x;
            int sy = p.y;
            int v = p.value;
            for (int i = 0; i < 8; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                if (canGo(nx, ny)) {
                    if (v == map[ny][nx] && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new Pos(nx, ny, map[ny][nx]));
                    } else if (v < map[ny][nx]) {
                        flag = true;
                    }
                }
            }
        }
        if (flag) return 0;
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                answer += checkRound(j,i,map[i][j]);
            }
        }
        System.out.println(answer);
    }

}