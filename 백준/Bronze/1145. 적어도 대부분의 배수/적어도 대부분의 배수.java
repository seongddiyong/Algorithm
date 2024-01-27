import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (min > arr[i]) min = arr[i];
        }

        int temp = min;
        int cnt = 0;

        loop:
        while (true) {
            for (int i = 0; i < 5; i++) {
                if (temp % arr[i] == 0) cnt++;
            }
            if (cnt >= 3) {
                System.out.println(temp);
                break loop;
            }
            cnt = 0;
            temp++;
        }
    }

}