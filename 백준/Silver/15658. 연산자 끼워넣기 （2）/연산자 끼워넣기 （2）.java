import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] cal = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void combination(int depth, int result) {
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] == 0) continue;
            cal[i]--;
            if (i == 0) combination(depth + 1, result + arr[depth]);
            else if (i == 1) combination(depth + 1, result - arr[depth]);
            else if (i == 2) combination(depth + 1, result * arr[depth]);
            else combination(depth + 1, result / arr[depth]);
            cal[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        combination(1,arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}