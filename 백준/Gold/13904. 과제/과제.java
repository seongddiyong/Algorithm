import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		ArrayList<int []> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int date = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			list.add(new int [] {date, score});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		int [] check = new int[1001];
		
		for(int [] p : list) {
			for(int i = p[0]; i > 0; i--) {
				if(check[i] == 0) {
					check[i] = p[1];
					break;
				}
			}
		}
		
		int total =0;
		for(int num : check) {
			total += num;
		}
		System.out.println(total);
	}

}