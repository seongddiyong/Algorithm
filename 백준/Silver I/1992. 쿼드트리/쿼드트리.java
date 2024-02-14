import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static char [][] map;
    static int N;

    public static String dc(int L, int sx, int sy) {
        if (L == 1) return String.valueOf(map[sy][sx]);

        int newSize = L / 2;
        String m1 = dc(newSize, sx, sy);
        String m2 = dc(newSize, sx + newSize, sy);
        String m3 = dc(newSize, sx, sy + newSize);
        String m4 = dc(newSize, sx + newSize, sy + newSize);

        if (m1.length() == 1 && m1.equals(m2) && m1.equals(m3) && m1.equals(m4)) return m1;
        else return "(" + m1 + m2 + m3 + m4 + ")";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) map[i][j] = temp.charAt(j);
        }

        System.out.println(dc(N, 0, 0));
    }
}