package Entrega3.adapter.Persiana;

import Entrega3.domain.device.Persiana;
import br.furb.analise.algoritmos.PersianaSolarius;

public class PersianaSolariusAdapter implements Persiana {

    private final PersianaSolarius persiana;
    private boolean aberta;

    public PersianaSolariusAdapter(PersianaSolarius persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        persiana.subirPersiana();
        aberta = true;
    }

    @Override
    public void fechar() {
        persiana.descerPersiana();
        aberta = false;
    }

    @Override
    public boolean isAberta() {
        return aberta;
    }
}