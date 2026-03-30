package Entrega3.adapter.ArCondicionado;

import Entrega3.domain.device.ArCondicionado;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class ArVentoBaumnAdapter implements ArCondicionado {

    private final ArCondicionadoVentoBaumn ar;
    private boolean ligado;
    private int temperatura = 24;

    public ArVentoBaumnAdapter(ArCondicionadoVentoBaumn ar) {
        this.ar = ar;
    }

    @Override
    public void ligar() {
        ar.ligar();
        ligado = true;
    }

    @Override
    public void desligar() {
        ar.desligar();
        ligado = false;
    }

    @Override
    public void aumentarTemperatura() {
        temperatura++;
        ar.definirTemperatura(temperatura);
    }

    @Override
    public void diminuirTemperatura() {
        temperatura--;
        ar.definirTemperatura(temperatura);
    }

    @Override
    public void definirTemperatura(int temperatura) {
        this.temperatura = temperatura;
        ar.definirTemperatura(temperatura);
    }

    @Override
    public int getTemperatura() {
        return temperatura;
    }

    @Override
    public boolean isLigado() {
        return ligado;
    }
}