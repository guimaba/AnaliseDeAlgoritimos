import java.util.ArrayList;

public class Pedido {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public double calcularFrete(TipoFrete tipoFrete) {
        return tipoFrete.calcularFrete(calcularPesoTotal());
    }

    private double calcularPesoTotal() {
        double pesoTotal = 0;
        for (Produto produto : produtos) {
            pesoTotal += produto.getPesoKG();
        }
        return pesoTotal;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    @Override
    public String toString() {
        return produtos + "";
    }

}
