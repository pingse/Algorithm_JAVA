class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i<numbers.length; i++) {
            String target = Long.toBinaryString(numbers[i]);
            
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i]+1;
            } else {
                int idx = target.lastIndexOf("0");
                
                if (idx == -1) {
                    target = "10" + target.substring(1);
                    answer[i] = Long.parseLong(target,2);
                } else {
                    target = target.substring(0, idx) + "10" + target.substring(idx+2);
                    answer[i] = Long.parseLong(target,2);
                }
            }
        }
        return answer;
    }
}