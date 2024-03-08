import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int w, h, sx, sy, startIdx, cntStar, answer;
    static char [][] map;
    static int [][] dist;
    static ArrayList<Pos> arr;
    static boolean [] visitedNode;

    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};

    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs(int start, int depth, int cnt) {
        if (cnt >= answer) return;
        if (depth == cntStar-1) {
            if (cnt < answer) answer = cnt;
            return;
        }

        for (int i = 0; i < cntStar; i++) {
            if (!visitedNode[i]) {
                visitedNode[i] = true;
                cnt += dist[i][start];
                dfs(i, depth + 1, cnt);
                cnt -= dist[i][start];
                visitedNode[i] = false;
            }
        }
    }

    public static int checkIndex(int x, int y) {
        int i = 0;
        for (Pos p : arr) {
            if (p.x == x && p.y == y) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean inTheMap(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < w && ny < h && map[ny][nx] != 'x') {
            return true;
        }
        return false;
    }

    // 모든 점의 거리를 구해줄 것
    public static boolean bfs(int start, int ty, int tx) {
        LinkedList<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(tx, ty));
        boolean [][] visited = new boolean[h][w];
        visited[ty][tx] = true;

        int moveCnt = 1;
        int checkCnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Pos p = queue.poll();
                int x = p.x;
                int y = p.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (inTheMap(nx, ny) && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new Pos(nx, ny));
                        if (map[ny][nx] == '*') {
                            int targetIdx = checkIndex(nx, ny);
                            if (dist[start][targetIdx] == 0 && start != targetIdx) {
                                dist[start][targetIdx] = moveCnt;
                                dist[targetIdx][start] = moveCnt;
                            }
                            checkCnt++;
                        }
                    }
                }
            }
            moveCnt++;
            if (checkCnt == cntStar) break;
        }
        if (checkCnt != cntStar) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new char[h][w];
            arr = new ArrayList<>();

            startIdx = 0;
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    char temp = str.charAt(j);
                    if (temp == 'o') {
                        sx = j;
                        sy = i;
                        startIdx = arr.size();
                        arr.add(new Pos(j, i));
                        temp = '*';
                    } else if (temp == '*') {
                        arr.add(new Pos(j, i));
                    }
                    map[i][j] = temp;
                }
            }

            cntStar = arr.size();
            dist = new int[cntStar][cntStar];

            for (int i = 0; i < cntStar; i++) {
                if (!bfs(i, arr.get(i).y, arr.get(i).x)) {
                    answer = -1;
                    break;
                }
            }

            visitedNode = new boolean[cntStar];
            visitedNode[startIdx] = true;
            for (int i = 0; i < cntStar; i++) {
                if (i != startIdx) {
                    visitedNode[i] = true;
                    dfs(i, 1, dist[startIdx][i]);
                    visitedNode[i] = false;
                }
            }

            System.out.println(answer);
        }

    }
}