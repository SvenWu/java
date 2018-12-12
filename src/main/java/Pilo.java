import java.text.MessageFormat;

public class Pilo {
    public String getPilo(String s, String[] str) {
        MessageFormat messageFormat = new MessageFormat(s);
        doSth();
        return messageFormat.format(str);
    }

    public void doSth() {
        //sth
    }
}
