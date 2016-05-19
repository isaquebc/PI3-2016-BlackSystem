/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("load", iniciar);
var peca, servico, tecido, quantidade, cor, dtRetirada;

function iniciar() {

    document.getElementById('inserir').onclick = function () {
       insere();
    };
}

function insere() {
    
    var linha = documento.createElement("tr");
    var peca = document.getElementById("tipoPeca").value; 
    var servico = document.getElementById("tipoServico").value;
    var tecido = document.getElementById("tipoTecido").value;
    var quantidade = document.getElementById("qtdPeca").value;
    var cor = document.getElementById("cor").value;
    var dtRetirada = document.getElementById("dtRetirada").value;
	
    peca.innerHTML=texto;
    servico.innerHTML=texto;
    tecido.innerHTML=texto;
    cor.innerHTML=texto;
    dtRetirada.innerHTML=texto;
    quantidade.innerHTML=texto;
    
    document.tbody.appendChild(linha);
    document.linha.appendChild(peca);
    document.linha.appendChild(servico);
    document.linha.appendChild(tecido);
    document.linha.appendChild(quantidade);
    document.linha.appendChild(cor);
    document.linha.appendChild(dtRetirada);

}