/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.banco.model;

import br.feevale.utils.Tributavel;

/**
 * Classe ContaCorrente
 *
 * @author Joaov
 */
public class ContaCorrente extends Conta implements Tributavel {

    private static final double TAXA_TRIBUTARIA = 0.01;
    private static double TAXA_INVESTIMENTO = 0.03;

    public ContaCorrente() {
    }

    public ContaCorrente(long numero) {
        super(numero);
    }

    public ContaCorrente(long numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public double calculaTributos() {
        return getSaldo() * TAXA_TRIBUTARIA;
    }

    @Override
    public void recebeInvestimento() {
        addSaldo(TAXA_INVESTIMENTO * getSaldo());
    }

}
