class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int a;
        for (int i =1; i<numLog.length; i++) {
            a = numLog[i] - numLog[i-1];
            
            switch(a) {
                case 1:
                    sb.append("w");
                    break;
                case -1:
                    sb.append("s");
                    break;
                case 10:
                    sb.append("d");
                    break;
                case -10:
                    sb.append("a");
                    break;
            }
        }
        answer = sb.toString();
        return answer;
    }
}