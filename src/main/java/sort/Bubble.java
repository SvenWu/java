package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wth on 2016/7/28.
 *
 * ð������
 */
public class Bubble {
    public static void main(String[] args){
//        Random random=new Random();
//        int arr[]=new int[10];                //����һ�����С��100������
//        for(int i=0;i<10;i++){
//            arr[i]=random.nextInt(100);
//            System.out.println(arr[i]);
//        }
        int[] arr;
//        GenerateArr genArr=new GenerateArr();
//        arr=genArr.generateArr(10,100);
        arr=GenerateArr.generateArr(10,100);
        int temp=0;  //�����м����
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
