package Entrega1.domain.entrega;

import Entrega1.domain.pedido.Pedido;

public class PacEntrega implements TipoEntrega {

    @Override
    public double calcularFrete(Pedido pedido) {

        double peso = pedido.getPesoTotal().getValor();

        if (peso <= 1)
            return 10;

        if (peso <= 2)
            return 15;

        throw new IllegalArgumentException("PAC não aceita peso acima de 2kg");
    }
}