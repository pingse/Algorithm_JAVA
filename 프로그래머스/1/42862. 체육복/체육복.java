import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] people = new int[n+2];
        
        for (int i : lost) {
            people[i]--;
        }
        
        for (int i : reserve) {
            people[i]++;
        }
        
        for (int i = 0; i<people.length; i++) {
            if (people[i] == -1) {
                if (people[i-1] == 1) {
                    people[i-1]--;
                    people[i]++;
                } else if (people[i+1] == 1) {
                    people[i+1]--;
                    people[i]++;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}