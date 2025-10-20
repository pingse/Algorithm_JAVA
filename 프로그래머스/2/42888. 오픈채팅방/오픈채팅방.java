import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        Map<String, String> str = new HashMap<>();
        str.put("Enter", "님이 들어왔습니다.");
        str.put("Leave", "님이 나갔습니다.");
        
        Map<String, String> name = new HashMap<>();
        
        for (int i = 0; i<record.length; i++) {
            String[] arr = record[i].split(" ");
            
            if (arr[0].equals("Change")) {
                name.put(arr[1], arr[2]);
                continue;
            }
            
            if (arr[0].equals("Enter")) {
                name.put(arr[1], arr[2]);
            }
            list.add(arr[0] + " " + arr[1]);
        }
        
        answer = list.toArray(new String[list.size()]);
        
        for (int i = 0; i<answer.length; i++) {
            String[] temp = answer[i].split(" ");
            
            answer[i] = name.get(temp[1])+str.get(temp[0]);
        }
        
        return answer;
    }
}