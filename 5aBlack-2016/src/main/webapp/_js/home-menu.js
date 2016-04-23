/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", iniciar);
var menu;
var pedido;
var funcionario;
var servicoProduto;
var cliente;
var chamado;
var relatorio;
var lista = [];

function iniciar() {

    menu = document.querySelector("#config");
    pedido = document.querySelector("#pedido");
    funcionario = document.querySelector("#funcionario");
    servicoProduto = document.querySelector("#servicoProduto");
    cliente = document.querySelector("#cliente");
    chamado = document.querySelector("#chamado");
    relatorio = document.querySelector("#relatorio");

    menu.addEventListener("click", abrirMenu);
    pedido.addEventListener("click", abrirPedido);
    funcionario.addEventListener("click", abrirFuncionario);
    servicoProduto.addEventListener("click", abrirServicoProduto);
    cliente.addEventListener("click", abrirCliente);
    chamado.addEventListener("click", abrirChamado);
    relatorio.addEventListener("click", abrirRelatorio);



}
function abrirMenu() {
    menu = document.body.classList.toggle("menuAberto");
}
function abrirPedido() {
    
    var i;
    if (lista.length !== 0) {
        for (i = lista.length; i >= 0; i--) {
            document.body.classList.remove(lista.pop());
        }
        abrirPedido();
    }
    else {
        pedido = document.body.classList.toggle("menuPedido");
        lista.push("menuPedido");
    }
}

function abrirFuncionario() {

    var i;
    if (lista.length !== 0) {
        for (i = lista.length; i >= 0; i--) {
            document.body.classList.remove(lista.pop());
        }
        abrirFuncionario();
    }
    else {
        pedido = document.body.classList.toggle("menuFuncionario");
        lista.push("menuFuncionario");
    }
}

function abrirServicoProduto() {

    var i;
    if (lista.length !== 0) {
        for (i = lista.length; i >= 0; i--) {
            document.body.classList.remove(lista.pop());
        }
        abrirServicoProduto();
    }
    else {
        pedido = document.body.classList.toggle("menuServicoProduto");
        lista.push("menuServicoProduto");
    }
}


function abrirCliente() {

    var i;
    if (lista.length !== 0) {
        for (i = lista.length; i >= 0; i--) {
            document.body.classList.remove(lista.pop());
        }
        abrirCliente();
    }
    else {
        pedido = document.body.classList.toggle("menuCliente");
        lista.push("menuCliente");
    }
}

function abrirChamado() {

    var i;
    if (lista.length !== 0) {
        for (i = lista.length; i >= 0; i--) {
            document.body.classList.remove(lista.pop());
        }
        abrirChamado();
    }
    else {
        pedido = document.body.classList.toggle("menuChamado");
        lista.push("menuChamado");
    }
}

function abrirRelatorio() {

    var i;
    if (lista.length !== 0) {
        for (i = lista.length; i >= 0; i--) {
            document.body.classList.remove(lista.pop());
        }
        abrirRelatorio();
    }
    else {
        pedido = document.body.classList.toggle("menuRelatorio");
        lista.push("menuRelatorio");
    }
}
