package leetcode.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wth on 2017/4/11.
 */
public class Main {
    /**
     * 542. 01 Matrix
     * */
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix.get(i).get(j) == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    matrix.get(i).set(j,Integer.MAX_VALUE);
                }
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}}; //ÉÏÏÂ×óÓÒ²Ù×÷Ë³Ðò
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int row = cell[0]+d[0];
                int col = cell[1]+d[1];
                if(row<0 || row>=m || col<0 || col>=n ||
                        matrix.get(row).get(col) <= matrix.get(cell[0]).get(cell[1]) +1) {
                    continue;
                }
                matrix.get(row).set(col,matrix.get(cell[0]).get(cell[1]) +1);
                queue.offer(new int[]{row,col});
            }
        }
        return matrix;
    }
}
