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

    public Cliente(int id, String nome, String sonbrenome, String cpf, String telefone, String celular, String email, String rua, int numero, String estado, String cidade, String cep) {
        super(id, nome, sonbrenome, cpf, telefone, celular, email, rua, numero, estado, cidade, cep);
        
    }
    
    Endereco endereco;

    public Cliente() {
        
    }

    public boolean validar(){
        if(getNome() != null && getCpf() != null && getSobrenome() != null 
                && getSexo() != null && getCelular() != null && getEmail() != null){
        return true;
    }
        return false;
    }
    
    
    
    
}
