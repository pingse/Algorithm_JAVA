import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[][] people = {{1, 2, 3, 4, 5},
                         {2, 1, 2, 3, 2, 4, 2, 5},
                         {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] corrects = new int[3];
        for (int i = 0; i<answers.length; i++) {
            for (int j = 0; j<3; j++) {
                if (answers[i] == people[j][i%people[j].length]) {
                    corrects[j]++;
                }
            }
        }
        int max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));
        int[] answer = IntStream.range(0, corrects.length).filter(i -> corrects[i] == max).map(i -> i+1).toArray();
        return answer;
    }
}