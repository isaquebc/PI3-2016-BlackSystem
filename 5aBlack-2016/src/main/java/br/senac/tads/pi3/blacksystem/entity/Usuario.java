/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Miqueas Santos
 */
public class Usuario extends Funcionario{
    

   
    private String salt;

    public Usuario() {
    }

    
    
    public Usuario(String senha, String salt) {
        this.setHashSenha(senha);
        this.salt = salt;
    }

    // <editor-fold defaultstate="collapsed" desc="Metodos Get e Set.">

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }// </editor-fold>
        
    public Usuario validar(Usuario usuarioBanco) {
    if (this.pegarCpf() != null && this.getHashSenha().equals(usuarioBanco.getHashSenha())) {
      return this;
    }
    return null;
  }
    public boolean autorizado(String papelNecessario) {
    List<String> papeisUsuario = Arrays.asList(this.getPapeis());
    return papeisUsuario.contains(papelNecessario);
    }
    
    
}
