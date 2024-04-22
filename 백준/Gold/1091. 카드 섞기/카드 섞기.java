import java.io.*;
import java.util.*;

public class Main {

    static int [] arr, suf, original;
    static int N;

    public static boolean check(int [] temp) {
        for (int i = 0; i < N; i++) {
            if (temp[i] != original[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean shuffle() {
        int [] temp = new int [N];
        for (int i = 0; i < N; i++) {
            temp[suf[i]] = arr[i];
        }
        if (check(temp)) {
            arr = temp.clone();
            return true;
        } else {
            return false;
        }
    }

    public static boolean confirm() {
        for (int i = 0; i < N; i++) {
            if (arr[i] != i % 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int [N];
        suf = new int [N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        original = arr.clone();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            suf[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        while (!confirm()) {
            answer++;
            if (!shuffle()) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }

}