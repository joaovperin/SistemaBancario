/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.model;

import br.feevale.banco.bean.ContaBean;
import br.feevale.banco.exception.OperacaoInvalidaException;

/**
 * Objeto responsável pelas regras de negócio de uma conta bancária
 */
public class Conta extends ContaBean {

    /** Total de operações do tipo Depósito */
    private static int totalOperacoesDeposito;
    /** Total de operações do tipo Retirada */
    private static int totalOperacoesRetirada;

    /**
     * Transfere um valor para uma conta destino
     *
     * @param valorTransferencia
     * @param destino
     * @throws OperacaoInvalidaException
     */
    public void transfere(Conta destino, double valorTransferencia) throws OperacaoInvalidaException {
        // Se for um valor inválido
        if (valorTransferencia <= 0) {
            throw new OperacaoInvalidaException("Valor de transferência inválido!");
        }
        executaValidacaoSaldo(valorTransferencia);
        subSaldo(valorTransferencia);
        destino.addSaldo(valorTransferencia);
    }

    /**
     * Executa validação verificando se há saldo suficiente
     *
     * @param valorSubtraido
     * @throws OperacaoInvalidaException
     */
    private void executaValidacaoSaldo(double valorSubtraido) throws OperacaoInvalidaException {
        // Se não possuir saldo suficiente
        if (getSaldo() - valorSubtraido < 0) {
            throw new OperacaoInvalidaException("Saldo insuficiente para realizar a transação!");
        }
    }

    /**
     * Retorna o total de operações (todos os tipos)
     *
     * @return int
     */
    public int getTotalOperacoes() {
        return getTotalOperacoesDeposito() + getTotalOperacoesRetirada();
    }

    /**
     * Retorna o total de operações do tipo depósito
     *
     * @return int
     */
    public int getTotalOperacoesDeposito() {
        return totalOperacoesDeposito;
    }

    /**
     * Retorna o total de operações do tipo retirada
     *
     * @return int
     */
    public int getTotalOperacoesRetirada() {
        return totalOperacoesRetirada;
    }

}
