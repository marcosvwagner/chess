import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BispoTest {

    @Test
    public void movimentoTest(){
        Bispo bispoTest = new Bispo(4,4,false,"teste");
        Assertions.assertFalse(bispoTest.movimento(5,4));
        Assertions.assertFalse(bispoTest.movimento(4,5));
        Assertions.assertTrue(bispoTest.movimento(5,5));
        Assertions.assertTrue(bispoTest.movimento(4,6));
    }
}