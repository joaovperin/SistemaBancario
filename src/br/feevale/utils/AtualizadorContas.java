/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.utils;

import br.feevale.banco.model.Conta;

/**
 * Classe AtualizadorContas
 *
 * @author Joaov
 */
public class AtualizadorContas {

    private final double taxaAtualizacao;

    public AtualizadorContas(double taxaAtualizacao) {
        this.taxaAtualizacao = taxaAtualizacao;
    }

    public void rodaAtualizacao(Conta c) {
        System.out.println("Saldo Antes da atualização...");
        c.printaSaldoAtual();
        c.addSaldo(getSaldoAtualizacao(c));
        System.out.println("Saldo atualizado...");
        c.printaSaldoAtual();
    }

    private double getSaldoAtualizacao(Conta c) {
        if (c.getSaldo() == 0) {
            return 0;
        }
        return taxaAtualizacao * c.getSaldo() / 100;
    }

}
