import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        int max = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int px = Integer.parseInt(st.nextToken());
        int py = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int nx = Integer.parseInt(st.nextToken());
        int ny = Integer.parseInt(st.nextToken());
        arr[1] = Math.abs(px - nx) + Math.abs(py - ny);
        int answer = arr[1];
        int ppx = px;
        int ppy = py;
        px = nx;
        py = ny;
        for (int i = 2; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nx = Integer.parseInt(st.nextToken());
            ny = Integer.parseInt(st.nextToken());
            arr[i] = Math.abs(px - nx) + Math.abs(py - ny);
            answer += arr[i];
            int temp = arr[i] + arr[i-1] - (Math.abs(ppx - nx) + Math.abs(ppy - ny));
            if (temp > max) {
                max = temp;
            }
            ppx = px;
            ppy = py;
            px = nx;
            py = ny;
        }
        System.out.println(answer - max);
    }
}