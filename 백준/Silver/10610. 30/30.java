import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] str = br.readLine().toCharArray();
        int cntZero = 0;
        int sum = 0;
        int [] countSort = new int [10];
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '0') cntZero++;
            sum += str[i] - '0';
            countSort[str[i] - '0']++;
        }
        if (cntZero == 0 || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < countSort[i]; j++) {
                    sb.append(i);
                }
            }
            System.out.println(sb);
        }
    }
}