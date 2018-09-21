package sort;

import java.util.Arrays;

/**
 * Created by wth on 2016/7/28.
 *
 * —°‘Ò≈≈–Ú
 */
public class Select {
    public static void main(String[] args){
        int arr[]=GenerateArr.generateArr(10,100);
        System.out.println(Arrays.toString(arr));
        int min=arr[0];
        int index=0;
        int temp;
//        for (int i=0;i<arr.length;i++)
//        {
//
//            min=arr[i];
//            for(int j=i;j<arr.length;j++)
//            {
//                if(min>arr[j])
//                {
//                    min=arr[j];
//                    index=j;
//                }
//            }
//            if(min!=arr[i]) {
//                temp = arr[i];
//                arr[i] = arr[index];
//                arr[index] = temp;
//            }
//
//        }
        for (int i=0;i<arr.length;i++)
        {

            min=arr[i];
            index = i;

            for(int j=i;j<arr.length;j++)
            {
                if(min>arr[j])
                {
                    min=arr[j];
                    index=j;
                }
            }

                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;


        }
        System.out.print(Arrays.toString(arr));
    }
}
