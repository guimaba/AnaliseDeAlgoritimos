package Problema3.dispositivos;

public interface ArCondicionado {
    void ligar();
    void desligar();
    void aumentarTemperatura();
    void diminuirTemperatura();
    void definirTemperatura(int temperatura);
    boolean estaLigado();
}
