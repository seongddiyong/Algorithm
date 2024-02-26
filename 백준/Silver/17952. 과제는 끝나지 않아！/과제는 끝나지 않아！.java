import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Work {
		int score, time;
		
		public Work(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Work> stack = new Stack<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			if (c == 0) {
				if (!stack.isEmpty()) {
					Work work = stack.pop();
					int time = work.time;
					time--;
					if (time == 0) {
						answer += work.score;
					} else {
						work.time = time;
						stack.add(work);
					}
				} else {
					continue;
				}
			}
			else {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken()) - 1;
				if (time == 0) {
					answer += score;
				} else {
					stack.add(new Work(score, time));
				}
			}
		}
		
		System.out.println(answer);
	}

}
