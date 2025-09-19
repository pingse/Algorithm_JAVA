class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a != b) {
            if (a % 2 == 1) {
                a /= 2;
                a += 1;
            } else {
                a /= 2;
            }
            
            if (b % 2 == 1) {
                b /= 2;
                b += 1;
            } else {
                b /= 2;
            }
            answer++;
        }

        return answer;
    }
}