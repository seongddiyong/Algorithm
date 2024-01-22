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
        // 해당 값의 좌표가 어딘지 빠르게 찾으려고 파이썬 dictionary 처럼 사용했습니다.
        Map<Integer, int[]> d = new HashMap<>();

        // false, true로 체크가 되었는지 확인하는 배열
        checked = new boolean[5][5];

        int num = 0;
        int cnt = 0;
        int x = 0;
        int y = 0;

        // 해당 값이 어느 좌표였는지 기록
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num = Integer.parseInt(st.nextToken());
                d.put(num, new int[] {i,j});
            }
        }

        // 루프 설정 (한 번에 빠져나오기)
        loop:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num = Integer.parseInt(st.nextToken());
                x = d.get(num)[0];
                y = d.get(num)[1];
                checked[x][y] = true;
                cnt++;
                // 걍 cnt 12이상이어야 3빙고니까
                if (cnt >= 12) {
                    checkTypeOne();
                    checkTypeTwo();
                    checkTypeThree();
                    checkTypeFour();
                }
                // 빙고 3개면 (2 초과) 출력 후 끝냄
                if (bingoCnt > 2) {
                    System.out.println(cnt);
                    break loop;
                }
                bingoCnt = 0;
            }
        }
    }
}