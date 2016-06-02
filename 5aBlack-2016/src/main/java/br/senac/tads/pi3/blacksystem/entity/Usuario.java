/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.blacksystem.entity;

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

 

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    
    public Usuario validar(Usuario usuarioBanco) {
    if (this.getCpf() != null && this.getHashSenha().equals(usuarioBanco.getHashSenha())) {
      return this;
    }
    return null;
  }
    
    
    
}
