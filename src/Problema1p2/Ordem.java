package Problema1p2;

public class Ordem {

    private Investidor investidor;
    private String tipo;
    private double valor;

    public Ordem(Investidor investidor, String tipo, double valor) {
        this.investidor = investidor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "investidor = " + investidor +
                ", tipo = '" + tipo + '\'' +
                ", valor = " + valor +
                '}';
    }
}
