import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Teste {

    @Test
    public void testeAdicionarItem() {
        Pedido pedido_cliente = new Pedido();
        Produto livro_1 = new Produto("A", 52.00, 0.500);
        Produto livro_2 = new Produto("B", 40.50, 0.450);
        pedido_cliente.adicionarProduto(livro_1);
        pedido_cliente.adicionarProduto(livro_2);
        assertEquals("[A, B]", pedido_cliente.toString());
    }

    @Test
    public void testeRetirada() {
        Pedido pedido_cliente = new Pedido();
        Produto livro_1 = new Produto("A", 52.00, 0.250);
        Produto livro_2 = new Produto("B", 40.50, 0.100);
        pedido_cliente.adicionarProduto(livro_1);
        pedido_cliente.adicionarProduto(livro_2);
        TipoFrete frete = new RetirarLoja();
        double valorFrete = pedido_cliente.calcularFrete(frete);
        assertEquals(0.00, valorFrete, 0.01);

    }

    @Test
    public void testePAC() {
        Pedido pedido_cliente = new Pedido();
        Produto livro_1 = new Produto("A", 52.00, 1.250);
        Produto livro_2 = new Produto("B", 40.50, 2.100);
        pedido_cliente.adicionarProduto(livro_1);
        pedido_cliente.adicionarProduto(livro_2);
        TipoFrete frete = new PAC();
        double valorFrete = pedido_cliente.calcularFrete(frete);
        assertEquals(30.00, valorFrete, 0.01);

    }

    @Test
    public void testeSEDEX() {
        Pedido pedido_cliente = new Pedido();
        Produto livro_1 = new Produto("A", 52.00, 0.250);
        Produto livro_2 = new Produto("B", 40.50, 0.100);
        pedido_cliente.adicionarProduto(livro_1);
        pedido_cliente.adicionarProduto(livro_2);
        TipoFrete frete = new Sedex();
        double valorFrete = pedido_cliente.calcularFrete(frete);
        assertEquals(12.50, valorFrete, 0.01);
    }
}