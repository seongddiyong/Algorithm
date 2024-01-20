import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 1;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - 48;
            }
        }

        int len = Math.min(N,M);

        loop:
        while (len > 1) {
            for (int i = 0; i <= N - len; i++) {
                for (int j = 0; j <= M - len; j++) {
                    int num = map[i][j];
                    if ((num == map[i][j + len - 1]) && (num == map[i + len - 1][j]) && num == map[i + len - 1][j + len - 1]) {
                        answer = len*len;
                        break loop;
                    }
                }
            }
            len--;
        }

        System.out.println(answer);

    }
}