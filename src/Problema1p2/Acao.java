package Problema1p2;

import java.util.ArrayList;
import java.util.Iterator;

public class Acao implements Subject{

    private String nomeAcao;
    private double valor;
    private ArrayList<Ordem> listaOrdens = new ArrayList<>();
    private ArrayList<Investidor> listaInvestidoresRegistrados = new ArrayList<>();
    private ArrayList<Ordem> ordemPreProgramada = new ArrayList<>();
    private ArrayList<Observer> observadores = new ArrayList<>();

    public Acao(String nomeAcao, double valor) {
        this.nomeAcao = nomeAcao;
        this.valor = valor;
    }

    public Acao() {
    }

    public void inserirOrdem(Ordem ordem) {
        listaOrdens.add(ordem);
        verificarMatch();
        ordemPre();
    }

    public void inserirOrdemProgramada(Ordem ordem) {
        ordemPreProgramada.add(ordem);
        System.out.println("Ordem pre cadastrada" + ordemPreProgramada);
    }

    public void ordemPre() {
        for (Ordem ordem : ordemPreProgramada) {
            if (ordem.getValor() == getValor()) {
                listaOrdens.add(ordem);
            }
        }
    }

    public void inserirInvestidor(Investidor investidor) {
        listaInvestidoresRegistrados.add(investidor);
    }

    public void verificarMatch() {
        Iterator<Ordem> iterator = listaOrdens.iterator();
        ArrayList<Ordem> ordemRemovidas = new ArrayList<>();
        while (iterator.hasNext()) {
            Ordem ordem = iterator.next();
            for (Ordem ordemNext : listaOrdens) {
                if (!ordem.equals(ordemNext) && !ordem.getTipo().equals(ordemNext.getTipo())
                        && ordem.getValor() == ordemNext.getValor()) {
                    ordemRemovidas.add(ordem);
                    ordemRemovidas.add(ordemNext);
                    iterator.remove();
                    System.out.println("Valor da ultima negociacao: " + nomeAcao + " : " + ordem.getValor());
                    atualizarValor(valor);
                    break;
                }
            }
        }
        listaOrdens.removeAll(ordemRemovidas);
    }

    public void notificar() {
        for (Investidor investidor : listaInvestidoresRegistrados) {
            investidor.update(valor);
        }
    }

    public void atualizarValor(double novoValor) {
        novoValor += 5;
        valor = novoValor;
        notifyObservers();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Ordem> getListaOrdens() {
        return listaOrdens;
    }

    @Override
    public String toString() {
        return nomeAcao + " = " + valor + " = " + listaOrdens;
    }

    public void setListaOrdens(ArrayList<Ordem> listaOrdens) {
        this.listaOrdens = listaOrdens;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public ArrayList<Investidor> getListaInvestidoresNotificados() {
        return listaInvestidoresRegistrados;
    }

    public void setListaInvestidoresNotificados(ArrayList<Investidor> listaInvestidoresNotificados) {
        this.listaInvestidoresRegistrados = listaInvestidoresNotificados;
    }

    @Override
    public void registerObserver(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observadores) {
            o.update();
        };
    }

    public ArrayList<Observer> getObservadores() {
        return observadores;
    }

}
