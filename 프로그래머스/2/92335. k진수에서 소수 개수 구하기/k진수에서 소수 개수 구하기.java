import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convert = conversion(n, k);
        String[] arr = convert.split("0");
        for (String s : arr) {
            if (s.equals("")) continue;
            if (checkPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public String conversion(int number, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(number > 0) {
            sb.append(Integer.toString(number%k));
            number /= k;
        }
        
        return sb.reverse().toString();
    }
    
    public boolean checkPrime(long number) {
        if (number == 1) {
            return false;
        }
        
        if (number == 2) {
            return true;
        }
        
        for (int i = 2; i<= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    } 
}