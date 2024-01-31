import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int [] map = new int[N+1];
	    
	    st = new StringTokenizer(br.readLine());
	    
	    for (int i = 1; i < N+1; i++) {
	    	map[i] = map[i-1] + Integer.parseInt(st.nextToken());
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int start = Integer.parseInt(st.nextToken());
	    	int end = Integer.parseInt(st.nextToken());
	    	sb.append(map[end] - map[start-1]).append("\n");
	    }
	    System.out.println(sb);
	}

}
