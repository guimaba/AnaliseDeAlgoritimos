package Problema1p2;

public class App {
    public static void main(String[] args) {
        Acao acao_banco = new Acao("Banco do Brasil", 24);
        Investidor inves_um = new Investidor("Aline");
        Investidor inves_dois = new Investidor("Pedro");
        Investidor inves_tres = new Investidor("Samira");
        inves_um.registrarseEmUmaAcao(acao_banco);
        acao_banco.removeObserver(inves_um);

        inves_um.registrarOrdem(acao_banco, "COMPRA", 24);
        inves_dois.registrarOrdem(acao_banco, "VENDA", 24);
        inves_tres.registrarOrdem(acao_banco, "VENDA", 10);
    }
}
