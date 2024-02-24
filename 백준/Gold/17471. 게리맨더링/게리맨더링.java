import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, answer;
	static int [] numOfSpace;
	static boolean [] isSelected, visited;
	static ArrayList<ArrayList<Integer>> link = new ArrayList<>();
	static ArrayList<Integer> arr1, arr2;
	
	static boolean check(ArrayList<Integer> arr) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N+1];
		visited[arr.get(0)] = true;
		queue.offer(arr.get(0));
		
		while (!queue.isEmpty()) {
			int p = queue.poll();
			for (int i : link.get(p)) {
				if (!visited[i] &&  arr.contains(i)) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		for (int a : arr) {
			if (!visited[a]) return false;
		}
		
		return true;
	}

	public static void subSet(int cnt) {
		if (cnt == N) {
			arr1 = new ArrayList<>();
			arr2 = new ArrayList<>();
			
			for (int i = 1; i < N + 1; i++) {
				if (isSelected[i]) arr1.add(i);
				else arr2.add(i);
			}
			
			if (arr1.size() == 0 || arr2.size() == 0) return;
			
			if (check(arr1) && check(arr2)) {
				int sum1 = 0;
				int sum2 = 0;
				
				for (int a : arr1) sum1 += numOfSpace[a];
				for (int a : arr2) sum2 += numOfSpace[a];
				
				answer = Math.min(answer, Math.abs(sum1 - sum2));
			}
			return;
		}
		
		isSelected[cnt] = true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		numOfSpace = new int[N+1];
		isSelected = new boolean[N+1];
		answer = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			numOfSpace[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N + 1; i++) {
			link.add(new ArrayList<>());
		}
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				link.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		subSet(0);
		answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
		System.out.println(answer);
	}

}
