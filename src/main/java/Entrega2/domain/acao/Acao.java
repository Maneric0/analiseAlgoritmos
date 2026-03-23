package Entrega2.domain.acao;

import Entrega2.domain.ordem.Ordem;
import Entrega2.observer.Observador;
import Entrega2.observer.Sujeito;

import java.util.ArrayList;
import java.util.List;

public class Acao implements Sujeito {

    private final String nome;
    private double valor;

    private final List<Ordem> ordens = new ArrayList<>();
    private final List<Observador> observadores = new ArrayList<>();

    public Acao(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public void registrarOrdem(Ordem ordem) {
        ordens.add(ordem);
        tentarMatch();
    }

    private void tentarMatch() {

        for (Ordem compra : ordens) {
            if (compra.isCompra()) {

                for (Ordem venda : ordens) {
                    if (venda.isVenda() && compra.getValor() == venda.getValor()) {

                        this.valor = compra.getValor();

                        ordens.remove(compra);
                        ordens.remove(venda);

                        notificar();
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {
        for (Observador obs : observadores) {
            obs.atualizar(nome, valor);
        }
    }

    public int getQuantidadeOrdens() {
        return ordens.size();
    }

    public double valorAtual() {
        return valor;
    }
}