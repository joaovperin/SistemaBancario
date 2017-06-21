/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.exception;

/**
 * Exceção padrão para operações inválidas
 */
public class OperacaoInvalidaException extends Exception {

    /**
     * Construtor padrão para levantar uma exceção com uma mensagem
     *
     * @param message
     */
    public OperacaoInvalidaException(String message) {
        super(message);
    }

    /**
     * Construtor para encapsular uma exceção com uma mensagem
     *
     * @param cause
     * @param message
     */
    public OperacaoInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

}
