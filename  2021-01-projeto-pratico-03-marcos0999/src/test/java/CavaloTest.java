import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CavaloTest {
    @Test
    public void movimentoTest(){
        Cavalo CavaloTest = new Cavalo(4,4,false);
        Assertions.assertFalse(CavaloTest.movimento(5,4),"cavalo não movimenta em x");
        Assertions.assertFalse(CavaloTest.movimento(4,5),"cavalo não movimenta em y");
        Assertions.assertTrue(CavaloTest.movimento(5,6),"cavalo movimenta 2 casas de uma direção e 1 na outra direção");
        Assertions.assertTrue(CavaloTest.movimento(3,5));
    }

}