/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.banco.model;

/**
 * Classe ContaPoupanca
 *
 * @author Joaov
 */
public class ContaPoupanca extends Conta {

    private static double TAXA_INVESTIMENTO = 0.18;

    public ContaPoupanca() {
    }

    public ContaPoupanca(long numero) {
        super(numero);
    }

    public ContaPoupanca(long numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public void recebeInvestimento() {
        addSaldo(TAXA_INVESTIMENTO * getSaldo());
    }

}
