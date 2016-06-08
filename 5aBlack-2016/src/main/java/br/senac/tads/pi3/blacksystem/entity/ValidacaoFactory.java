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
public class ValidacaoFactory {

    public ValidacaoFactory() {

    }

    public Erro validarCliente(Cliente cliente) {// <editor-fold defaultstate="collapsed" desc="Validação de Cliente.">

        String retorno = "";
        boolean estado = false;

        if (cliente.getNome().length() <= 2) {
            estado = true;
            retorno += "Nome em branco! <br/> ";
        }

        if (cliente.pegarCpf().length() <= 2 || !cliente.isCpf(cliente.pegarCpf())) {
            estado = true;
            retorno += "CPF invalido ou em branco! <br/> ";
        }

        if (cliente.getSobrenome().length() <= 2) {
            estado = true;
            retorno += "CPF em branco!<br/> ";
        }

        if (cliente.getSexo() == null) {
            estado = true;
            retorno += "Sexo em branco!<br/> ";
        }

        if (cliente.getCelular().length() <= 2) {
            estado = true;
            retorno += "Celular em branco!<br/> ";
        }

        if (cliente.getEmail().length() <= 2) {
            estado = true;
            retorno += "E-mail em branco!<br/> ";
        }
        if (cliente.getDtCadastro() == null) {
            estado = true;
            retorno += "Data de nascimento em branco!<br/> ";
        }

        Erro msg = new Erro(retorno, estado);
        return msg;
    }// </editor-fold>

    public Erro validarFuncionario(Funcionario funcionario) {
        String retorno = "";
        boolean estado = false;

        if (funcionario.getNome().length() <= 2) {
            estado = true;
            retorno += "Nome em branco! <br/> ";
        }

        if (funcionario.pegarCpf().length() <= 2 || !funcionario.isCpf(funcionario.pegarCpf())) {
            estado = true;
            retorno += "CPF invalido ou em branco! <br/> ";
        }

        if (funcionario.getSobrenome().length() <= 2) {
            estado = true;
            retorno += "CPF em branco!<br/> ";
        }

//        if (funcionario.getSexo() == null) {
//            estado = true;
//            retorno += "Sexo em branco!<br/> ";
//        }
        if (funcionario.getCelular().length() <= 2) {
            estado = true;
            retorno += "Celular em branco!<br/> ";
        }

        if (funcionario.getEmail().length() <= 2) {
            estado = true;
            retorno += "E-mail em branco!<br/> ";
        }
//        if (funcionario.getDtCadastro() == null) {
//            estado = true;
//            retorno += "Data de nascimento em branco!<br/> ";
//        }
        if (funcionario.getCargo() == null) {
            estado = true;
            retorno += "Cargo em branco!<br/> ";
        }
        if (funcionario.getSalario() == 0) {
            estado = true;
            retorno += "Salario em branco!<br/> ";
        }
        if (funcionario.getHashSenha() == null) {
            estado = true;
            retorno += "Senha em branco!<br/> ";
        }

        Erro err = new Erro(retorno, estado);
        return err;
    }

    public Erro validarPedido(Peca peca) {

        String retorno = "";
        boolean estado = false;

        if (peca.getDtRetirada().length() <= 2) {
            estado = true;
            retorno += "Data de retirada em branco! <br/> ";
        }
        if (peca.getCor().length() <= 2) {
            estado = true;
            retorno += "Cor em branco! <br/> ";
        }
        if (peca.getNomeServico().length() <= 2) {
            estado = true;
            retorno += "Serviço em branco! <br/> ";
        }
        if (peca.getQdt() <= 0) {
            estado = true;
            retorno += "Quantidade em branco! <br/> ";
        }
        if (peca.getTipoPeca().length() <= 2) {
            estado = true;
            retorno += "Tipo de peça em branco! <br/> ";
        }
        if (peca.getTipoTecido().length() <= 2) {
            estado = true;
            retorno += "Tipo de tecido em branco! <br/> ";
        }

        Erro err = new Erro(retorno, estado);
        return err;
    }

    public Erro validarChamado(Chamado chamado) {

        String retorno = "";
        boolean estado = false;

        if (chamado.getDescricao() == null) {
            estado = true;
            retorno += "Descrição em branco!<br/> ";
        }
        if (chamado.getTipoSolicitacao() == null) {
            estado = true;
            retorno += "Categoria em branco!<br/> ";
        }

        Erro err = new Erro(retorno, estado);
        return err;
    }

    public Erro validarServico(Servico servico) {

        String retorno = "";
        boolean estado = false;

        if (servico.getNomeServico() == null) {
            estado = true;
            retorno += "Nome em branco!<br/> ";
        }
        if (servico.getPrazo() <= 0) {
            estado = true;
            retorno += "Prazo em branco!<br/> ";
        }
        if (servico.getTipoServico() == null) {
            estado = true;
            retorno += "Tipo de servi;o em branco!<br/> ";
        }
        if (servico.getValorServico() <= 0) {
            estado = true;
            retorno += "Valor em branco!<br/> ";
        }
        Erro err = new Erro(retorno, estado);
        return err;
    }

    public Erro validarProduto(Produto produto) {

        String retorno = "";
        boolean estado = false;

        if (produto.getData() == null) {
            estado = true;
            retorno += "Data em branco!<br/> ";
        }
        if (produto.getLote() == null) {
            estado = true;
            retorno += "Lote em branco!<br/> ";
        }
        if (produto.getNome() == null) {
            estado = true;
            retorno += "Nome em branco!<br/> ";
        }
        if (produto.getQtdAtual() <= 0) {
            estado = true;
            retorno += "Quantidade em branco!<br/> ";
        }
        if (produto.getQtdMax() <= 0) {
            estado = true;
            retorno += "Quantidade Maxima em branco!<br/> ";
        }
        if (produto.getQtdMin() <= 0) {
            estado = true;
            retorno += "Quantidade Minima em branco!<br/> ";
        }
        if (produto.getStatus() == null) {
            estado = true;
            retorno += "Status em branco!<br/> ";
        }
        if (produto.getTipoDeProduto() == null) {
            estado = true;
            retorno += "Produto em branco!<br/> ";
        }
        if (produto.getValidade() == null) {
            estado = true;
            retorno += "Validade em branco!<br/> ";
        }

        Erro err = new Erro(retorno, estado);
        return err;
    }
    
}
