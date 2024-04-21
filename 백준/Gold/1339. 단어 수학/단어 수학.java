import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [26];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'A'] += (int) Math.pow(10,str.length() - 1 - j);
            }
        }
        Arrays.sort(arr);
        int cnt = 9;
        int i = 25;
        int answer = 0;
        while (arr[i] != 0) {
            answer += arr[i--] * cnt--;
        }
        System.out.println(answer);
    }

}