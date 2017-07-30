package leetcode.array;

import java.util.*;

/**
 * Created by wth on 2016/10/13.
 */
public class Solution {
//    public int[] searchRange(int[] nums, int target) {
//        int tar=findTarget(nums, target);
//        int []ran={-1,-1};
//        int len=nums.length;
//        int hi=len-1,lo=0;
//        int mid;
//        if(tar==-1)  return ran;
//        while(tar)
//
//    }
//    public int findTarget(int[]nums,int target){
//        int len=nums.length;
//        int hi=len-1,lo=0;
//        int mid;
//        while(lo<=hi)
//        {
//            mid=(lo+hi)/2;
//            if(nums[mid]==target)  return mid;
//            if(nums[mid]<target)  lo=mid+1;
//            else hi=mid-1;
//        }
//        return -1;
//    }



    public int searchInsert(int[] nums, int target) {   //35
        int len = nums.length;
        int hi = len - 1, lo = 0;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {//39   用到了DFS算法
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target,int start) {
        if (target > 0) {
            for (int i = start;i < candidates.length&&target>=candidates[i];i++) { // not using the condition "target >= candidates[i]"
                cur.add(candidates[i]);
                dfs(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        }
        if (target == 0) result.add(new ArrayList<Integer>(cur));   //为什么要实例化  cur
    }


    /**
         40  保证集合没用重复可以在循环中加入  if (i > start && cand[i] == cand[i-1]) continue;
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>  list=new ArrayList<>();
        dfs2(result, list, candidates, target, 0);
        Set<List<Integer>> set=new HashSet<>(result);
//        List<List<Integer>> result1 = new ArrayList<>();
        result.removeAll(result);
        result.addAll(set);
//        result1.addAll(set);


        return result;
    }
    public void dfs2(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target,int start){
        if(target==0)   result.add(new ArrayList<Integer>(cur));
        if(target>0){
            for(int i=start;i<candidates.length;i++){
                cur.add(candidates[i]);
                dfs2(result, cur, candidates, target - candidates[i], i + 1);
                cur.remove(cur.size()-1);
            }
        }
    }

    /**
     *   42
     * @param
     */
    public int trap(int[] height) {
        if (height.length<=2)  return 0;
        int left=0;int right=height.length-1;
        int area=0;
        int maxleft=height[left],maxright=height[right];
        while (left<right){
            if(maxleft<=maxright)
            {
                if(maxleft>=height[++left])
                {
                    area+=maxleft-height[left];
                }else {
                    maxleft=height[left];
                }
            }
            if(maxleft>maxright)
            {
                if(maxright>=height[--right])
                {
                    area+=maxright-height[right];
                }else {
                    maxright=height[right];
                }
            }
        }
        return area;
    }


    /**
     *    45   如果用贪心算法求解   找到下一步能达到最远的地方  然后前进
     * @param
     */
    public int jump(int[] nums) {
        int reach=0;
        int last=0;
        int step=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>=last){
                step++;
                last=reach;
            }
            reach=Math.max(reach,nums[i]+i);
        }
        return step;
    }


    /**
     *      48   rotage image
     * @param
     */


    public void rotate(int[][] matrix) {
        //转置
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //延对称轴翻转
        for(int j=0;j<(n+1)/2;j++)
        {
            for(int i=0;i<n;i++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][j];
                matrix[n-1-i][j]=temp;
            }
        }
    }


    /**
     * 53. Maximum Subarray
     * @param
     */

    public int maxSubArray(int[] nums) {
        int currentmax=nums[0];
        int max=0;
        for(int i=1;i<nums.length; i++)
        {
            currentmax=Math.max(nums[i],currentmax+nums[i]);
            max=Math.max(currentmax,max);
        }
        return max;
    }


    /**
     *54. Spiral Matrix
     * @param
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int row=0,col=0;
        if(matrix.length==0)  return l;
        int rowEnd=matrix.length-1;
        int colEnd=matrix[0].length-1;
        while(col<=colEnd&&row<=rowEnd){
            //左到右
            for(int i=col;i<=colEnd;i++)
            {
                l.add(matrix[row][i]);
            }
            row++;


            //右边到下
            for (int i=row;i<=rowEnd;i++)
            {
                l.add(matrix[i][colEnd]);

            }
            colEnd--;


            if(rowEnd>=row)
            {
                //下到左
                for(int i=colEnd;i>=col;i--)
                {
                    l.add(matrix[rowEnd][i]);
                }

            }
            rowEnd--;
            if(colEnd>=col){
                //左边到上
                for(int i=rowEnd;i>=row;i--)
                {
                    l.add(matrix[i][col]);
                }

            }
            col++;
        }

        return l;
    }

    /**
     * 55. Jump Game
     * @param
     */

    public boolean canJump(int[] nums) {
        int currentMax=0;
        for(int i=0;i<nums.length; i++)
        {
            currentMax=Math.max(currentMax,nums[i]+i);
            if(currentMax<i+1) return false;
        }
        return true;
    }



    /**
     56. Merge Intervals
     */
    public class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
         }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==0) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        // List<Interval> res = new ArrayList<>();
        // int start = intervals.get(0).start;
        // int end = intervals.get(0).end;

        Iterator<Interval> it = intervals.iterator();
        // int start;
        // int end = Integer.MIN_VALUE;
        Interval cur = it.next();
        while (it.hasNext()){
            Interval next = it.next();
            if(next.start<=cur.end) {
                cur.end = Math.max(cur.end, next.end);
                it.remove();
            }
            else {
                cur=next;
            }
        }
        return intervals;
    }


    /**
     57. Insert Interval
     */
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        int start = newInterval.start;
//        int end = newInterval.end;
//        //if(intervals.isEmpty()) {return intervals.add(newInterval);}
////        Iterator<Interval>  it = intervals.iterator();
////        Interval cur =it.next();
////        while(it.hasNext())
////        {
////            Interval next = it.next();
////            if()
////        }
//        int curStart = intervals.get(0).start;
//        int curEnd = intervals.get(0).end;
//        List<Interval> res = new ArrayList<>();
//        if(end<curStart){
//            intervals.add(0,newInterval);
//            return intervals;
//        }
//        if(start>intervals.get(intervals.size()-1).end){
//            intervals.add(intervals.size(),newInterval);
//            return intervals;
//        }
//        for(Interval i : intervals)
//        {
//            curStart = Math.min(i.start,start);
//
//
//
//        }
//    }


    /**
     * 59. Spiral Matrix II         Arrays.deepToString  可以直接输出2维数组
     * */
    public static int[][] generateMatrix(int n) {
        int row=0,col=0;
        int rowEnd = n-1;
        int colEnd = n-1;
        int [][] res = new int[n][n];
        if(n==0) return res;
        res[0][0]=1;
        if(n==1) return res;
        int count = 1;
        while(col<=colEnd&&row<=rowEnd)
        {
            for(int i=col;i<=colEnd;i++)
            {
                res[row][i] = count;
                count++;
            }
            row++;

            for(int i=row;i<=rowEnd;i++)
            {
                res[i][colEnd] = count++;
            }
            colEnd--;

            for(int i=colEnd;i>=col;i--)
            {
                res[rowEnd][i] =count++;
            }
            rowEnd--;
            if(rowEnd>=row)
            {
                for(int i=rowEnd;i>=row;i--)
                {
                    res[i][col]=count++;
                }
            }

            col++;
        }

        return res;
    }


    /**
     *
     */

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] path = new int [m][n];
        int index1 = n;
        int index2 = m;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0){
                    if( obstacleGrid[m-1-i][n-1-j]==1){
                        index1=j;
                        path[i][j] = 0;
                    }else if(index1<j){
                        path[i][j] = 0;
                    }else{
                        path[i][j] = 1;
                    }
                }
                if(j==0){
                    if( obstacleGrid[m-1-i][n-1-j]==1){
                        index2=i;
                        path[i][j] = 0;
                    }else if(index2<i){
                        path[i][j] = 0;
                    }else{
                        path[i][j] = 1;
                    }
                }
                else if(i>0&&j>0){
                    // if(obstacleGrid[i][j]==1)
                    path[i][j] = path[i][j-1]+path[i-1][j];

                }
                path[i][j]= obstacleGrid[m-1-i][n-1-j]==1?0:path[i][j];
            }
        }
        return path[m-1][n-1];
    }



    /**
     * 64. Minimum Path Sum
     * */

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=1;i<m;i++){grid[i][0] +=grid[i-1][0];}
        for(int i=1;i<n;i++){grid[0][i] += grid[0][i-1];}
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    /**
     * 503. Next Greater Element II
     * */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int []res = new int[len];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<len;i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for(int i=0;i<len;i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                res[stack.pop()] = nums[i];
            }
        }
        while(!stack.isEmpty())
        {
            res[stack.pop()] = -1;
        }
        return res;
    }

    /**
     * 451. Sort Characters By Frequency
     * */
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char [] c = s.toCharArray();
        for(char c1 : c)
        {
            if(map.containsKey(c1)) map.put(c1,map.get(c1)+1);
            else map.put(c1,1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
            @Override
            public int compare(Map.Entry<Character,Integer> map1,Map.Entry<Character,Integer> map2){
                return map2.getValue()-map1.getValue();
            }

        });
//        String res = "";
//        for(Map.Entry<Character,Integer> m : list)
//        {
//            while(m.getValue()>0){
//                res = res + String.valueOf(m.getKey());
//                map.put(m.getKey(),m.getValue()-1);
//            }
//
//        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).getValue();j++)
            {
                sb.append(list.get(i).getKey());
            }
        }
        return sb.toString();
    }



    public int num(int a){
        a++;
        return a;
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for(Integer num : nums)
        {
            if(map.containsKey(num))  map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> map1,Map.Entry<Integer,Integer> map2){
                return map2.getValue()-map1.getValue();
            }
        });
        for(int i=0;i<k;i++)
        {
            res.add(list.get(i).getKey());
            System.out.println(list.get(i).getValue());
        }
        return res;
    }

    /**
     *150. Evaluate Reverse Polish Notation
     * */
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String op = "+-*/";
        int res = 0;
        if(tokens.length ==1 )return Integer.parseInt(tokens[0]);
        for(String t : tokens)
        {
            if(!op.contains(t))  {stack.push(t);}
            else {
                int  op1;//第一个运算数
                int  op2;//第二个
                //不考虑会超界
                op2 = Integer.parseInt(stack.pop());
                //if(stack.isEmpty()) return op2;
                op1 = Integer.parseInt(stack.pop());
                res = eval(op1,op2,t);
                stack.push(""+res);
            }
        }
        return res;
    }
    int eval(int a,int b,String s){
        if(s.equals("+")) return a + b;
        if(s.equals("-")) return a - b;
        if(s.equals("*")) return a * b;
        if(s.equals("/")) return a / b;
//        PriorityQueue<int[]> pq =new PriorityQueue<>(new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]+o1[1]-o2[0]-o2[1];
//            }
//        });

        return 0;
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>();
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }

    /**
     * 179. Largest Number
     * */
//    public  String  largestNumber(int[] nums) {
//        new String("ab").compareTo("ac");
//    }


    /**
     * 324. Wiggle Sort II
     * */

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int [] clone = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            clone[i] = nums[nums.length-1-i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(1+i*2)%(nums.length | 1)] = clone[i];
        }
    }

    /**
     * 41. First Missing Positive
     *
     * */
    public int firstMissingPositive(int[] A) {
        int n=A.length;
        if(n==0)
            return 1;
        int k=partition(A)+1;
        int temp=0;
        int first_missing_Index=k;
        for(int i=0;i<k;i++){
            temp=Math.abs(A[i]);
            if(temp<=k)
                A[temp-1]=(A[temp-1]<0)?A[temp-1]:-A[temp-1];
        }
        for(int i=0;i<k;i++){
            if(A[i]>0){
                first_missing_Index=i;
                break;
            }
        }
        return first_missing_Index+1;
    }

    public int partition(int[] A){
        int n=A.length;
        int q=-1;
        for(int i=0;i<n;i++){
            if(A[i]>0){
                q++;
                swap(A,q,i);
            }
        }
        return q;
    }

    public void swap(int[] A, int i, int j){
        if(i!=j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
        }
    }




    /**
     *
     16. 3Sum Closest
     * */

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(len <= 2) return 0;
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i ++) {
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                int sum2 = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) > Math.abs(target - sum2)) {
                    sum = sum2;
                    if(sum == target) return target;
                }
                if(sum2 > target) k--;
                else j++;
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        int[] A = new int[]{1,2,4,6,8,16,32,64,128};
        //System.out.println(new Solution().firstMissingPositive(A));
        System.out.println(new Solution().threeSumClosest(A,82));
    }
//    public static void main(String args[]){
//        Solution sol=new Solution();
//        int candidates[]={2,3,5,7};
//        int obstacleGrid[][] = {{3},{1}};
//        int nums[] = new int[]{4,1,-1,2,-1,2,3};
//        String[] s ={"2","1","+","3","*"};
//        String ss= "11";
//        int a = 1;
//        int b = a;
//        a = 2;
//        //System.out.print(Float.parseFloat(ss));
//        //System.out.println(sol.combinationSum2(candidates, 8));
//        //System.out.println(Arrays.deepToString(sol.generateMatrix(2)));
//        //System.out.println(obstacleGrid[0][0]^=1);
//        //System.out.print(sol.topKFrequent(nums,2));
//        //System.out.print(sol.evalRPN(s));
//        System.out.println(new String("1").compareTo("2"));
//        String[] str = new String[]{"2","1"};
//        Arrays.sort(str);
//        System.out.println(Arrays.asList(str));
//    }
}
