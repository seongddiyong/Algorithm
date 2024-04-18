import java.io.*;
import java.util.*;

public class Main {

    static int N, M, L, K;
    static ArrayList<Pos> arr = new ArrayList<>();

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int checkSquare(int x, int y) {
        int res = 0;
        for(Pos pos: arr){
            if (x <= pos.x && pos.x <= x + L && y <= pos.y && pos.y <= y + L) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        for (Pos pos1 : arr) {
            for (Pos pos2 : arr) {
                answer = Math.max(answer, checkSquare(pos1.x, pos2.y));
            }
        }
        System.out.println(K - answer);
    }

}