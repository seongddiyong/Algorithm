import java.util.*;
import java.io.*;

class Main {

    static int N, M, K, answer;
    static int [][] map;

    public static boolean check(int [] arr1, int [] arr2) {
        for (int i = 0; i < M; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
            int patternCnt = 0;
            if (cnt <= K && cnt % 2 == K % 2) {
                for (int j = 0; j < N; j++) {
                    if (check(map[i], map[j])) patternCnt++;
                }
            }
            answer = Math.max(answer, patternCnt);
        }
        System.out.println(answer);
    }

}