import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int [K+1];
        for (int i = A + 1; i <= K; i++) {
            if (i % 2 == 0 && i / 2 >= A) arr[i] = Math.min(arr[i - 1], arr[i / 2]) + 1;
            else arr[i] = arr[i - 1] + 1;
        }
        System.out.println(arr[K]);
    }
}