package Entrega1.domain.produto;

import Entrega1.valueObjects.Dinheiro;
import Entrega1.valueObjects.Peso;

public class Produto {

    private final String nome;
    private final Dinheiro preco;
    private final Peso
            peso;

    public Produto(String nome, Dinheiro preco, Peso peso) {
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
    }

    public Peso getPeso() {
        return peso;
    }

    public Dinheiro getPreco() {
        return preco;
    }
}