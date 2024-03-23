import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int size;
    static Set<String> set = new HashSet<>();
    static Integer [] arr;
    static StringBuilder sb = new StringBuilder();

    public static void perm(int depth, int start, int [] temp) {
        if (depth == M) {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < M; i++) {
                string.append(temp[i]).append(" ");
            }
            String str = string.toString();
            if (!set.contains(str)) {
                set.add(str);
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = start; i < size; i++) {
            temp[depth] = arr[i];
            perm(depth + 1, i, temp);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> setInteger = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            setInteger.add(Integer.parseInt(st.nextToken()));
        }
        arr = setInteger.toArray(new Integer[0]);
        size = arr.length;

        perm(0, 0, new int [M]);
        System.out.print(sb);
    }
}