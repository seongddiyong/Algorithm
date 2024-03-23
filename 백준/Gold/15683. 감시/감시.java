import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, answer;
    static int [][] map;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1, 0, 0};
    static int [][][] type = {{},
                                {{0}, {1}, {2}, {3}},
                                {{2, 3}, {0, 1}},
                                {{0, 3}, {1, 3}, {1, 2}, {0, 2}},
                                {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}}
                            };
    static ArrayList<Pos> point = new ArrayList<>();
    static int end;

    static class Pos {
        int x, y, c;
        public Pos(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static boolean checkCanMove(int x, int y) {
        if (x >= 0 && y >= 0 && x < M && y < N && map[y][x] != 6) {
            return true;
        }
        return false;
    }

    public static int checkForFifthCase(int x, int y, int zero) {
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (checkCanMove(nx, ny)) {
                    if (map[ny][nx] == 7 || (map[ny][nx] < 6 && map[ny][nx] > 0)) continue;
                    map[ny][nx] = 7;
                    zero--;
                } else {
                    break;
                }
            }
        }
        return zero;
    }

    public static void markingMap(int depth, int zero, int [][] copiedMap) {
        if (depth == end) {
            if (zero < answer) answer = zero;
            return;
        }

        Pos pos = point.get(depth);
        for (int i = 0; i < type[pos.c].length; i++) {
            int[][] nextMap = new int[N][M];
            int nextZero = zero;
            for (int j = 0; j < N; j++) {
                nextMap[j] = copiedMap[j].clone();
            }

            for (int j = 0; j < type[pos.c][i].length; j++) {
                int dir = type[pos.c][i][j];

                int nx = pos.x;
                int ny = pos.y;
                while (true) {
                    nx += dx[dir];
                    ny += dy[dir];
                    if (checkCanMove(nx, ny)) {
                        if (nextMap[ny][nx] == 7 || (nextMap[ny][nx] < 6 && nextMap[ny][nx] > 0)) continue;
                        nextMap[ny][nx] = 7;
                        nextZero--;
                    } else {
                        break;
                    }
                }
            }
            markingMap(depth + 1, nextZero, nextMap);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];
        int zero = 0;

        LinkedList<Pos> fifthCase = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > 0 && temp < 5) {
                    point.add(new Pos(j, i, temp));
                } else if (temp == 5) {
                    fifthCase.offer(new Pos(j, i, temp));
                } else if (temp == 0) {
                    zero++;
                }
                map[i][j] = temp;
            }
        }

        while (!fifthCase.isEmpty()) {
            Pos pos = fifthCase.poll();
            zero = checkForFifthCase(pos.x, pos.y, zero);
        }
        answer = zero;
        end = point.size();

        markingMap(0, zero, map);


        System.out.println(answer);
    }
}