package sort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by wth on 2016/8/1.
 */
public class Insertion {
    public static void main(String[] args){
        int arr[];
        arr=GenerateArr.generateArr(10,100);
        System.out.println(Arrays.toString(arr));
//        if(arr.length!=1){
//            for (int i=1;i<arr.length;i++)
//            {
//                int index=0;
//                int temp=arr[i];
//                int j=0;
//                while (index<arr.length&&arr[i]>arr[index])
//                {
//                    index++;
//                }
////                index--;
//                for(j=i-1;j>=index;j--)               //����������ӵ�һ����ʼ�ȶ� ��Ƚ��鷳  ������±�����Խ���ֵ
//                {
//                    arr[j+1] = arr[j];
//                }
//                arr[index]=temp;
//            }
//            System.out.print(Arrays.toString(arr));
//        }else {
//            System.out.print(arr[0]);
//        }
        if(arr.length!=1){
            for (int i=1;i<arr.length;i++)
            {
                int insertVal=arr[i];
                int index=i-1;
                while (index>=0&&insertVal<arr[index])             //����Ļ���while��С�ڱȽϺ�
                {                                                //!!!!  &&����һ����������֮�󣬺������������ִ���ˣ�
                                                                // ��&���Ǽ���ִ�У�ֱ�������������ִ����Ϊֹ��
                    arr[index+1]=arr[index];
                    index--;
                }
                arr[index+1]=insertVal;
            }
            System.out.println(Arrays.toString(arr));
        }else {
            System.out.print(arr[0]);
        }
    }
}