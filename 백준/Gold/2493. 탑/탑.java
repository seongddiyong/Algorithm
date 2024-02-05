import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] answer = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = N - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				stack.pop();
				answer[index.pop()] = i + 1;
			}
			stack.push(arr[i]);
			index.push(i);
		}
		
		for (int i = 0; i < N; i++) sb.append(answer[i]).append(" ");
		System.out.println(sb);
	}

}
