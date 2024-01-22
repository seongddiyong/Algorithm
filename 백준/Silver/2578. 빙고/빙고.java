import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean[][] checked;
    static int bingoCnt = 0;

    // 가로 체크
    public static void checkTypeOne() {
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (checked[i][j]) cnt++;
            }
            if (cnt == 5) bingoCnt++;
        }
    }

    // 세로 체크
    public static void checkTypeTwo() {
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (checked[j][i]) cnt++;
            }
            if (cnt == 5) bingoCnt++;
        }
    }

    // 대각(우하향) 체크
    public static void checkTypeThree() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (checked[i][i]) cnt++;
        }
        if (cnt == 5) bingoCnt++;
    }

    // 대각(좌하향) 체크
    public static void checkTypeFour() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (checked[i][4-i]) cnt++;
        }
        if (cnt == 5) bingoCnt++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, int[]> d = new HashMap<>();

        int[][] map = new int[5][5];
        checked = new boolean[5][5];

        int num = 0;
        int cnt = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                d.put(num, new int[] {i,j});
            }
        }

        loop:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num = Integer.parseInt(st.nextToken());
                x = d.get(num)[0];
                y = d.get(num)[1];
                checked[x][y] = true;
                cnt++;
                if (cnt >= 5) {
                    checkTypeOne();
                    checkTypeTwo();
                    checkTypeThree();
                    checkTypeFour();
                }
                if (bingoCnt > 2) {
                    System.out.println(cnt);
                    break loop;
                }
                bingoCnt = 0;
            }
        }
    }
}