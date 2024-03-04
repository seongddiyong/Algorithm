import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int x, y, h;
        public Pos(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static int [][][] map;
    static int N, M, H, cnt;
    static LinkedList<Pos> queue = new LinkedList<>();
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static int [] dh = {-1, 1};

    public static boolean bfs() {
        int size = queue.size();
        boolean flag = false;
        for (int s = 0; s < size; s++) {
            Pos p = queue.poll();
            int x = p.x;
            int y = p.y;
            int h = p.h;
            for (int i = 0; i < 2; i++) {
                int nh = h + dh[i];
                if (nh >= 0 && nh < H && map[nh][y][x] == 0) {
                    map[nh][y][x] = 1;
                    cnt--;
                    flag = true;
                    queue.offer(new Pos(x, y, nh));
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[h][ny][nx] == 0) {
                    map[h][ny][nx] = 1;
                    cnt--;
                    flag = true;
                    queue.offer(new Pos(nx, ny, h));
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j][k] = temp;
                    if (temp == 1) queue.offer(new Pos(k,j,i));
                    else if (temp == 0) cnt++;
                }
            }
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            if (bfs()) answer++;
        }

        if (cnt == 0) System.out.println(answer);
        else System.out.println(-1);
    }
}