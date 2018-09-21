package sort;

/**
 * Created by wth on 2017/3/29.
 */
public class mergeSort {
    void sort(int[] nums, int low, int high)
    {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    void merge(int[]nums,int low , int mid, int high){
        int [] temp = new int [nums.length];
        int k = low;
        int i = low,j = mid+1;
        int  tmp = low;
        for(; i<=mid && j<=high ; k++)
        {
            if(nums[i] < nums[j]) {
                temp[k] = nums[i++];
            } else {
                temp[k] = nums[j++];
            }
        }
        while(i<=mid)
        {
            temp[k++] = nums[i++];
        }
        while(j<=high)
        {
            temp[k++] = nums[j++];
        }
        while( tmp <= high)
        {
            nums[tmp] = temp[tmp++];
        }
    }

    void quickSort(int nums[],int low, int high){
        int pivot;
        if(low < high)
        {
            pivot = partition(nums,low,high);
            quickSort(nums,low,pivot);
            quickSort(nums,pivot+1,high);
        }
    }
    int partition (int[] nums,int low, int high){
        int pivotkey = nums[low];
        while(low<high) {
            while (low<high && nums[high] > pivotkey) {
                high--;
            }
            nums[low] = nums[high];
            while (low<high && nums[low] < pivotkey) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivotkey;
        return low;
    }
    public static void main(String[] args){
        int [] num = new int[]{53,324,564,33,57,76,422,242,54,3};
        new mergeSort().sort(num,0,num.length-1);
        for(int i : num)
        {
            System.out.print(i+" ");
        }
    }

}
