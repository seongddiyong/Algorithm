class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int dot = 1;
        for (int i=0; i<num_list.length; i++) {
            sum += num_list[i];
            dot *= num_list[i];
        }
        if (sum*sum < dot) return 0;
        return 1;
    }
}