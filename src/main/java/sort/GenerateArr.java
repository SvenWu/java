package sort;

/**
 * Created by wth on 2016/7/28.
 */

import java.util.Random;



import java.util.Random;

/**
 * Created by wth on 2016/7/28.
 */
class GenerateArr {
    public static int[] generateArr(int a,int b){
        Random random=new Random();
        int arr[]=new int[a];                //����һ�����С��100������
        for(int i=0;i<a;i++){
            arr[i]=random.nextInt(b);
//            System.out.println(arr[i]);
        }
        return arr;
    }
}
