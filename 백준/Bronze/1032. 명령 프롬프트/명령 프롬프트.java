import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[] startString = sc.next().toCharArray();
        for (int i = 0; i < N - 1; i++) {
            char[] nextString = sc.next().toCharArray();
            for (int j = 0; j < startString.length; j++) {
                if(startString[j] != nextString[j]) {
                    startString[j] = '?';
                }
            }
        }
        System.out.println(String.valueOf(startString));
    }
}