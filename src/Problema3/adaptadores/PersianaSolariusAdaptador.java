package Problema3.adaptadores;

import br.furb.analise.algoritmos.PersianaSolarius;
import Problema3.dispositivos.Persiana;

public class PersianaSolariusAdaptador implements Persiana{
    private PersianaSolarius persiana;

    public PersianaSolariusAdaptador(PersianaSolarius persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        persiana.subirPersiana();
    }

    @Override
    public void fechar() {
        persiana.descerPersiana();
    }
}
