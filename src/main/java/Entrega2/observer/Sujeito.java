package Entrega2.observer;

public interface Sujeito {

    void adicionarObservador(Observador observador);
    void removerObservador(Observador observador);
    void notificar();

}