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
    private float preco;
    private Date prazo;
    private long id;

    public Servico(String tipoServico, float preco, Date prazo, long id) {
        this.tipoServico = tipoServico;
        this.preco = preco;
        this.prazo = prazo;
        this.id = id;
    }

    public Servico() {
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

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
