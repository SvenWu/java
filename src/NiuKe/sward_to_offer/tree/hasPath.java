package NiuKe.sward_to_offer.tree;

import java.util.LinkedList;

/**
 * Created by wth on 2017/6/4.
 */
public class hasPath {
    boolean[][] flag;
    boolean res = false;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
//        //bfs版本   好像不大行
//        if(rows == 0 ^ str.length == 0) return false;
//        if(rows == 0 && str.length == 0) return true;
//        char[][] path = new char[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                path[i][j] = matrix[i*rows+j];
//            }
//        }
//        boolean[][] flag = new boolean[rows][cols];
//
//        int len = str.length;
//
//        LinkedList<int[]> queue = new LinkedList<>();
//        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                int pos = 0;
//                if(!flag[i][j] && str[pos] == path[i][j]) {
//                    queue.add(new int[]{i,j});
//                }
//                while(!queue.isEmpty()) {
//                    int[] res = queue.poll();
//                    pos++;
//                    for (int[] a : dir) {
//                        int row = res[0] + a[0];
//                        int col = res[1] + a[1];
//                        if(row < 0 || row >= rows || col < 0 || col >= cols
//                                || flag[row][col] || path[row][col] != str[pos]) continue;
//                        if(pos == len-1) return true;
//                        queue.add(new int[]{row,col});
//                        flag[row][col] = true;
//                    }
//                }
//            }
//        }


        if(rows == 0 ^ str.length == 0) return false;
        if(rows == 0 && str.length == 0) return true;
        flag = new boolean[rows][cols];
        char[][] path = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    path[i][j] = matrix[i*cols+j];
                }
            }
            int len = str.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                backtrack(path,str,0,i,j);
            }
        }
        return res;
    }

    public void backtrack(char[][] path, char[] str, int pos, int row , int col) {
        if(pos == str.length) {
            res = true;
            return;
        }
        if(row < 0 || row >= path.length || col < 0 || col >= path[0].length
                || flag[row][col] || path[row][col] != str[pos]) return;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        flag[row][col] = true;
        for (int[] a : dirs) {
            backtrack(path,str,pos+1,row+a[0],col+a[1]);
        }
        flag[row][col] = false;
        pos--;
    }

    public static void main(String[] args) {
        char[] matrix = new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'};
        int rows = 3;
        int cols = 4;
        char[] str = "ABCCED".toCharArray();
        System.out.println(new hasPath().hasPath(matrix,rows,cols,str));
    }
}
