/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.model;

import br.feevale.banco.exception.OperacaoInvalidaException;
import java.util.regex.Pattern;

/**
 * Objeto responsável pelas regras de negócio de um cliente
 */
public class Cliente {

    /** Padrão para validar CPF com máscaras */
    private static final Pattern PT_CPF_MASK = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
    /** Padrão para validar CPF sem máscaras */
    private static final Pattern PT_CPF_UNMASK = Pattern.compile("\\d{11}");

    /** Nome */
    private String nome;
    /** Sobrenome */
    private String sobrenome;
    /** Cpf */
    private String cpf;

    public Cliente() {
        this(null, null, null);
    }

    public Cliente(String nome, String sobrenome) {
        this(nome, sobrenome, null);
    }

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Realiza a validação do CPF
     *
     * @throws OperacaoInvalidaException
     */
    public void validaCpf() throws OperacaoInvalidaException {
        String cpff = getCpf();
        if (cpff == null || cpff.trim().equals("")) {
            throw new OperacaoInvalidaException("CPF não informado!");
        }
        // Se não satisfaz nenhuma máscara
        if (!PT_CPF_MASK.matcher(cpff).find() && !PT_CPF_UNMASK.matcher(cpff).find()) {
            throw new OperacaoInvalidaException("O CPF informado é inválido! " + cpff);
        }
    }

}
