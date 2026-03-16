package Entrega1.domain.entrega;

import Entrega1.domain.pedido.Pedido;

public class SedexEntrega implements TipoEntrega {

    @Override
    public double calcularFrete(Pedido pedido) {

        double peso = pedido.getPesoTotal().getValor();

        int gramas = (int) Math.round(peso * 1000);

        if (gramas <= 500)
            return 12.50;

        if (gramas <= 1000)
            return 20;

        int excesso = gramas - 1000;
        int adicionais = (int) Math.ceil(excesso / 100.0);

        return 46.50 + adicionais * 1.50;
    }
}