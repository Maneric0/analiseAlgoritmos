package Entrega1;

import Entrega1.domain.entrega.PacEntrega;
import Entrega1.domain.entrega.RetiradaEntrega;
import Entrega1.domain.entrega.SedexEntrega;
import Entrega1.domain.entrega.TipoEntrega;
import Entrega1.domain.pedido.Pedido;
import Entrega1.domain.produto.Produto;
import Entrega1.valueObjects.Dinheiro;
import Entrega1.valueObjects.Peso;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest {

    @Test
    void deveCalcularFretePac() {

        Produto produto = new Produto(
                "Livro",
                new Dinheiro(50),
                new Peso(0.8)
        );

        Produto produto1 = new Produto(
                "Livro",
                new Dinheiro(50),
                new Peso(0.2)
        );

        Produto produto2 = new Produto(
                "Livro",
                new Dinheiro(50),
                new Peso(0.1)
        );

        List<Produto> produtos = new ArrayList();
        produtos.add(produto);
        produtos.add(produto1);
        produtos.add(produto2);

        Pedido pedido = new Pedido(produtos);

        TipoEntrega entrega = new PacEntrega();

        double frete = entrega.calcularFrete(pedido);

        assertEquals(15, frete);
    }

    @Test
    void deveCalcularFreteSedex() {

        Produto produto = new Produto(
                "Livro",
                new Dinheiro(200),
                new Peso(0.5)
        );

        Produto produto1 = new Produto(
                "Livro",
                new Dinheiro(50),
                new Peso(0.5)
        );

        Produto produto2 = new Produto(
                "Livro",
                new Dinheiro(50),
                new Peso(0.19)
        );

        List<Produto> produtos = new ArrayList();
        produtos.add(produto);
        produtos.add(produto1);
        produtos.add(produto2);

        Pedido pedido = new Pedido(produtos);

        TipoEntrega entrega = new SedexEntrega();

        double frete = entrega.calcularFrete(pedido);

        assertEquals(49.5, frete);
    }

    @Test
    void deveCalcularFreteRetirada() {

        Produto produto = new Produto(
                "Livro",
                new Dinheiro(50),
                new Peso(1)
        );

        Pedido pedido = new Pedido(List.of(produto));

        TipoEntrega entrega = new RetiradaEntrega();

        double frete = entrega.calcularFrete(pedido);

        assertEquals(0, frete);
    }

    @Test
    void naoDevePermitirPesoNegativo() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Peso(-1);
        });

    }

    @Test
    void naoDevePermitirDinheiroNegativo() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Dinheiro(-1);
        });

    }

    @Test
    void pacNaoDeveAceitarPesoMaiorQue2kg() {

        Produto produto = new Produto(
                "Livro pesado",
                new Dinheiro(100),
                new Peso(3)
        );

        Pedido pedido = new Pedido(List.of(produto));

        TipoEntrega entrega = new PacEntrega();

        assertThrows(IllegalArgumentException.class, () -> {
            entrega.calcularFrete(pedido);
        });

    }
}