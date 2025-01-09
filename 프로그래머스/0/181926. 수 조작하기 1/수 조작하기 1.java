class Solution {
    public int solution(int n, String control) {
        char a;
        for (int i = 0; i<control.length(); i++) {
            a = control.charAt(i);
            switch(a) {
                case 'w':
                    n+=1;
                    break;
                case 's':
                    n-=1;
                    break;
                case 'd':
                    n+=10;
                    break;
                case 'a':
                    n-=10;
                    break;
            }
        }
        
        return n;
    }
}