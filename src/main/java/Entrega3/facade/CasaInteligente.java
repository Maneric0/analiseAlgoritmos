package Entrega3.facade;

import Entrega3.domain.device.*;

import java.util.List;

public class CasaInteligente {

    private final List<Lampada> lampadas;
    private final List<Persiana> persianas;
    private final List<ArCondicionado> arCondicionados;

    public CasaInteligente(List<Lampada> lampadas,
                           List<Persiana> persianas,
                           List<ArCondicionado> arCondicionados) {
        this.lampadas = lampadas;
        this.persianas = persianas;
        this.arCondicionados = arCondicionados;
    }

    public void modoSono() {
        lampadas.forEach(Lampada::desligar);
        persianas.forEach(Persiana::fechar);
        arCondicionados.forEach(ArCondicionado::desligar);
    }

    public void modoTrabalho() {
        lampadas.forEach(Lampada::ligar);
        persianas.forEach(Persiana::abrir);

        arCondicionados.forEach(ar -> {
            ar.ligar();
            ar.definirTemperatura(25);
        });
    }
}