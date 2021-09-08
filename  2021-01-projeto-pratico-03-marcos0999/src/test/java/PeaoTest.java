import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PeaoTest {
    @Test
    public void movimentoTest(){
        Peao peaoTest = new Peao(4,4);
        Assertions.assertFalse(peaoTest.movimento(5,4),"peão não movimenta em x");
        Assertions.assertFalse(peaoTest.movimento(4,7),"peão não movimenta mais de 2 casas em y");
        Assertions.assertTrue(peaoTest.movimento(4,6),"pode movimentar 2 casas no primeiro movimento");
        Assertions.assertFalse(peaoTest.movimento(4,8),"movimentando 2 casas depois do primeiro movimento");
        Assertions.assertTrue(peaoTest.movimento(4,7));
    }

}