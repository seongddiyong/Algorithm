import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static int[] alpa = new int[26];
    static int cntAnswer;
    static String str;

    public static void per(int cnt, int prev) {
        if (cnt == str.length()) {
            cntAnswer++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alpa[i] > 0 && (cnt == 0 || prev != i)) {
                alpa[i]--;
                per(cnt + 1, i);
                alpa[i]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) alpa[str.charAt(i) - 'a']++;
        per(0,0);
        System.out.println(cntAnswer);
    }
}