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
public class Cliente extends Pessoa{

    public Cliente(String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        super(nome, sonbrenome, cpf, telefone, celular, email, rua, numero, estado, cidade, cep);
        
    }

    public Cliente() {
        
    }
    
    
    
    
}
