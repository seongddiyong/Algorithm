import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int [][] arr = new int [str.length() + 1][26];
        arr[1][str.charAt(0) - 'a']++;
        for (int i = 2; i <= str.length(); i++) {
            int temp = str.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                int before = arr[i - 1][j];
                if (j == temp) {
                    arr[i][j] = before + 1;
                } else {
                    arr[i][j] = before;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int target = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) + 1;
            sb.append(arr[end][target] - arr[start][target]).append("\n");
        }
        System.out.println(sb);
    }
}