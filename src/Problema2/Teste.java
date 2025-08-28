package Problema2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Teste {
    
    @Test
    public void testeCriarAcaoEInvestidor(){
        Acao acao_banco = new Acao("Banco do Brasil", 24);
        Investidor inves_um = new Investidor("Guilherme");
        inves_um.registrarOrdem(acao_banco, "COMPRA", 24);
        assertEquals("Banco do Brasil = 24.0 = [Ordem{investidor = Guilherme, tipo = 'COMPRA', valor = 24.0}]", acao_banco.toString());
    }

    @Test
    public void testeRegistrarEmAcao(){
        Acao acao_banco = new Acao("Banco do Brasil", 24);
        Investidor inves_um = new Investidor("Guilherme");
        inves_um.registrarseEmUmaAcao(acao_banco);
        assertTrue(acao_banco.getObservadores().contains(inves_um));
    
    }

    @Test
    public void verificarMatch(){
        Acao acao_banco = new Acao("Banco do Brasil", 24);
        Investidor inves_um = new Investidor("Guilherme");
        Investidor inves_dois = new Investidor("João");
        Investidor inves_tres = new Investidor("Fernanda");
        inves_um.registrarOrdem(acao_banco, "COMPRA", 24);
        inves_dois.registrarOrdem(acao_banco, "VENDA", 20);
        inves_tres.registrarOrdem(acao_banco, "VENDA", 24);
        assertEquals("Banco do Brasil = 29.0 = [Ordem{investidor = João, tipo = 'VENDA', valor = 20.0}]", acao_banco.toString());
    }

    @Test 
    public void testeNotificar(){
        Acao acao_banco = new Acao("Banco do Brasil", 24);
        Investidor inves_um = new Investidor("Guilherme");
        Investidor inves_dois = new Investidor("João");
        Investidor inves_tres = new Investidor("Fernanda");
        inves_um.registrarseEmUmaAcao(acao_banco);
        inves_um.registrarOrdem(acao_banco, "COMPRA", 24);
        inves_dois.registrarOrdem(acao_banco, "VENDA", 24);
        inves_tres.registrarOrdem(acao_banco, "VENDA", 10);
    }
    

    @Test
    public void testePreProgramada(){
        Acao acao_banco = new Acao("Banco do Brasil", 24);
        Investidor inves_um = new Investidor("Guilherme");
        Investidor inves_dois = new Investidor("João");
        Investidor inves_tres = new Investidor("Fernanda");
        inves_dois.programarOrdem(acao_banco, "COMPRA", 29);
        inves_um.registrarOrdem(acao_banco, "COMPRA", 24);
        inves_dois.registrarOrdem(acao_banco, "VENDA", 20);
        inves_tres.registrarOrdem(acao_banco, "VENDA", 24);
        System.out.println(acao_banco.toString());
    }
}

