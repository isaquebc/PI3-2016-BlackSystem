/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

/**
 *
 * @author Isaque
 */
public class Erro {
    
    private boolean existente;
    private String mensagem;

    public Erro(String mensagem,boolean existente) {
        this.mensagem = mensagem;
        this.existente = existente;
    }
    
    public boolean isExistente() {
        return existente;
    }

    public void setExistente(boolean existente) {
        this.existente = existente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.mensagem = Mensagem;
    }
    
    
    
    
}
