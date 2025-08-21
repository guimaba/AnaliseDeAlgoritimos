public class Produto {
    private String nome;
    private double valor;
    private double pesoKG;

    Produto(String nome, double valor, double pesoKG) {
        setNome(nome);
        setValor(valor);
        setPeso(pesoKG);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPesoKG() {
        return pesoKG;
    }

    public void setPeso(double pesoKG) {
        this.pesoKG = pesoKG;
    }

    @Override
    public String toString() {
        return nome;
    }

}
