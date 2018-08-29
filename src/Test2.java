import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by wth on 2016/5/11.
 */
public class Test2 {
    public static void main(String args[])
    {
        int lay=5;
        for(int i=1;i<=lay;i++)
        {
            for(int k=lay;k>i;k--)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++ )
            {
                if(i==1||i==lay) {
                    System.out.print("*");
                }else{
                    if(j==1||j==(2*i-1)){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        System.out.println(map.get(2));

        String s = "select {0} from {1}  where {0}  ?";
        System.out.println(new MessageFormat(s).format(new String[]{"name","haha"}));

        int a = 123;
        System.out.println(Integer.toBinaryString(a));

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        System.out.println(streamOfArrayFull);
    }
}
