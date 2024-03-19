import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L;
    static int [][] map;

    public static boolean checkCol(int s) {
        int i = 1;
        int prev = map[0][s];
        boolean [] visited = new boolean[N];
        while (i < N) {
            if (map[i][s] == prev) {
                i++;
            } else if (map[i][s] == prev + 1) {
                for (int k = 1; k <= L; k++) {
                    if (i - k < 0 || visited[i-k] || prev != map[i - k][s]) {
                        return false;
                    }
                    visited[i-k] = true;
                }
                i++;
                prev++;
            } else if (map[i][s] == prev - 1) {
                for (int k = 0; k < L; k++) {
                    if (i + k >= N || visited[i + k] || map[i][s] != map[i + k][s]) {
                        return false;
                    }
                    visited[i+k] = true;
                }
                i += L;
                prev--;
            } else if (Math.abs(map[i][s] - prev) > 1) {
                return false;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRow(int s) {
        int i = 1;
        int prev = map[s][0];
        boolean [] visited = new boolean[N];
        while (i < N) {
            if (map[s][i] == prev) {
                i++;
            } else if (map[s][i] == prev + 1) {
                for (int k = 1; k <= L; k++) {
                    if (i - k < 0 || visited[i-k] || prev != map[s][i - k]) {
                        return false;
                    }
                    visited[i-k] = true;
                }
                i++;
                prev++;
            } else if (map[s][i] == prev - 1) {
                for (int k = 0; k < L; k++) {
                    if (i + k >= N || visited[i + k] || map[s][i] != map[s][i + k]) {
                        return false;
                    }
                    visited[i+k] = true;
                }
                i += L;
                prev--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (checkRow(i)) answer++;
            if (checkCol(i)) answer++;
        }

        System.out.println(answer);
    }
}