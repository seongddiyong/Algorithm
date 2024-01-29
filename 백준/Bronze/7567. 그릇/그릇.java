import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		String cup = br.readLine();
		answer = 10;
		char last = cup.charAt(0);
		for (int i = 1; i < cup.length(); i++) {
			if (last != cup.charAt(i)) {
				answer += 10;
				last = cup.charAt(i);
			}
			else answer += 5;
		}
		System.out.println(answer);
	}

}
