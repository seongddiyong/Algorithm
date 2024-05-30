import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            int temp = (N * 2) - (i * 2);
            for (int j = 0; j < temp; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 0; i < N * 2; i++) {
            sb.append("*");
        }
        sb.append("\n");
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            int temp = (N * 2) - (i * 2);
            for (int j = 0; j < temp; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}