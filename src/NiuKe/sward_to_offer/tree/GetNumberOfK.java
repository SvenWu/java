package NiuKe.sward_to_offer.tree;

/**
 * Created by wth on 2017/5/16.
 */
public class GetNumberOfK {
    public int getNumberOfK(int[] array, int k){
        if(array.length == 0) {
            return 0;
        }
        int firstK = getFirstK(array,k,0,array.length-1);
        int lastK = getLastK(array,k,0,array.length-1);

        return (firstK != -1 && lastK != -1) ? lastK - firstK + 1 : 0 ;
    }
    int getFirstK(int[] arr,int k, int low, int high){
        if(low > high) {
            return -1;
        }
        int mid = low + (high-low)/2;
        if(arr[mid] == k){
            if(mid == 0 || arr[mid-1] != k){
                return mid;
            }else {
                high = mid -1;
            }
        }else if(arr[mid] > k){
            high = mid -1;
        }else {
            low = mid + 1;
        }
        return getFirstK(arr,k,low,high);
    }

    int getLastK(int[] arr,int k, int low, int high){
        if(low > high) {
            return -1;
        }
        int mid = low + (high-low)/2;
        if(arr[mid] == k){
            if(mid == arr.length-1 || arr[mid+1] != k){
                return mid;
            }else {
                low = mid + 1;
            }
        }else if(arr[mid] > k){
            high = mid -1;
        }else {
            low = mid + 1;
        }
        return getLastK(arr,k,low,high);
    }
}
