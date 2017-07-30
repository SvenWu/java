package sort;

/**
 * Created by wth on 2017/5/15.
 */
public class Randomized_select {
    public int the_Kth_largest(int[] arr){
        int len = arr.length;
        //int mid = arr.length >> 1;   // ÖÐÎ»Êý
        int mid = arr.length-4;
        int low = 0, high = len -1;
        int index = partition(arr,low,high);
        while(index != mid){
            if(mid > index){
                low = index+1;
                index = partition(arr,low,high);
            }else {
                high = index-1;
                index = partition(arr,low,high);
            }
        }
        return arr[index];
    }

    int partition(int[] arr, int low, int high){
        int pivotKey = arr[low];
        while(low < high){
            while (low < high && pivotKey <= arr[high]) high--;
            arr[low] = arr[high];
            while (low < high && pivotKey >= arr[low]) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivotKey;
        return low;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,4,3,2,2,5};
        System.out.println(new Randomized_select().the_Kth_largest(arr));
    }
}
