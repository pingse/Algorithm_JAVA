class Solution {
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public int solution(int[][] board) {
        int answer = board.length * board.length;
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (board[i][j] == 1) {
                    answer--;
                    for (int k = 0; k<8; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        
                        if (ny >= board.length || ny < 0 || nx <0 || nx >= board[0].length) continue;
                        if (board[ny][nx] != 0) continue;
                        board[ny][nx] = 2;
                        answer--;
                    }
                }
            }
        }
        return answer;
    }
}