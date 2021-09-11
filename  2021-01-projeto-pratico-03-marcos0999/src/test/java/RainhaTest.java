import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RainhaTest {

    @Test
    public void movimentoTest(){
        Rainha RainhaTest = new Rainha(4,4,false,"teste");
        Assertions.assertFalse(RainhaTest.movimento(6,5),"rainha só pode se movimentar em uma direção por vez");
        Assertions.assertTrue(RainhaTest.movimento(4,8));
        Assertions.assertTrue(RainhaTest.movimento(8,8));
    }

}