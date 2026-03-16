package Entrega1.valueObjects;

public class Dinheiro {

    private final double valor;

    public Dinheiro(double valor) {

        if (valor < 0) {
            throw new IllegalArgumentException("Valor monetário não pode ser negativo");
        }

        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}