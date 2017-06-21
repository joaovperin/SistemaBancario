/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.bean;

import br.feevale.banco.model.Cliente;

/**
 * Bean com os dados de uma conta
 */
public class ContaBean {

    /** Número da conta */
    private long numero;
    /** Saldo atual da conta */
    private double saldo;
    /** Cliente titular da conta */
    private Cliente cliente;

    /**
     * Retorna o número da conta
     *
     * @return int
     */
    public long getNumero() {
        return numero;
    }

    /**
     * Define o número da conta
     *
     * @param numero
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }

    /**
     * Retorna o saldo da conta
     *
     * @return double
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Define o saldo da conta
     *
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Acrescenta um valor ao saldo
     *
     * @param valor
     */
    public void addSaldo(double valor) {
        this.saldo += valor;
    }

    /**
     * Subtrai um valor do saldo
     *
     * @param valor
     */
    public void subSaldo(double valor) {
        this.saldo -= valor;
    }

    /**
     * Retorna o cliente titular da conta
     *
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o cliente titular da conta
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
