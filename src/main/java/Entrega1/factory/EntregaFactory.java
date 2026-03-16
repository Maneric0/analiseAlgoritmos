package Entrega1.factory;

import Entrega1.domain.entrega.PacEntrega;
import Entrega1.domain.entrega.RetiradaEntrega;
import Entrega1.domain.entrega.SedexEntrega;
import Entrega1.domain.entrega.TipoEntrega;
import Entrega1.enums.TipoEntregaEnum;

public class EntregaFactory {

    public static TipoEntrega criar(TipoEntregaEnum tipo) {

        return switch (tipo) {
            case PAC -> new PacEntrega();
            case SEDEX -> new SedexEntrega();
            case RETIRADA -> new RetiradaEntrega();
        };

    }
}