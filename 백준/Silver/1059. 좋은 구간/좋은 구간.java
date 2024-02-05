import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] S = new int[L];
		for(int i=0; i<L; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		Arrays.sort(S);
		
		int start = 0;
		int end = 1001;
		
		for(int temp : S) {
			if (temp < n) {
				if (temp > start) start = temp;
			}
			else if (temp > n) {
				if (temp < end) end = temp;
			} else {
				System.out.println(0);
				return;
			}
		}
		int cnt = 0;
		for(int i = start+1; i <= n; i++) {
			for(int j = n; j <= end-1; j++) {
				if (i != j) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
