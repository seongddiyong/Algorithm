import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L, R;
    static int answer = 0;
    static int [][] map;
    static boolean [][] visited;

    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};

    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkCanMove(int x, int y, int value) {
        if (x >= 0 && y >= 0 && x < N && y < N && !visited[y][x]) {
            int t = map[y][x];
            if ((t <= value + R && t >= value + L) ||
                        (t <= value - L && t >= value - R)) {
                return true;
            }
        }
        return false;
    }

    public static void bfs(int x, int y) {
        LinkedList<Pos> queue = new LinkedList<>();
        LinkedList<Pos> checked = new LinkedList<>();
        queue.offer(new Pos(x, y));
        visited[y][x] = true;
        int sum = map[y][x];
        int cnt = 1;
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            checked.offer(pos);
            int sx = pos.x;
            int sy = pos.y;
            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                if (checkCanMove(nx, ny, map[sy][sx])) {
                    sum += map[ny][nx];
                    Pos temp = new Pos(nx, ny);
                    queue.offer(temp);
                    visited[ny][nx] = true;
                    cnt++;
                }
            }
        }

        int newValue = sum / cnt;

        while (!checked.isEmpty()) {
            Pos pos = checked.poll();
            map[pos.y][pos.x] = newValue;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 4; k++) {
                        int value = map[i][j];
                        if (!visited[i][j] && checkCanMove(j + dx[k], i + dy[k], value)) {
                            flag = true;
                            bfs(j, i);
                        }
                    }
                }
            }
            if (flag) {
                answer++;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }
}