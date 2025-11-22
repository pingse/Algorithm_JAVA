import java.util.*;

class Solution {
    public List<String> solution(String[] strArr) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i<strArr.length; i++) {
            if (strArr[i].equals(strArr[i].replace("ad", ""))) {
                answer.add(strArr[i]);
            }
        }
        return answer;
    }
}