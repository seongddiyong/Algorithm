import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int [] term = new int[N+1];
		int [] price = new int[N+1];
		int [] d = new int[N+1];
		
		for (int i = N; i > 0; i--) {
			st = new StringTokenizer(br.readLine());
			term[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			if (i - term[i] >= 0) d[i] = Math.max(d[i-1], d[i - term[i]] + price[i]);
			else d[i] = d[i-1];
		}
		System.out.println(d[N]);
	}

}