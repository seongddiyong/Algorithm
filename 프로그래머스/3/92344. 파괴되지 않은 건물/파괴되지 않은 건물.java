class Solution {

    int [][] map;
    int row, col;
    
    public void cumulative() {
        for (int i = 1; i < row; i++) {
            map[i][0] += map[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            map[0][i] += map[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                map[i][j] += map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }
    }
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        row = board.length;
        col = board[0].length;
        map = new int [row + 1][col + 1];
        for (int [] s : skill) {
            int num = 0;
            if (s[0] == 1) {
                num = -s[5];
            } else {
                num = s[5];
            }
            map[s[1]][s[2]] += num;
            map[s[3] + 1][s[2]] -= num;
            map[s[1]][s[4] + 1] -= num;
            map[s[3] + 1][s[4] + 1] += num;
        
        }
        cumulative();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = board[i][j] + map[i][j];
                if (temp > 0) answer++;
            }
        }
        return answer;
    }
}