package Entrega2;

import Entrega2.domain.acao.Acao;
import Entrega2.domain.investidor.Investidor;
import Entrega2.domain.ordem.Ordem;
import Entrega2.domain.ordem.TipoOrdem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test {
    @Test
    void deveNotificarInvestidorQuandoHouverMatch() {

        Acao acao = new Acao("BBAS3", 20);

        Investidor investidor = new Investidor("Mariana");
        acao.adicionarObservador(investidor);

        Ordem compra = new Ordem("Joaquim", TipoOrdem.COMPRA, 24);
        Ordem venda = new Ordem("Mariana", TipoOrdem.VENDA, 24);

        acao.registrarOrdem(compra);
        acao.registrarOrdem(venda);

        assertEquals(24, acao.valorAtual());
    }

    @Test
    void naoDeveRealizarMatchComValoresDiferentes() {

        Acao acao = new Acao("BBAS3", 20);

        Ordem compra = new Ordem("Joaquim", TipoOrdem.COMPRA, 24);
        Ordem venda = new Ordem("Mariana", TipoOrdem.VENDA, 25);

        acao.registrarOrdem(compra);
        acao.registrarOrdem(venda);

        assertEquals(20, acao.valorAtual());
    }

    @Test
    void deveRemoverOrdensAposMatch() {

        Acao acao = new Acao("BBAS3", 20);

        acao.registrarOrdem(new Ordem("A", TipoOrdem.COMPRA, 24));
        acao.registrarOrdem(new Ordem("B", TipoOrdem.VENDA, 24));

        assertEquals(0, acao.getQuantidadeOrdens());
    }

    @Test
    void deveNotificarInvestidor() {

        Acao acao = new Acao("BBAS3", 20);

        Investidor investidor = new Investidor("Mariana");
        acao.adicionarObservador(investidor);

        acao.registrarOrdem(new Ordem("A", TipoOrdem.COMPRA, 24));
        acao.registrarOrdem(new Ordem("B", TipoOrdem.VENDA, 24));

        assertEquals(24, investidor.getUltimoValorRecebido());
    }

    @Test
    void deveCasarApenasOrdensCompativeis() {

        Acao acao = new Acao("BBAS3", 20);

        acao.registrarOrdem(new Ordem("A", TipoOrdem.COMPRA, 24));
        acao.registrarOrdem(new Ordem("B", TipoOrdem.COMPRA, 30));
        acao.registrarOrdem(new Ordem("C", TipoOrdem.VENDA, 24));

        assertEquals(24, acao.valorAtual());
    }
}
