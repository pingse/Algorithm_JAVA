import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, Map<Integer, Integer>> nums = new HashMap<>();
        
        for (int i = 0; i<genres.length; i++) {
            if (!totalPlays.containsKey(genres[i])) {
                Map<Integer, Integer> map = new HashMap<>();
                
                totalPlays.put(genres[i], plays[i]);
                map.put(i, plays[i]);
                nums.put(genres[i], map);
            } else {
                totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
                nums.get(genres[i]).put(i, plays[i]);
            }
        }
        
        List<String> genreKeys = new ArrayList<>(totalPlays.keySet());
        Collections.sort(genreKeys, (o1, o2) -> totalPlays.get(o2) - totalPlays.get(o1));
        
        List<Integer> ans = new ArrayList<>();
        for (String key : genreKeys) {
            Map<Integer, Integer> num = nums.get(key);
            List<Integer> list = new ArrayList<>(num.keySet());
            Collections.sort(list, (o1, o2) -> num.get(o2) - num.get(o1));
            
            ans.add(list.get(0));
            if (list.size() > 1) {
                ans.add(list.get(1));
            }
        }
        
        answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}