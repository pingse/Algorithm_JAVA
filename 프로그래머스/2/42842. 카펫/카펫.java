class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for (int i = total/3; i>=0; i--) {
            if (total % i == 0) {
                int x = i;
                int y = total / i;
                
                if (brown == ((x + y) * 2 - 4)) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }
}