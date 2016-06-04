/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.sql.Date;
import static java.sql.Types.INTEGER;

/**
 *
 * @author Isaque
 */
public class FeedNoticias {
 
    private Integer id;
    private String descricao;
    private Date dataPostagem;
    private String titulo;
    private Integer idFuncionario;

    public FeedNoticias() {
    }

    public FeedNoticias(String descricao, String titulo, Integer idFuncionario) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.idFuncionario = idFuncionario;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">
    
    public Integer getId() {
        return id;
    } 
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }// </editor-fold>
}
