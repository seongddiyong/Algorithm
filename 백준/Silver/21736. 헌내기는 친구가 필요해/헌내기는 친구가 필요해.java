import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Pos> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] dx = {0,0,-1,1};
        int [] dy = {-1,1,0,0};
        char [][] map = new char[N][M];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = temp.charAt(j);
                if (c == 'I') {
                    queue.offer(new Pos(j, i));
                    map[i][j] = 'X';
                }
                map[i][j] = c;
            }
        }

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            int sx = p.x;
            int sy = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N  && map[ny][nx] != 'X') {
                    if (map[ny][nx] == 'P') answer++;
                    queue.offer(new Pos(nx, ny));
                    map[ny][nx] = 'X';
                }
            }
        }

        if (answer == 0) System.out.println("TT");
        else System.out.println(answer);
    }
}