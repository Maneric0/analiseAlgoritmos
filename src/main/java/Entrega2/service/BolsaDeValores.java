package Entrega2.service;

import Entrega2.domain.acao.Acao;
import Entrega2.domain.investidor.Investidor;
import Entrega2.domain.ordem.Ordem;

public class BolsaDeValores {

    public void registrarOrdem(Acao acao, Ordem ordem) {
        acao.registrarOrdem(ordem);
    }

    public void inscreverInvestidor(Acao acao, Investidor investidor) {
        acao.adicionarObservador(investidor);
    }
}