import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, sum;
    static int [][] dist;
    static int [] index;
    static ArrayList<int []> cu = new ArrayList<>();
    static ArrayList<int []> ck = new ArrayList<>();
    static int ckSize, cuSize;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void sumDist() {
        for (int i = 0; i < cuSize; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int idx : index) {
                if (dist[i][idx] < minValue) minValue = dist[i][idx];
            }
            sum += minValue;
        }
    }

    public static void comb(int start, int depth) {
        if (depth == M) {
            sum = 0;
            int cnt = 0;
            for (int i = 0; i < ckSize; i++) {
                if (visited[i]) index[cnt++] = i;
                if (cnt == M) break;
            }
            sumDist();
            if (min > sum) min = sum;
            return;
        }

        for (int i = start; i < ckSize; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    cu.add(new int[] {j,i});
                } else if (temp == 2) {
                    ck.add(new int[] {j,i});
                }
            }
        }

        ckSize = ck.size();
        cuSize = cu.size();

        dist = new int[cuSize][ckSize];
        visited = new boolean[ckSize];
        index = new int [M];

        for (int i = 0; i < cuSize; i++) {
            for (int j = 0; j < ckSize; j++) {
                dist[i][j] = Math.abs(cu.get(i)[0] - ck.get(j)[0]) + Math.abs(cu.get(i)[1] - ck.get(j)[1]);
            }
        }

        comb(0,0);

        System.out.println(min);
    }
}