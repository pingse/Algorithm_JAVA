class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};
        String[] impossible = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for (String b : babbling) {
            int count = 0;
            
            for (String i : impossible) {
                b = b.replace(i, "X");
            }
            
            for (String p : possible) {
                b = b.replace(p, "O");
            }
            
            for (char c : b.toCharArray()) {
                if (c != 'O') {
                    count++;
                }
            }
            
            if (count == 0) answer++;
        }
        return answer;
    }
}