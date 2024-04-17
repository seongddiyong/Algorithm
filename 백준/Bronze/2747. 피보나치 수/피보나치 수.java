import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N + 1];
        arr[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[N]);
    }
}