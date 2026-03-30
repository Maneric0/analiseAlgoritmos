package Entrega3.adapter.Persiana;

import Entrega3.external.PersianaNatLight;
import Entrega3.domain.device.Persiana;

public class PersianaNatLightAdapter implements Persiana {

    private final PersianaNatLight persiana;
    private boolean aberta;

    public PersianaNatLightAdapter(PersianaNatLight persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        try {
            persiana.abrirPalheta();
            persiana.subirPalheta();
            aberta = true;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao abrir persiana NatLight", e);
        }
    }

    @Override
    public void fechar() {
        try{
            persiana.descerPalheta();
            persiana.fecharPalheta();
            aberta = false;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao abrir persiana NatLight", e);
        }
    }

    @Override
    public boolean estaAberta() {
        return aberta;
    }
}