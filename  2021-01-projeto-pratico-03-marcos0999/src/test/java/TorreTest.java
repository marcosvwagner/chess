import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TorreTest {
    @Test
    public void movimentoTest(){
        Torre TorreTest = new Torre(4,4);
        Assertions.assertFalse(TorreTest.movimento(5,5),"torre não pode movimentar em diagonal");
        Assertions.assertTrue(TorreTest.movimento(5,4),"torre movimenta em x ou y, sem limites de casas");
        Assertions.assertTrue(TorreTest.movimento(5,8));
    }
}