import java.io.*;
import java.util.*;

public class Main {

    public static int[] checkYear(int year) {
        int [] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) monthDays[1] = 29;
        return monthDays;
    }

    public static int cntDays(int year, int month, int day) {
        int d = 0;
        int [] date;
        for (int i = 1; i < year; i++) {
            date = checkYear(i);
            for (int j = 0; j < 12; j++) {
                d += date[j];
            }
        }
        date = checkYear(year);
        for (int i = 0; i < month - 1; i++) {
            d += date[i];
        }
        d += day;
        return d;
    }
    
    public static boolean checkGG(int[] s, int[] e) {
    	if((e[0] * 10000 + e[1] * 100 + e[2]) - ((s[0]+1000) * 10000 + s[1] * 100 + s[2]) >= 0)
    		return true;
    	return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] start = new int[3];
        int [] end = new int[3];

        for (int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            end[i] = Integer.parseInt(st.nextToken());
        }

        if (checkGG(start,end)) {
            System.out.println("gg");
        } else {
            int s = cntDays(start[0], start[1], start[2]);
            int e = cntDays(end[0], end[1], end[2]);
            System.out.println("D-" + (e-s));
        }
    }

}