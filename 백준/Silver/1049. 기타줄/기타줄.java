import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] six = new int[M];
        int[] one = new int[M];

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            six[i] = sc.nextInt();
            one[i] = sc.nextInt();
        }

        Arrays.sort(one);
        Arrays.sort(six);

        minimum = Math.min(((N / 6) + 1) * six[0], N * one[0]);
        minimum = Math.min(minimum, (N / 6) * six[0] + (N % 6) * one[0]);

        System.out.println(minimum);
    }
}