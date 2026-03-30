package Entrega3.adapter.ArCondicionado;

import Entrega3.external.ArCondicionadoGellaKaza;
import Entrega3.domain.device.ArCondicionado;

public class ArGellaKazaAdapter implements ArCondicionado {

    private final ArCondicionadoGellaKaza ar;
    private boolean ligado;
    private int temperatura = 28;

    public ArGellaKazaAdapter(ArCondicionadoGellaKaza ar) {
        this.ar = ar;
    }

    @Override
    public void ligar() {
        ar.ativar();
        ligado = true;
    }

    @Override
    public void desligar() {
        ar.desativar();
        ligado = false;
    }

    @Override
    public void aumentarTemperatura() {
        ar.aumentarTemperatura();
        temperatura++;
    }

    @Override
    public void diminuirTemperatura() {
        ar.diminuirTemperatura();
        temperatura--;
    }

    @Override
    public void definirTemperatura(int temperaturaDesejada) {
        while (temperatura < temperaturaDesejada) {
            aumentarTemperatura();
        }
        while (temperatura > temperaturaDesejada) {
            diminuirTemperatura();
        }
    }

    @Override
    public int getTemperatura() {
        return temperatura;
    }

    @Override
    public boolean estaLigado() {
        return ligado;
    }
}