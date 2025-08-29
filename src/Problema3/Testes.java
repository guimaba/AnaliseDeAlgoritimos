package Problema3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Problema3.adaptadores.ArCondicionadoGellaKazaAdaptador;
import Problema3.adaptadores.ArCondicionadoVentoBaumnAdaptador;
import Problema3.adaptadores.LampadaPhelippesAdaptador;
import Problema3.adaptadores.LampadaShoyouMiAdaptador;
import Problema3.adaptadores.PersianaNatLightAdaptador;
import Problema3.adaptadores.PersianaSolariusAdaptador;
import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import br.furb.analise.algoritmos.LampadaPhellipes;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import Problema3.dispositivos.ArCondicionado;
import Problema3.dispositivos.Lampada;
import Problema3.dispositivos.Persiana;

public class Testes {

    @Test
    public void testeLigarLampadaPhelippes() {
        LampadaPhellipes lampadaReal = new LampadaPhellipes();
        Lampada lampadaAdapter = new LampadaPhelippesAdaptador(lampadaReal);
        lampadaAdapter.ligar();
        lampadaReal.setIntensidade(50);
        assertEquals(50, lampadaReal.getIntensidade());
    }

    @Test
    public void testeLigarLampadaShouyMi() {
        LampadaShoyuMi lampada = new LampadaShoyuMi();
        Lampada lampadaAdapter = new LampadaShoyouMiAdaptador(lampada);
        lampadaAdapter.ligar();
        assertTrue(lampada.estaLigada());
    }

    @Test
    public void testeArCondicionadoVentoBaumn() {
        ArCondicionadoVentoBaumn arCondicionadoReal = new ArCondicionadoVentoBaumn();
        ArCondicionado arCondicionadoAdapter = new ArCondicionadoVentoBaumnAdaptador(arCondicionadoReal);
        arCondicionadoAdapter.ligar();
        arCondicionadoAdapter.aumentarTemperatura();
        assertEquals(25, arCondicionadoReal.getTemperatura());
    }

    @Test
    public void testeArCondicionadoVentoBaumnTemperaturaLimite() {
        ArCondicionadoVentoBaumn arCondicionadoReal = new ArCondicionadoVentoBaumn();
        ArCondicionado arCondicionadoAdapter = new ArCondicionadoVentoBaumnAdaptador(arCondicionadoReal);
        arCondicionadoAdapter.ligar();
        for (int i = 0; i <= 10; i++) {
            arCondicionadoAdapter.aumentarTemperatura();
        }
        assertEquals(35, arCondicionadoReal.getTemperatura());
    }

    @Test
    public void testeArCondicionadoGellaKaza() {
        ArCondicionadoGellaKaza arCondicionadoGellaKaza = new ArCondicionadoGellaKaza();
        ArCondicionadoGellaKazaAdaptador arCondicionadoAdapter = new ArCondicionadoGellaKazaAdaptador(
                arCondicionadoGellaKaza);
        arCondicionadoAdapter.ligar();
        assertTrue(arCondicionadoGellaKaza.estaLigado());
    }

    @Test
    public void testeArCondicionadoGellaKazaTemperaturaLimite() {
        ArCondicionadoGellaKaza arCondicionadoGellaKaza = new ArCondicionadoGellaKaza();
        ArCondicionadoGellaKazaAdaptador arCondicionadoAdapter = new ArCondicionadoGellaKazaAdaptador(
                arCondicionadoGellaKaza);
        arCondicionadoAdapter.ligar();
        for (int i = 0; i < 7; i++) {
            arCondicionadoAdapter.aumentarTemperatura();
        }
        assertEquals(35, arCondicionadoGellaKaza.getTemperatura());
    }

    @Test
    public void testePersianaSolarius() {
        PersianaSolarius persianaReal = new PersianaSolarius();
        Persiana persianaAdapter = new PersianaSolariusAdaptador(persianaReal);
        persianaAdapter.abrir();
        assertTrue(persianaReal.estaAberta());
        persianaReal.subirPersiana();
    }

    @Test
    public void testePersianaNatLight() throws Exception {
        PersianaNatLight persianaNatLight = new PersianaNatLight();
        Persiana persianaAdapter = new PersianaNatLightAdaptador(persianaNatLight);
        persianaAdapter.abrir();
        assertTrue(persianaNatLight.estaPalhetaAberta());
        persianaNatLight.subirPalheta();
        assertTrue(persianaNatLight.estaPalhetaErguida());
        persianaNatLight.descerPalheta();
        persianaNatLight.fecharPalheta();
    }

    @Test
    public void testeModoSono() {
        LampadaPhellipes lampadaReal = new LampadaPhellipes();
        PersianaSolarius persianaReal = new PersianaSolarius();
        ArCondicionadoVentoBaumn arCondicionadoReal = new ArCondicionadoVentoBaumn();
        Lampada lampadaAdapter = new LampadaPhelippesAdaptador(lampadaReal);
        Persiana persianaAdapter = new PersianaSolariusAdaptador(persianaReal);
        ArCondicionado arCondicionadoAdapter = new ArCondicionadoVentoBaumnAdaptador(arCondicionadoReal);
        Ambientacao ambientacao = new Ambientacao(lampadaAdapter, persianaAdapter, arCondicionadoAdapter);
        ambientacao.modoSono();
    }

    @Test
    public void testeModoTrabalho() {
        LampadaPhellipes lampadaReal = new LampadaPhellipes();
        PersianaSolarius persianaReal = new PersianaSolarius();
        ArCondicionadoVentoBaumn arCondicionadoReal = new ArCondicionadoVentoBaumn();
        Lampada lampadaAdapter = new LampadaPhelippesAdaptador(lampadaReal);
        Persiana persianaAdapter = new PersianaSolariusAdaptador(persianaReal);
        ArCondicionado arCondicionadoAdapter = new ArCondicionadoVentoBaumnAdaptador(arCondicionadoReal);
        Ambientacao ambientacao = new Ambientacao(lampadaAdapter, persianaAdapter, arCondicionadoAdapter);
        ambientacao.modoTrabalho();
    }
   
}
