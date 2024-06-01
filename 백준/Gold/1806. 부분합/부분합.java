import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int [] arr = new int [N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while (end <= N && start <= N) {
            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            }
            if (sum < S) {
                sum += arr[end++];
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(min);
        }
    }

}