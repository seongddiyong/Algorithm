import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] bombtime = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if(map[i][j]=='O'){
                    bombtime[i][j] = 3;
                }
            }
        }

        int time = 1;
        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        while (time++ < N) {
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time + 3;
                        }
                    }
                }
            } else {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombtime[i][j] == time) {
                            map[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int ni = i + di[d];
                                int nj = j + dj[d];
                                if (ni >= 0 && nj >= 0 && ni < R && nj < C) {
                                    if (map[ni][nj] == 'O' && bombtime[ni][nj] != time) {
                                        map[ni][nj] = '.';
                                        bombtime[ni][nj] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }

    }

}