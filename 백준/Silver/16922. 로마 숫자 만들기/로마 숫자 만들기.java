import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> list = new HashSet<>();
    static int N;
    public static void dfs(int sum, int num, int depth) {
        sum += num;
        if(depth == N) {
            list.add(sum);
            return;
        }
        if(num == 1) {
            dfs(sum, 1,depth+1);
            dfs(sum, 5,depth+1);
            dfs(sum, 10,depth+1);
            dfs(sum, 50,depth+1);
        } else if (num == 5) {
            dfs(sum, 5,depth+1);
            dfs(sum, 10,depth+1);
            dfs(sum, 50,depth+1);
        } else if (num == 10) {
            dfs(sum, 10,depth+1);
            dfs(sum, 50,depth+1);
        } else {
            dfs(sum, 50, depth+1);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dfs(0,1,1);
        dfs(0,5,1);
        dfs(0,10,1);
        dfs(0,50,1);

        System.out.println(list.size());
    }

}