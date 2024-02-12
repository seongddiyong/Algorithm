import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()) {
                if (stack.peek() <= temp) stack.pop();
                else break;
            }
            answer += stack.size();
            stack.push(temp);
        }

        System.out.println(answer);
    }
}