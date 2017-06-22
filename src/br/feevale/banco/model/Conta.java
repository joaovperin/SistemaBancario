/*
 * SistemaBancario
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.banco.model;

import br.feevale.banco.exception.OperacaoInvalidaException;

/**
 * Objeto responsável pelas regras de negócio de uma conta bancária
 */
public abstract class Conta {

    /** Número de contas instanciadas */
    private static long numContas = 0;

    /** Total de operações do tipo Depósito */
    private static int totalOperacoesDeposito;
    /** Total de operações do tipo Retirada */
    private static int totalOperacoesRetirada;

    /** Taxa de SAQUE */
    private static final double TAXA_DEPOSITO = 0.10;
    /** Número da conta */
    private long numero;
    /** Saldo atual da conta */
    private double saldo;
    /** Cliente titular da conta */
    private Cliente cliente;

    public Conta() {
        this(0);
    }

    public Conta(long numero) {
        this(numero, null);
    }

    public Conta(long numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        numContas++;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public abstract void recebeInvestimento();

    public void transfere(Conta destino, double valorTransferencia) throws OperacaoInvalidaException {
        // Executa validações
        validaValorPositivo(valorTransferencia);
        validaSaldoSuficiente(valorTransferencia);
        // Executa a transferência
        subSaldo(valorTransferencia);
        destino.addSaldo(valorTransferencia);
    }

    public void executaDeposito(double valorDeposito) throws OperacaoInvalidaException {
        tributaDeposito();
        validaValorPositivo(valorDeposito);
        addSaldo(valorDeposito);
        totalOperacoesDeposito++;
    }

    public void executaSaque(double valorSaque) throws OperacaoInvalidaException {
        validaSaldoSuficiente(valorSaque);
        subSaldo(valorSaque);
        totalOperacoesRetirada++;
    }

    /**
     * Executa validação verificando se há saldo suficiente
     *
     * @param valorSubtraido
     * @throws OperacaoInvalidaException
     */
    private void validaSaldoSuficiente(double valorSubtraido) throws OperacaoInvalidaException {
        // Se não possuir saldo suficiente
        if (getSaldo() - valorSubtraido < 0) {
            throw new OperacaoInvalidaException("Saldo insuficiente para realizar a transação!\nSaldo: " + valorSubtraido);
        }
    }

    private void validaValorPositivo(double valorOperacao) throws OperacaoInvalidaException {
        // Se o valor da operação for negativo
        if (valorOperacao < 0) {
            throw new OperacaoInvalidaException("Valor da transação inválido!");
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

    protected void tributaDeposito() {
        subSaldo(TAXA_DEPOSITO);
    }

    public void printaSaldoAtual() {
        StringBuilder sb = new StringBuilder(toString());
        sb.append("Saldo atual: ").append(String.format("%2f", getSaldo()));
        sb.append("\n");
        System.out.println(sb.toString());
    }

    public static long getNumContas() {
        return numContas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conta número ").append(getNumero()).append("\n");
        sb.append("Titular: ").append(getCliente().getNome()).append(' ');
        sb.append(getCliente().getSobrenome()).append("\n");
        return sb.toString();
    }

}
