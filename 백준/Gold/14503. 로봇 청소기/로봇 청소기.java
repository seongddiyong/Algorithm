import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, answer;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};
    static int [][] map;

    public static void cleaner(int x, int y, int d) {
        map[y][x] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (map[ny][nx] == 0) {
                    answer++;
                    cleaner(nx, ny, d);
                    return;
                }
            }
        }
        int td = (d + 2) % 4;
        int nx = x + dx[td];
        int ny = y + dy[td];
        if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] != 1) {
            cleaner(nx, ny, d);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 1;

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaner(c, r, d);
        System.out.println(answer);

    }
}