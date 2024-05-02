import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int [] arr = new int [temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i) - '0';
        }
        int [] cntNumber = new int [2];
        int start = arr[0];
        cntNumber[start]++;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != start) {
                start = arr[i];
                cntNumber[start]++;
            }
        }
        if (cntNumber[0] == cntNumber[1]) {
            System.out.println(cntNumber[0]);
        } else if (cntNumber[0] == 0 || cntNumber[1] == 0) {
            System.out.println(0);
        } else if (cntNumber[0] > cntNumber[1]) {
            System.out.println(cntNumber[1]);
        } else {
            System.out.println(cntNumber[0]);
        }
    }
}