package Problema3.adaptadores;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import Problema3.dispositivos.ArCondicionado;

public class ArCondicionadoVentoBaumnAdaptador implements ArCondicionado{
    private ArCondicionadoVentoBaumn arCondicionado;
    boolean ligado = false;

    public ArCondicionadoVentoBaumnAdaptador(ArCondicionadoVentoBaumn arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        arCondicionado.ligar();
    }

    @Override
    public void desligar() {
        arCondicionado.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionado.definirTemperatura(arCondicionado.getTemperatura() + 1);
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionado.definirTemperatura(arCondicionado.getTemperatura() - 1);
    }

    @Override
    public void definirTemperatura(int temperatura) {
        arCondicionado.definirTemperatura(temperatura);
       }
    
    public boolean estaLigado(){
        return this.ligado;
    }
}
