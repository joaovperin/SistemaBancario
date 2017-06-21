/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.bean;

/**
 * Bean com os dados de um cliente
 */
public class ClienteBean {

    /** Nome */
    private String nome;
    /** Sobrenome */
    private String sobrenome;
    /** Cpf */
    private String cpf;

    /**
     * Retorna o nome
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o sobrenome
     *
     * @return String
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Define o sobrenome
     *
     * @param sobrenome
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Retorna o cpf
     *
     * @return String
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o cpf
     *
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
