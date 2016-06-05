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
public class Servico {

    private String nomeServico;
    private String tipoServico;
    private float valorServico;
    private int prazo;
    private int id;

    public Servico(String tipoServico, String descricaoServico, float preco, int prazo, int id) {
        this.nomeServico = tipoServico;
        this.tipoServico = descricaoServico;
        this.valorServico = preco;
        this.prazo = prazo;
        this.id = id;
    }

    public Servico() {
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    public String getNomeServico() {
        return tipoServico;
    }

    public void setNomeServico(String descricaoServico) {
        this.tipoServico = descricaoServico;
    }

    public String getTipoServico() {
        return nomeServico;
    }

    public void setTipoServico(String tipoServico) {
        this.nomeServico = tipoServico;
    }

    public float getValorServico() {
        return valorServico;
    }

    public void setValorServico(float preco) {
        this.valorServico = preco;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }// </editor-fold>
}
