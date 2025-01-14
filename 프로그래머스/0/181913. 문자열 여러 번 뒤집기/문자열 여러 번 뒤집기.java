class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        int start;
        int end;
        
        for (int i = 0; i<queries.length; i++) {
            start = queries[i][0];
            end = queries[i][1] + 1;
            
            String substring = sb.substring(start, end);
            StringBuilder sbReverse = new StringBuilder(substring).reverse();
            sb.replace(start, end, sbReverse.toString());
        }
        
        return sb.toString();
    }
}