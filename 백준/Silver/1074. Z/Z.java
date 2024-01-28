import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, answer;

    public static void checkMatrix() {
        int p = (int) Math.pow(2, N);

        if (r < p && c < p) {
            return;
        }  else if (r < p) {
            answer += p * p;
            c -= p;
        } else if (c < p) {
            answer += p * p * 2;
            r -= p;
        } else {
            answer += p * p * 3;
            r -= p;
            c -= p;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        while (N != 0) {
            N -= 1;
            checkMatrix();
        }

        System.out.println(answer);
    }

}