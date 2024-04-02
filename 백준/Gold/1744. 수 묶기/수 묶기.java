import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer [] arr = new Integer [N];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			answer += arr[i];
		}
		Arrays.sort(arr, (x, y) -> y - x);
		for (int i = 0; i < N - 1; i += 2) {
			if (arr[i] > 1 && arr[i+1] > 1) answer += (arr[i] * arr[i+1]) - arr[i] - arr[i+1];
			else break;
		}
		for (int i = N - 1; i > 0; i -= 2) {
			if (arr[i] < 0 && arr[i-1] <= 0) answer += (arr[i] * arr[i-1]) - arr[i] - arr[i-1];
			else break;
		}
		System.out.println(answer);
	}
    
}
