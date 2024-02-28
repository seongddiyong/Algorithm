import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int [][] dist;
	static boolean [] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static void dfs(int init, int start, int sum, int depth) {
		if (depth == N - 1) {
			if (dist[start][init] != 0) {
				answer = Math.min(answer, sum + dist[start][init]);
			}
			return;
		}
		
		if (sum > answer) return;
		
		for (int i = 0; i < N; i++) {
			if (!visited[i] && dist[start][i] != 0) {
				visited[i] = true;
				dfs(init, i, sum + dist[start][i], depth + 1);
				visited[i] = false;
			}
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        dist = new int[N][N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		dist[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	visited[i] = true;
        	dfs(i, i, 0, 0);
        	visited[i] = false;
        }

        System.out.println(answer);
	}

}
