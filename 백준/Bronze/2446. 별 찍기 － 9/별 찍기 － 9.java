import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int temp = N * 2 - 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < temp - (i * 2); j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < temp - (i * 2); j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}