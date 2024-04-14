import java.io.*;
import java.util.*;

public class Main {

    static class Pos implements Comparable<Pos> {
        int v;
        int idx;

        public Pos(int value, int index) {
            this.v = value;
            this.idx = index;
        }

        @Override
        public int compareTo(Pos o) {
            return this.v - o.v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pos[] arr = new Pos[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pos(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < arr[i].idx - i) {
                max = arr[i].idx - i;
            }
        }
        System.out.println(max + 1);
    }
}