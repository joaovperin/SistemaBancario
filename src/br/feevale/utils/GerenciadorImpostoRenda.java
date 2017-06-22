/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.utils;

import br.feevale.banco.model.Cliente;

/**
 * Classe GerenciadorImpostoRenda
 *
 * @author Joaov
 */
public class GerenciadorImpostoRenda {
    
    private double total;
    private Cliente cliente;

    public GerenciadorImpostoRenda(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void adiciona(Tributavel t){
        double tri = t.calculaTributos();
        System.out.printf("Adicionando %.2f no IRPF\n", tri);
        total += tri;
    }
    
    public void imprimeIR() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente ").append(cliente.getNome()).append(' ').append(cliente.getSobrenome());
        sb.append('\n').append("Total: ").append(String.format("%.2f", total)).append('\n');
        System.out.println(sb.toString());
    }

}
