import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int [][] map = new int[N+1][N+1];
	    
	    for (int i = 1; i < N+1; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for (int j = 1; j < N+1; j++) {
	    		map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < M; i++) {
	    	int sum = 0;
	    	st = new StringTokenizer(br.readLine());
	    	int sy = Integer.parseInt(st.nextToken());
	    	int sx = Integer.parseInt(st.nextToken());
	    	int ey = Integer.parseInt(st.nextToken());
	    	int ex = Integer.parseInt(st.nextToken());
	    	for(int j = sy; j <= ey; j++) {
	    		sum += map[j][ex] - map[j][sx-1];
	    	}
	    	sb.append(sum).append("\n");
	    }
	    System.out.println(sb);

	}

}
