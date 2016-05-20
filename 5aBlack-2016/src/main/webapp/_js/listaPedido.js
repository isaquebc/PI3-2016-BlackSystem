/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("load", iniciar);
var peca, servico, tecido, quantidade, cor, dtRetirada, cont = 0;

function iniciar() {

    document.getElementById('inserir').onclick = function () {
        insere();
    };
}

function insere() {

    var peca = document.getElementById("tipoPeca").value;
    var servico = document.getElementById("tipoServico").value;
    var tecido = document.getElementById("tipoTecido").value;
    var quantidade = document.getElementById("qtdPeca").value;
    var cor = document.getElementById("cor").value;
    var dtRetirada = document.getElementById("dtRetirada").value;

    if (peca === "" || servico === "" || tecido === "" || quantidade === "" || cor === "" || dtRetirada === "") {
    }
    else {
        cont++;
        $('#tabela').append('<tr id="' + cont + '"></tr>');
        $('#' + cont + '').append('<td><input type="text" class="esconder" name="servico' + cont + '" value="' + servico + '" readonly/></td>');
        $('#' + cont + '').append('<td><input type="text" class="esconder" name="tipoPeca' + cont + '" value="' + peca + '" readonly/></td>');
        $('#' + cont + '').append('<td><input type="text" class="esconder" name="tecido' + cont + '" value="' + tecido + '" readonly/></td>');
        $('#' + cont + '').append('<td><input type="text" class="esconder" name="qtd' + cont + '" value="' + quantidade + '" readonly/></td>');
        $('#' + cont + '').append('<td><input type="text" class="esconder" name="cor' + cont + '" value="' + cor + '" readonly/></td>');
        $('#' + cont + '').append('<td><input type="text" class="esconder" name="dtRetirada' + cont + '" value="' + dtRetirada + '" readonly/></td>');

        document.getElementById("tipoPeca").value = "";
        document.getElementById("tipoServico").value = "";
        document.getElementById("tipoTecido").value = "";
        document.getElementById("qtdPeca").value = "";
        document.getElementById("cor").value = "";
        document.getElementById("dtRetirada").value = "";
        document.getElementById("cont").value = cont; 
    }
}