package Entrega2.domain.investidor;

import Entrega2.observer.Observador;

public class Investidor implements Observador {

    private final String nome;
    private double ultimoValorRecebido;

    public Investidor(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String nomeAcao, double novoValor) {
        this.ultimoValorRecebido = novoValor;
    }

    public double getUltimoValorRecebido() {
        return ultimoValorRecebido;
    }
}