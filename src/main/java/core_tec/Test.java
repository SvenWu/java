package core_tec;

/**
 * Created by wth on 2017/6/12.
 */
public class Test {
    public static void main(String[] args) {
        Father father = new Son();
        //��Ȼ������  ���Ǳ����ʱ���ǻ� ����
        //�����ڼ̳��У���������Զ�ת��Ϊ���࣬
        // ���Ǹ���ǿ��ת��Ϊ����ʱֻ�е������������������Ϊ����ʱ�Ż�ǿ��ת���ɹ�������ʧ�ܡ�
        Son son = (Son)new Father();
        son.study();
    }
}
