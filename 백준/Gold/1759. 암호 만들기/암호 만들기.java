import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static char [] mContains = {'a', 'e', 'i', 'o', 'u'};
	static char [] arr;
	static boolean [] visited;
	static int L, C;
	static StringBuilder sb = new StringBuilder();
	
	public static boolean checkAlpa(char c) {
		for (char mc : mContains) 
			if (c == mc) return true;
		return false;
	}
	
	public static void dfs(int depth, int start, int mCnt, int zCnt) {
		if (depth == L && mCnt > 0 && zCnt > 1) {
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					sb.append(arr[i]);
				}
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < C; i++) {
			if (depth == 0) {
				mCnt = zCnt = 0;
			}
			if(!visited[i]) {
				if (checkAlpa(arr[i])) mCnt++;
				else zCnt++;
				
				visited[i] = true;
				dfs(depth + 1, i + 1, mCnt, zCnt);
				visited[i] = false;
				
				if (checkAlpa(arr[i])) mCnt--;
				else zCnt--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(0, 0, 0, 0);
		System.out.println(sb);
	}
}