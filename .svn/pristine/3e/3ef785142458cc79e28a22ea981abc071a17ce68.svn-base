package sort;

/**
 * Created by wth on 2017/3/29.
 */
public class quickSort {
    void sort(int[] num, int low , int high)
    {
        int pivot;
        if(low < high)
        {
            pivot = partition(num,low,high);
            sort(num,low,pivot);
            sort(num,pivot+1,high);
        }
    }
    int partition(int[] num,int low, int high){
        int pivotkey = num[low];
        int temp;
        while(low < high)
        {
            while(low<high && num[high] >= pivotkey) high--;
//            temp = num[high];
//            num[high] = num[low];
//            num[low] = temp;
            num[low] = num[high];
            while (low<high && num[low] <= pivotkey) low++;
//            temp = num[low];
//            num[low] = num[high];
//            num[high] = temp;
            num[high] = num[low];
        }
        num[low] = pivotkey;
        return low;
    }


    public static void main(String[] args){
        int [] num = new int[]{3,1,4,5,2,6,3,4};
        new quickSort().sort(num,0,num.length-1);
        for(int i : num)
        {
            System.out.print(i+" ");
        }
    }
}
