class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int r = 0;
        int q = n;
        int tempQ = 0;
        int tempR = 0;
        while (true) {
            System.out.println(q + " " + r);
            if ((r + q) / a == 0) {
                break;
            }
            if (q / a == 0 && r != 0) {
                answer += ((q + r) / a) * b;
                tempQ = (q + r) / a * b;
                tempR = (q + r) % a;
                q = tempQ;
                r = tempR;
                
            } else {
                answer += (q / a) * b;
                tempQ = q / a * b;;
                tempR += q % a;
                q = tempQ;
                r = tempR;
            }
        }
        return answer;
    }
}