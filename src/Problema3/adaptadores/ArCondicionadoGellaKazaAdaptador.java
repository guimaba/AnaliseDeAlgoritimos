package Problema3.adaptadores;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import Problema3.dispositivos.ArCondicionado;

public class ArCondicionadoGellaKazaAdaptador implements ArCondicionado {
    private ArCondicionadoGellaKaza arCondicionado;
    boolean ligado = false;

    public ArCondicionadoGellaKazaAdaptador(ArCondicionadoGellaKaza arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        arCondicionado.ativar();
    }

    public boolean estaLigado() {
        return this.ligado;
    }

    @Override
    public void desligar() {
        arCondicionado.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionado.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionado.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        if (arCondicionado.getTemperatura() < temperatura) {
            while (arCondicionado.getTemperatura() != temperatura) {
                arCondicionado.aumentarTemperatura();
            }
        } else {
            while (arCondicionado.getTemperatura() != temperatura) {
                arCondicionado.diminuirTemperatura();
            }
        }
    }

}
