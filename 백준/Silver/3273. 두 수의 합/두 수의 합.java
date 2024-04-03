import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int [] arr;
    public static int count() {
        int result = 0;
        int sum = 0;
        int lt = 0;
        int rt = N-1;

        Arrays.sort(arr);

        while(lt < rt) {
            sum = arr[rt] + arr[lt];

            if(sum == X) result++;

            if(sum < X) {
                lt++;
            }else {
                rt--;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        System.out.println(count());
    }
}