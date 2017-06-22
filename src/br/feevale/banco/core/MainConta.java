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
import br.feevale.utils.GerenciadorImpostoRenda;
import br.feevale.utils.SeguroVida;

/**
 * https://github.com/joaovperin/SistemaBancario.git
 *
 * @author Perin
 */
public class MainConta {

    /**
     * Método principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Sistema sistema = new SistemaBancario();
//        sistema.run();

        Cliente cl1 = new Cliente("Fulano", "DeTal", "12345628392");
        Cliente cl2 = new Cliente("Sao josé", "Da silva", "023.234.522-23");

        ContaCorrente c1 = new ContaCorrente(1, cl1);
        Conta c2 = new ContaPoupanca(2, cl2);

        AtualizadorContas ac = new AtualizadorContas(20);
        GerenciadorImpostoRenda gi1 = new GerenciadorImpostoRenda(cl1);
        GerenciadorImpostoRenda gi2 = new GerenciadorImpostoRenda(cl2);

        SeguroVida sv1 = new SeguroVida(cl2);

        try {
            c1.executaDeposito(25.00);
            c1.executaSaque(17.00);
            c1.executaSaque(3.00);
            c1.executaDeposito(1.00);
            c1.printaSaldoAtual();
            c1.recebeInvestimento();
        } catch (OperacaoInvalidaException e) {
            System.out.println("Conta: c1.");
            Alert.show(e.getMessage());
        }

        try {
            c2.executaDeposito(15.00);
            c2.executaSaque(17.00);
            c2.executaSaque(3.00);
            c1.transfere(c2, 3.00);
            c2.printaSaldoAtual();
        } catch (OperacaoInvalidaException e) {
            System.out.println("Conta: c2.");
            Alert.show(e.getMessage());
        }

        ac.rodaAtualizacao(c1);

        try {
            c1.executaDeposito(100);
        } catch (OperacaoInvalidaException e) {
            System.out.println("Conta: c1.");
            Alert.show(e.getMessage());
        }
        gi1.adiciona(c1);
        gi1.imprimeIR();

        gi1.adiciona(sv1);
        gi1.imprimeIR();

        c1.printaSaldoAtual();
        c2.printaSaldoAtual();

    }

}
