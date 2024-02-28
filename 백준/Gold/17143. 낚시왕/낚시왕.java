import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static HashMap<Integer, Shark> location = new HashMap<>();
    static int R, C, M, locSize;
    static int [][] map;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {-1,1,0,0};
    static boolean [] removed;

    static class Shark {
        int r, c, s, d, z;
        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
        
    }

    public static boolean eatShark(int sharkScale, int enemyShark) {
        if (sharkScale > location.get(enemyShark).z) return true;
        return false;
    }

    public static void sharkMove() {
    	boolean [] moved = new boolean [M+1];
        for (int sharkNum = 1; sharkNum <= locSize; sharkNum++) {
            if (removed[sharkNum]) continue;
            moved[sharkNum] = true;

            Shark shark = location.get(sharkNum);
            int y = shark.r;
            int x = shark.c;
            int dir = shark.d;
            int speed = shark.s;

            if (map[y][x] == sharkNum) map[y][x] = 0;

            int diry = dy[dir];
            int dirx = dx[dir];

            if (dir < 2) speed %= (R - 1) * 2;
            else speed %= (C - 1) * 2;

            for (int i = 0; i < speed; i++) {
                if (y + diry < 0 || y + diry >= R || x + dirx < 0 || x + dirx >= C) {
                    dirx = -dirx;
                    diry = -diry;
                    switch (dir) {
	                    case 0:
	                    	dir = 1;
	                    	break;
	                    case 1:
	                    	dir = 0;
	                    	break;
	                    case 2:
	                    	dir = 3;
	                    	break;
	                    case 3:
	                    	dir = 2;
	                    	break;
                    }
                }
                y += diry;
                x += dirx;
            }
            
            shark.r = y;
            shark.c = x;
            shark.d = dir;
            
            if (map[y][x] == 0 || !moved[map[y][x]]) {
                map[y][x] = sharkNum;
            } else {
                if (eatShark(shark.z, map[y][x])) {
                	removed[map[y][x]] = true;
                    map[y][x] = sharkNum;
                }
                else {
                    removed[sharkNum] = true;
                    location.remove(sharkNum);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        removed = new boolean[M+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            location.put(i, new Shark(r,c,s,d,z));
            map[r][c] = i;
        }

        int answer = 0;
        locSize = location.size();

        for (int person = 0; person < C; person++) {
            for (int row = 0; row < R; row++) {
                if (map[row][person] != 0) {
                    int temp = map[row][person];
                    answer += location.get(temp).z;
                    location.remove(temp);
                    removed[temp] = true;
                    map[row][person] = 0;
                    break;
                }
            }
            sharkMove();
        }

        System.out.println(answer);
    }
}
