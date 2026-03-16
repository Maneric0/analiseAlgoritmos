package Entrega1.domain.entrega;

import Entrega1.domain.pedido.Pedido;

public interface TipoEntrega {

    double calcularFrete(Pedido pedido);

}
