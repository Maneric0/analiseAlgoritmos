package Entrega1.domain.pedido;

import Entrega1.domain.produto.Produto;
import Entrega1.valueObjects.Peso;

import java.util.List;

public class Pedido {

    private final List<Produto> produtos;

    public Pedido(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Peso getPesoTotal() {

        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getPeso().getValor();
        }

        return new Peso(total);
    }
}