package Entrega3.adapter.Lampada;

import Entrega3.domain.device.Lampada;
import br.furb.analise.algoritmos.LampadaPhellipes;

public class LampadaPhelippesAdapter implements Lampada {

    private final LampadaPhellipes lampada;
    private boolean ligada;

    public LampadaPhelippesAdapter(LampadaPhellipes lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        lampada.setIntensidade(100);
        ligada = true;
    }

    @Override
    public void desligar() {
        lampada.setIntensidade(0);
        ligada = false;
    }

    @Override
    public boolean isLigada() {
        return ligada;
    }
}