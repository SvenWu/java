package leetcode.bitManipulation;

/**
 * @author sven (bjwthwu@cn.ibm.com)
 * @date 2020/12/2
 */

/**
 * 涉及到方向上的问题  统一使用8个方向的2维数组来表示。
 */
public class GameOfLife_289 {
    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countLive(board,i,j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] = 3;
                    }
                }else {
                    if (count ==3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public int countLive(int[][] board,int i, int j) {
        int[][] dirs = {{-1,1},{-1,0},{-1,-1},{0,1},{0,-1},{1,1},{1,0},{1,-1}};
        int count = 0;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >=0 && x < board.length && y < board[0].length) {
                count += board[x][y] & 1;
            }
        }

        return count;
    }
}
