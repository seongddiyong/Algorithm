import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken()) * 2;
        int C = Integer.parseInt(st.nextToken()) * 3;

        int [] arr = new int[101];

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                arr[j]++;
            }

            if (max < end) {
                max = end;
            }
            if (min > start) {
                min = start;
            }
        }

        int answer = 0;

        for (int i = min; i < max; i++) {
            if (arr[i] == 1) {
                answer += A;
            } else if (arr[i] == 2) {
                answer += B;
            } else if (arr[i] == 3) {
                answer += C;
            }
        }

        System.out.println(answer);
    }
}