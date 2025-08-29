package Problema3.adaptadores;

import br.furb.analise.algoritmos.PersianaNatLight;
import Problema3.dispositivos.Persiana;

public class PersianaNatLightAdaptador implements Persiana{
    private PersianaNatLight persiana;

    public PersianaNatLightAdaptador(PersianaNatLight persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        if (!persiana.estaPalhetaAberta()) {
            persiana.abrirPalheta();
        }
        try {
            persiana.subirPalheta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fechar() {
        persiana.descerPalheta();
        try {
            persiana.fecharPalheta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
