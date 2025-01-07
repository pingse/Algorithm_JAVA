class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        switch(eq) {
            case "=":
                answer = ineq.equals(">") ? (n>=m ? 1 : 0) : (n<=m ? 1 : 0);
                break;
            case "!":
                answer = ineq.equals(">") ? (n>m ? 1 : 0) : (n<m ? 1 : 0);
                break;
        }
        
        return answer;
    }
}