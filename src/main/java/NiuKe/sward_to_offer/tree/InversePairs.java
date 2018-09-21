package NiuKe.sward_to_offer.tree;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.Merge;

import java.util.Arrays;

/**
 * Created by wth on 2017/5/16.
 */
@SuppressWarnings("ALL")
public class InversePairs {
    public  static int inversePairs(int[] arr){
        if(arr.length == 0) {
            return 0;
        }
        int [] copy = Arrays.copyOf(arr,arr.length);
        int count = MergeSort(arr,copy,0,arr.length-1);
        return count;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private static int MergeSort(int[] arr, int[] copy, int low, int high) {
        if(low >= high) {
            return 0;
        }
        int mid = low + (high-low)/2;
        int left = MergeSort(arr,copy,low,mid);
        int right = MergeSort(arr,copy,mid+1,high);

        int i = mid,j = high;
        int index = high;
        int count = 0;
        while(i >= low && j >= mid+1){
            if(arr[i] > arr[j]){
                copy[index--] = arr[i--];
                count += j-mid;
            }else{
                copy[index--] = arr[j--];
            }
        }
        while(i >= low){
            copy[index--] = arr[i--];
        }
        while(j >= mid+1){
            copy[index--] = arr[j--];
        }
        while(low <= high){
            arr[low] = copy[low++];
        }
        return count + left + right;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{7,5,4,6};
        System.out.println(inversePairs(arr));
    }
}
