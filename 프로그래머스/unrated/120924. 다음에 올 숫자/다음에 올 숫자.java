class Solution {
    public int solution(int[] common) {
        int len = common.length;
        if ((common[2] - common[1]) != (common[1] - common[0])) {
            return common[len-1] * (common[1]/common[0]);
        } else {
            return common[len-1] + (common[1] - common[0]);
        }
    }
}