import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] arr = br.readLine().toCharArray();
        int answer = 0;
        for (char i : arr) {
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                answer++;
            }
        }
        System.out.println(answer);
    }

}