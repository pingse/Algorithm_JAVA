import java.util.*;

class Solution {
    static final Map<String, Integer> INDEX_MAP = Map.of(
        "code", 0,
        "date", 1,
        "maximum", 2,
        "remain", 3
    );
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        final int type = INDEX_MAP.get(ext);
        final int sort = INDEX_MAP.get(sort_by);
        
        for (int i = 0; i<data.length; i++) {
            if (data[i][type] < val_ext) answer.add(data[i]);
        }
        
        Collections.sort(answer, (o1, o2) -> o1[sort] - o2[sort]);
        return answer.toArray(int[][]::new);
    }
}