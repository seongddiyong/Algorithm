import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp = br.readLine();
        int standard = temp.length() / 10;
        for (int i = 0; i < standard; i++) {
            sb.append(temp.substring(i * 10, (i + 1) * 10)).append("\n");
        }
        if (temp.length() % 10 != 0) {
            sb.append(temp.substring(standard * 10, temp.length()));
        }
        System.out.println(sb);
    }
}