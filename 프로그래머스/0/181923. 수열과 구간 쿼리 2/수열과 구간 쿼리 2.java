class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int a = 1000001;
        for (int i = 0; i<queries.length; i++) {
            for (int j = queries[i][0]; j<=queries[i][1]; j++) {
                if (arr[j] > queries[i][2]) {
                    a= Math.min(a, arr[j]);
                }
            }
            answer[i] = a != 1000001 ? a : -1;
            a = 1000001;
        }
        return answer;
    }
}