package Entrega3.domain.device;

public interface ArCondicionado {

    void ligar();

    void desligar();

    void aumentarTemperatura();

    void diminuirTemperatura();

    void definirTemperatura(int temperatura);

    int getTemperatura();

    boolean isLigado();
}