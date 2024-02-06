import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void swap(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		int prevNum = map[y][x];
		int forNext = 0;
		q.add(new Pos(x, y));
		int i = 0;
		while (!q.isEmpty()) {
			Pos mapping = q.poll();
			int sx = mapping.x;
			int sy = mapping.y;
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
				forNext = map[ny][nx];
				map[ny][nx] = prevNum;
				prevNum = forNext;
				q.add(new Pos(nx, ny));
				visited[ny][nx] = true;
			} else {
				i++;
				if (i > 3) return;
				nx = sx + dx[i];
				ny = sy + dy[i];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
					forNext = map[ny][nx];
					map[ny][nx] = prevNum;
					prevNum = forNext;
					q.add(new Pos(nx, ny));
					visited[ny][nx] = true;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int s = 0; s < R; s++) {
			visited = new boolean[N][M];
			for (int i = 0; i < Math.min(N, M)/2; i++) {
				swap(i, i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
