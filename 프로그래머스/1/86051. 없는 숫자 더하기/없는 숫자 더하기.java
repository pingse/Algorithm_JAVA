class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] ns = new boolean[10];
        
        for (int i = 0; i<numbers.length; i++) {
            ns[numbers[i]] = true;
        }
        
        for (int i = 0; i<ns.length; i++) {
            if (!ns[i]) answer += i;
        }
        return answer;
    }
}