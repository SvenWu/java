package NiuKe.sward_to_offer.tree;

import java.util.LinkedList;

/**
 * Created by wth on 2017/6/4.
 */
public class MovingCount {
    boolean [][] flag;
    boolean [][] res;
//    public int movingCount(int threshold, int rows, int cols)
//    {
//        //dfs
//        int count = 0;
//        flag = new boolean[rows][cols];
//        res = new boolean[rows][cols];
//        dfs(threshold,0,0,rows,cols);
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if(res[i][j]) count++;
//            }
//        }
//        return count;
//    }
public int movingCount(int threshold, int rows, int cols)
{
    boolean[] visited=new boolean[rows*cols];
    return movingCountCore(threshold, rows, cols, 0,0,visited);
}
    private int movingCountCore(int threshold, int rows, int cols,
                                int row,int col,boolean[] visited) {
        if(row<0||row>=rows||col<0||col>=cols) return 0;
        int i=row*cols+col;
        if(visited[i]||!checkSum(threshold,row,col)) return 0;
        visited[i]=true;
        return 1+movingCountCore(threshold, rows, cols,row,col+1,visited)
                +movingCountCore(threshold, rows, cols,row,col-1,visited)
                +movingCountCore(threshold, rows, cols,row+1,col,visited)
                +movingCountCore(threshold, rows, cols,row-1,col,visited);
    }
    private boolean checkSum(int threshold, int row, int col) {
        int sum=0;
        while(row!=0){
            sum+=row%10;
            row=row/10;
        }
        while(col!=0){
            sum+=col%10;
            col=col/10;
        }
        if(sum>threshold) return false;
        return true;
    }
    void dfs(int k, int row, int col, int rows, int cols) {
        //if(turn(row)+turn(col) > k) return;
        if(row < 0 || row >= rows || col < 0 || col >= cols ||
                turn(row)+turn(col) > k ||flag[row][col]) return;
        res[row][col] = true;
        flag[row][col] = true;
        dfs(k,row+1,col,rows,cols);
        dfs(k,row,col+1,rows,cols);
        dfs(k,row-1,col,rows,cols);
        dfs(k,row,col-1,rows,cols);
        flag[row][col] = false;
    }
    int turn(int m){
        int count = 0;
        while(m != 0) {
            count += m%10;
            m /= 10;
        }
        return count;
    }

    int bfs(int k, int rows,int cols) {
        int row = 0, col = 0;
        flag = new boolean[rows][cols];
        if(row < 0 || row >= rows || col < 0 || col >= cols ||
                turn(row)+turn(col) > k ||flag[row][col]) return 0;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int count = 0;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        flag[0][0] = true;
        while(!queue.isEmpty()) {
            int [] arr = queue.poll();
            count++;
            for(int[] dir : dirs) {
                 row = arr[0] + dir[0];
                 col = arr[1] + dir[1];
                if(row < 0 || row >= rows || col < 0 || col >= cols ||
                        turn(row)+turn(col) > k ||flag[row][col]) continue;
                flag[row][col] = true;
                //count++;
                queue.offer(new int[]{row,col});
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(new MovingCount().movingCount(5, 10, 10));
        System.out.println(new MovingCount().bfs(5, 10, 10));
    }
}
