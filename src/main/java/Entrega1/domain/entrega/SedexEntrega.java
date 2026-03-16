package Entrega1.domain.entrega;

import Entrega1.domain.pedido.Pedido;

public class SedexEntrega implements TipoEntrega {

    @Override
    public double calcularFrete(Pedido pedido) {

        double peso = pedido.getPesoTotal().getValor();

        if (peso <= 0.5)
            return 12.50;

        if (peso <= 1)
            return 20;

        double excesso = peso - 1;
        double adicionais = Math.ceil(excesso / 0.1);

        return 46.50 + adicionais * 1.50;
    }
}