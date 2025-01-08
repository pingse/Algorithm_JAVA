class Solution {
    public int solution(int[] num_list) {

        int total = 1;
        int sum = 0;
        
        for (int i = 0; i<num_list.length; i++) {
            total *= num_list[i];
            sum += num_list[i];
        }
        sum *= sum;
        
        return sum > total ? 1 : 0;
    }
}