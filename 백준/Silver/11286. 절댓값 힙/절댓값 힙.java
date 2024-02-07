import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static int checkNum(int num) {
		if (num % 2 == 0) {
			return num/2;
		} else {
			return (num+1)/2;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) sb.append(0).append("\n");
				else {
					int pollNum = pq.poll();
					if (pollNum % 2 == 0) sb.append(pollNum/2).append("\n");
					else sb.append(-1*(pollNum+1)/2).append("\n");
				}
			} else {
				if (num < 0) pq.add(Math.abs(num*2) - 1);
				else pq.add(num*2);
			}
		}
		System.out.println(sb);
	}

}
