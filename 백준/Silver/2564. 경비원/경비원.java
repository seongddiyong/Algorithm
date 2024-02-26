import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int [] map = new int [N];
        int max = 2 * (W + H);

        int temp = 0;
        int dong = 0;
        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            switch (direction) {
                case 1:
                    temp = location;
                    break;
                case 2:
                    temp = 2*W + H - location;
                    break;
                case 3:
                    temp = 2*W + 2*H - location;
                    break;
                case 4:
                    temp = W + location;
                    break;
            }
            if (i < N) map[i] = temp;
            else dong = temp;
        }
        for (int i : map) {
            int dist = Math.abs(dong - i);
            answer += Math.min(dist, max - dist);
        }
        System.out.println(answer);
    }
}