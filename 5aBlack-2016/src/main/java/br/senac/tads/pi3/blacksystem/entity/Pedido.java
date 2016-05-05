/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

/**
 *
 * @author Rafael
 */
public class Pedido {
    
    private String tipoPeca;
    private    String tipoTecido;
    private    String tipoLavagem;
    private    String qtd;
    private    String cor;
    private    Servico servico;

    public Pedido(String tipoPeca, String tipoTecido, String tipoLavagem, String qtd, String cor, Servico servico) {
        this.tipoPeca = tipoPeca;
        this.tipoTecido = tipoTecido;
        this.tipoLavagem = tipoLavagem;
        this.qtd = qtd;
        this.cor = cor;
        this.servico = servico;
    }

    public Pedido() {
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }

    public String getTipoLavagem() {
        return tipoLavagem;
    }

    public void setTipoLavagem(String tipoLavagem) {
        this.tipoLavagem = tipoLavagem;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
}
