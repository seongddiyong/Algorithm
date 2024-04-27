import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = N / 5;
        if (N % 5 != 0) {
            System.out.println(answer + 1);
        } else {
            System.out.println(answer);
        }
    }
}