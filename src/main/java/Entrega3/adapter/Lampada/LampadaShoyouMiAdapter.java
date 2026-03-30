package Entrega3.adapter.Lampada;

import Entrega3.domain.device.Lampada;
import br.furb.analise.algoritmos.LampadaShoyuMi;

public class LampadaShoyouMiAdapter implements Lampada {

    private final LampadaShoyuMi lampada;
    private boolean ligada;

    public LampadaShoyouMiAdapter(LampadaShoyuMi lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        lampada.ligar();
        ligada = true;
    }

    @Override
    public void desligar() {
        lampada.desligar();
        ligada = false;
    }

    @Override
    public boolean isLigada() {
        return ligada;
    }
}
