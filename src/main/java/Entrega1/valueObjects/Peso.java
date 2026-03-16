package Entrega1.valueObjects;

public class Peso {

    private final double valor;

    public Peso(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        }

        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}