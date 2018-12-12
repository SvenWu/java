import static org.junit.Assert.*;

public class PiloTest {

    @org.junit.Test
    public void getPilo() {
        String s =     	"select IIORXOR  " +
                "from {0}.TATORD " +
                "WHERE ({1}) " +
                "AND IORDORD in (select IORDORD from {0}.TATEVT " +
                "WHERE SEVTAUD >=  CURRENT TIMESTAMP - {2} HOURS " +
                "AND CETYCDE = 595 )" ;

        String[] str = {"PILPROD","IORDCUS like '%?%'","24"};

        System.out.println(new Pilo().getPilo(s,str));
    }
}