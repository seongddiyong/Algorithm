import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String boomStr = br.readLine();
        int boomSize = boomStr.length();

        Stack<Character> stack =  new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            boolean flag = true;
            if (stack.size() >= boomSize) {
                int k = stack.size() - 1;
                for (int j = boomSize - 1; j >= 0; j--, k--) {
                    if (boomStr.charAt(j) != stack.get(k)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int temp = 0; temp < boomSize; temp++) stack.pop();
                }
            }
        }

        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            for (char c : stack) sb.append(c);
            System.out.println(sb);
        }
    }
}