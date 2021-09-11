import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReiTest {

    @Test
    public void movimentoTest(){
        Rei reiTest = new Rei(4,4,false,"teste");
        Assertions.assertFalse(reiTest.movimento(6,4));
        Assertions.assertFalse(reiTest.movimento(5,6));
        Assertions.assertTrue(reiTest.movimento(5,4));
        Assertions.assertTrue(reiTest.movimento(5,5));
    }
}
