import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> arr;
    static int N, answer;

    public static void cntFriends(int num) {
        int cnt = 0;
        int flag = 0;
        boolean [] visited = new boolean[N + 1];
        visited[num] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        while (!queue.isEmpty() && flag < 2) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int start = queue.poll();
                ArrayList<Integer> tempArr = arr.get(start);
                for (int i = 0; i < tempArr.size(); i++) {
                    if (!visited[tempArr.get(i)]) {
                        queue.offer(tempArr.get(i));
                        visited[tempArr.get(i)] = true;
                        cnt++;
                    }
                }
            }
            flag++;
        }

        if (answer < cnt) answer = cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        arr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            char [] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (temp[j] == 'Y') {
                    arr.get(i).add(j + 1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            cntFriends(i);
        }

        System.out.println(answer);

    }
}