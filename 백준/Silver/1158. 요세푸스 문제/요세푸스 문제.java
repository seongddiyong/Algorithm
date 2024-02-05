import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<N+1; i++) {
			q.add(i);
		}
		
		while (true) {
			for(int i = 0; i < K-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll());
			if (q.size() == 0) break;
			sb.append(", ");
		}
		
		sb.append(">");
		System.out.println(sb);
	}

}
