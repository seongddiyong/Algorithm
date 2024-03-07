import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int [] visited;

    public static boolean canGo(int x, int y) {
        int i = 1;

        while (x - i >= 0) {
            if (visited[x - i] == y || visited[x - i] == y - i || visited[x - i] == y + i) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static int find(int index) {
        if (index == N) return 1;
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (canGo(index, i)) {
                visited[index] = i;
                res += find(index + 1);
                visited[index] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N];
        System.out.println(find(0));
    }
}