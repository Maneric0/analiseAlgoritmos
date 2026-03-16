package Entrega1.domain.entrega;

import Entrega1.domain.pedido.Pedido;

public class RetiradaEntrega implements TipoEntrega {

    @Override
    public double calcularFrete(Pedido pedido) {
        return 0;
    }
}