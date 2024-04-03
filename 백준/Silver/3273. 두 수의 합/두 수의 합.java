import java.util.*;
import java.io.*;

public class Main {

    static int cnt = 0;
    static int N, X;
    static int [] list;
    static boolean [] visited;

    public static void combination(int depth, int start, int front) {
        for (int i = start; i < N; i++) {
            if (depth == 2) {
                if (front + list[i] == X) {
                    cnt++;
                }
                continue;
            }
            combination(2, i + 1, list[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int [N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        combination(1, 0, 0);
        System.out.println(cnt);
    }

}