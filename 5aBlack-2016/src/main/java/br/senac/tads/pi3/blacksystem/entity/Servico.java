/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.sql.Date;

/**
 *
 * @author Rafael
 */
public class Servico {

    private String tipoServico;
    private String descricaoServico;
    private float preco;
    private String prazo;
    private int id;

    public Servico(String tipoServico, String descricaoServico, float preco, String prazo, int id) {
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.preco = preco;
        this.prazo = prazo;
        this.id = id;
    }

    public Servico() {
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }// </editor-fold>
}
