import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PeaoTest {
    @Test
    public void movimentoTest(){
        Peao peaoTestBranco = new Peao(4,4,false);
        Assertions.assertFalse(peaoTestBranco.movimento(4,3),"peão branco não pode se movimentar para baixo");
        Assertions.assertFalse(peaoTestBranco.movimento(5,4),"peão não movimenta em x");
        Assertions.assertFalse(peaoTestBranco.movimento(4,7),"peão não movimenta mais de 2 casas em y");
        Assertions.assertTrue(peaoTestBranco.movimento(4,6),"pode movimentar 2 casas no primeiro movimento");
        Assertions.assertFalse(peaoTestBranco.movimento(4,8),"movimentando 2 casas depois do primeiro movimento");
        Assertions.assertTrue(peaoTestBranco.movimento(4,7));

        Peao peaoTestPreto = new Peao(4,4,true);
        Assertions.assertFalse(peaoTestPreto.movimento(4,5),"peão preto não pode se movimentar para cima");
        Assertions.assertFalse(peaoTestPreto.movimento(5,4),"peão não movimenta em x");
        Assertions.assertFalse(peaoTestPreto.movimento(4,1),"peão não movimenta mais de 2 casas em y");
        Assertions.assertFalse(peaoTestPreto.movimento(4,8),"movimentando 2 casas depois do primeiro movimento");
        Assertions.assertTrue(peaoTestPreto.movimento(4,2),"pode movimentar 2 casas no primeiro movimento");
        Assertions.assertTrue(peaoTestPreto.movimento(4,1));

    }

    @Test
    void ataqueTest() {
        Peao peaoTestBranco = new Peao(4,4,false);
        Assertions.assertFalse(peaoTestBranco.ataque(4,5),"peão não ataca para frente");
        Assertions.assertTrue(peaoTestBranco.ataque(5,5),"peão só ataca em diagonal");
        Assertions.assertFalse(peaoTestBranco.ataque(4,4),"peão branco não ataca para tras");
        Assertions.assertTrue(peaoTestBranco.ataque(4,6));

        Peao peaoTestPreto = new Peao(4,4,true);
        Assertions.assertFalse(peaoTestPreto.ataque(4,3),"peão não ataca para frente");
        Assertions.assertTrue(peaoTestPreto.ataque(3,3),"peão só ataca em diagonal");
        Assertions.assertFalse(peaoTestPreto.ataque(4,4),"peão preto não ataca para tras");
        Assertions.assertTrue(peaoTestPreto.ataque(4,2));
    }
}