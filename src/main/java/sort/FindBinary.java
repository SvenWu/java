package sort;

/**
 * Created by wth on 2016/9/6.
 */
public class FindBinary {
    public static void main(String[] args){
        int arr[]={2,5,7,12,25};
        BinaryFind bf=new BinaryFind();
        bf.find(0,arr.length-1,25,arr);
    }
}
class BinaryFind{
    public void find(int leftIndex,int rightIndex,int val,int arr[])
    {
        int midIndex=(leftIndex+rightIndex)/2;
        int midVal=arr[midIndex];
//        if(leftIndex<=rightIndex) {                    //注意条件  即使在数组内也要有条件  否则栈满
            if (val < midVal) {
                find(leftIndex, midIndex - 1, val, arr);
            } else if (val > midVal) {
                find(midIndex + 1, rightIndex, val, arr);
            } else if (val == midVal) {
                System.out.print("find the index " + midIndex);
                return;
            }
    }
}
