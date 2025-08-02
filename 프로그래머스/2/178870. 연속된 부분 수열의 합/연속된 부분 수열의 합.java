class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int l = 0;
        int r = 0;
        int sum = 0;
        int size = sequence.length;
        
        for (r = 0; r<sequence.length; r++) {
            sum += sequence[r];
            
            while (sum > k && r < sequence.length){
                sum-=sequence[l];
                l++;
            }
            
            if (k == sum) {
                if (size > r - l) {
                    size = r - l;
                    answer[0] = l;
                    answer[1] = r;
                }
            }
        }
        return answer;
    }
}