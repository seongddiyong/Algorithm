import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr1 = new int [N];
        int [] arr2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0, k = N - 1; i < N; i++, k--) {
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[k] = arr1[i];
        }

        int [] dp1 = new int [N];
        int [] dp2 = new int [N];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr1[i] > arr1[j]) {
                    if (dp1[i] < dp1[j] + 1) {
                        dp1[i] = dp1[j] + 1;
                    }
                }
                if (arr2[i] > arr2[j]) {
                    if (dp2[i] < dp2[j] + 1) {
                        dp2[i] = dp2[j] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0, k = N - 1; i < N; i++, k--) {
            if (max < dp1[i] + dp2[k]) {
                max = dp1[i] + dp2[k];
            }
        }
        System.out.println(max - 1);
    }
}