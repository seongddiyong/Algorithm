import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int k = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = N - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int j = 0; j < k; j++) {
                sb.append("*");
            }
            k += 2;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}