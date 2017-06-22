/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.core;

import br.feevale.banco.exception.OperacaoInvalidaException;
import br.feevale.banco.model.Cliente;
import br.feevale.banco.model.Conta;
import br.feevale.banco.model.ContaCorrente;
import br.feevale.banco.model.ContaPoupanca;
import br.feevale.utils.Alert;
import br.feevale.utils.AtualizadorContas;

/**
 * Sistema
 */
public class SistemaBancario implements Sistema {

    /**
     * Inicializa o sistema
     */
    @Override
    public void run() {
        Conta c1 = new ContaCorrente();
        Conta c2 = new ContaPoupanca();
        
        c1.addSaldo(100);
        c2.addSaldo(200);
        
        Cliente cli1 = new Cliente();
        Cliente cli2 = new Cliente();
        
        c1.setCliente(cli1);
        c2.setCliente(cli2);
        
        cli1.setCpf("12345678932");
        cli2.setCpf("12345678932");
        
        try {
            cli1.validaCpf();
            cli2.validaCpf();
            new Cliente("eu", "mesmo", "034.232.653-28").validaCpf();
            new Cliente("Fulano", "Detal", "034.fdfsdf.653-28").validaCpf();
        } catch (OperacaoInvalidaException e){
//            e.printStackTrace(System.out);
        }
        
        
        AtualizadorContas att = new AtualizadorContas(30);
        att.rodaAtualizacao(c1);
        att.rodaAtualizacao(c2);
        
        
        Alert.show("Atenção", "Olá :D");
        
    }

}
