import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static long N;
	static int P, Q;
	static HashMap<Long, Long> map = new HashMap<>();
	
	public static long recur(long n) {
		if (n == 0L) return 1L;
		else {
			if (!map.containsKey(n)) {
				map.put(n, recur(n / (long) P) + recur(n / (long) Q));
			}
			return map.get(n);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		map.put(0L, 1L);
		
		System.out.println(recur(N));
	}

}