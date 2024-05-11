import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        String temp = br.readLine();
        for (int i = 0; i < temp.length(); i++) {
            left.push(temp.charAt(i));
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch(command.charAt(0)) {
                case 'L':
                    if (left.isEmpty()) break;
                    right.push(left.pop());
                    break;
                case 'D':
                    if (right.isEmpty()) break;
                    left.push(right.pop());
                    break;
                case 'B':
                    if (left.isEmpty()) break;
                    left.pop();
                    break;
                case 'P':
                    left.push(command.charAt(2));
                    break;
            }
        }
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}