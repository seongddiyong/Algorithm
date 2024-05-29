import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp = null;
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
        }
    }

}