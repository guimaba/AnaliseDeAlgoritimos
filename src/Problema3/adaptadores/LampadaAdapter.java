package Problema3.adaptadores;

import Problema3.dispositivos.Lampada;

public class LampadaAdapter implements Lampada{

    LampadaPhelippesAdaptador lampadaPhelippes = new LampadaPhelippesAdaptador();
    LampadaShoyouMiAdaptador lampadaShoyouMi = new LampadaShoyouMiAdaptador();

    @Override
    public void ligar() {
        lampadaShoyouMi.ligar();
    }

    @Override
    public void desligar() {
        throw new UnsupportedOperationException("Unimplemented method 'desligar'");
    }

    
    
}
