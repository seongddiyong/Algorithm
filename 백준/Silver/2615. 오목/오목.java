import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] map = new int[19][19];
	static int answer = 0;
	
	public static void right(int x, int y) {
		int color = map[y][x];
		int cnt = 1;
		int nx = x + 1;
		while (true) {
			if (nx >= 19 || map[y][nx] != color) {
				break;
			} else {
				if (map[y][nx] == color) {
					cnt++;
					nx++;
				}
			}
		}
		if(cnt == 5 && x-1 >= 0 && map[y][x-1] == color) {
			return;
		}
		if(cnt == 5) answer = color;
	}
	
	public static void down(int x, int y) {
		int color = map[y][x];
		int cnt = 1;
		int ny = y + 1;
		while (true) {
			if (ny >= 19 || map[ny][x] != color) {
				break;
			} else {
				if (map[ny][x] == color) {
					cnt++;
					ny++;
				}
			}
		}
		if(cnt == 5 && y-1 >= 0 && map[y-1][x] == color) {
			return;
		}
		if (cnt == 5) answer = color;
	}
	
	public static void rightDown(int x, int y) {
		int color = map[y][x];
		int cnt = 1;
		int ny = y + 1;
		int nx = x + 1;
		while (true) {
			if (ny >= 19 || nx >= 19 || map[ny][nx] != color) {
				break;
			} else {
				if (map[ny][nx] == color) {
					cnt++;
					ny++;
					nx++;
				}
			}
		}
		if(cnt == 5 && x-1 >= 0 && y-1 >= 0 && map[y-1][x-1] == color) {
			return;
		}
		if (cnt == 5) answer = color;
	}
	
	public static void rightUp(int x, int y) {
		int color = map[y][x];
		int cnt = 1;
		int ny = y - 1;
		int nx = x + 1;
		while (true) {
			if (ny  < 0 || nx >= 19 || map[ny][nx] != color) {
				break;
			} else {
				if (map[ny][nx] == color) {
					cnt++;
					ny--;
					nx++;
				}
			}
		}
		if(cnt == 5 && x-1 >= 0 && y+1 >= 0 && map[y+1][x-1] == color) {
			return;
		}
		if (cnt == 5) answer = color;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<19; i++) {
			map[0][i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		loop:
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(map[i][j] != 0) {
					right(j,i);
					down(j,i);
					rightDown(j,i);
					rightUp(j,i);
				}
				if(answer != 0) {
					System.out.println(answer);
					i++;
					j++;
					System.out.println(i + " " + j);
					break loop;
				}
			}
		}
		if(answer == 0) System.out.println(0);
	}
}

