import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;
    static char [][] map;
    static ArrayList<int[]> arr = new ArrayList<>();
    static int [] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int [] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void checkNum(int x, int y, int value) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] != '*' && map[ny][nx] != 'M') {
                int temp = map[ny][nx] - '0' + value;
                if (temp < 10) {
                    map[ny][nx] = (char) (temp + '0');
                } else {
                    map[ny][nx] = 'M';
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                char t = temp.charAt(j);
                if (t != '.') {
                    arr.add(new int[] {j,i,t-'0'});
                    map[i][j] = '*';
                } else {
                    map[i][j] = '0';
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            checkNum(arr.get(i)[0], arr.get(i)[1], arr.get(i)[2]);
        }

        for (char[] m : map)
            System.out.println(String.valueOf(m));
    }
}