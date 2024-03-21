import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger [] dp = new BigInteger [251];
        dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		dp[3] = new BigInteger("5");
		for (int i = 4; i < 251; i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}
		String line = null;
		while ((line = br.readLine()) != null) {
			int N = Integer.parseInt(line);
			System.out.println(dp[N]);
		}
        br.close();
	}

}
