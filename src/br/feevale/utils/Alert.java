/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.utils;

import javax.swing.JOptionPane;

/**
 * Classe Alert
 *
 * @author Joaov
 */
public class Alert {

    /**
     * Exibe mensagem
     *
     * @param texto
     */
    public static void show(String texto) {
        show("Atenção!", texto);
    }

    /**
     * Exibe mensagem
     * 
     * @param titulo
     * @param texto
     */
    public static void show(String titulo, String texto) {
        show(titulo, texto, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exibe mensagem
     * 
     * @param titulo
     * @param texto
     * @param tipo
     */
    private static void show(String titulo, String texto, int tipo) {
        JOptionPane.showMessageDialog(null, texto, titulo, tipo);
    }

}
