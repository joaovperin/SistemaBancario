/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.utils;

import br.feevale.banco.model.Cliente;

/**
 * Classe SeguroVida
 *
 * @author Joaov
 */
public class SeguroVida implements Tributavel {
    
    private static final double VALOR_TRIBUTOS = 42;

    private Cliente cliente;

    public SeguroVida() {
    }

    public SeguroVida(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public double calculaTributos() {
        return VALOR_TRIBUTOS;
    }

}
