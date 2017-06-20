/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.model;

/**
 * Descrição da classe.
 */
public class Conta {

    private static int totalOperacoesDeposito;
    private static int totalOperacoesRetirada;

    private int numero;
    private double saldo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTotalOperacoes() {
        return getTotalOperacoesDeposito() + getTotalOperacoesRetirada();
    }

    public  int getTotalOperacoesDeposito() {
        return totalOperacoesDeposito;
    }

    public int getTotalOperacoesRetirada() {
        return totalOperacoesRetirada;
    }

}
