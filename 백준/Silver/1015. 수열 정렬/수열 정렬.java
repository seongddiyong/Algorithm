import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] check = new boolean[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        int[] AA = Arrays.copyOf(A, A.length);

        Arrays.sort(AA);
        int cnt = 0;

        for (int i = 0; i < AA.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if((A[j] == AA[i]) && !check[j]) {
                    B[j] = cnt;
                    check[j] = true;
                    cnt++;
                    break;
                }
            }
        }
        for(int b : B)
            System.out.print(b + " ");
    }
}