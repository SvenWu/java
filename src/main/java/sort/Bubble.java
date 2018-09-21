package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wth on 2016/7/28.
 *
 * 冒泡排序
 */
public class Bubble {
    public static void main(String[] args){
//        Random random=new Random();
//        int arr[]=new int[10];                //生成一个随机小于100的数组
//        for(int i=0;i<10;i++){
//            arr[i]=random.nextInt(100);
//            System.out.println(arr[i]);
//        }
        int[] arr;
//        GenerateArr genArr=new GenerateArr();
//        arr=genArr.generateArr(10,100);
        arr=GenerateArr.generateArr(10,100);
        int temp=0;  //交换中间变量
        for(int m=0;m<arr.length-1;m++){
            for(int j=0;j<arr.length-1-m;j++){
                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print(Arrays.toString(arr));
    }
}
