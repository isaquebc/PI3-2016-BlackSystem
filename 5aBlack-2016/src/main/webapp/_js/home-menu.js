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
    
    document.body.classList.toggle("menuFechado");
    
    
}
function abrirMenu() {
    menu = document.body.classList.toggle("menuAberto");
    document.body.classList.toggle("menuFechado");
}
function abrirPedido(){
    pedido = document.body.classList.toggle("menuPedido");
}
function abrirFuncionario(){
    funcionario = document.body.classList.toggle("menuFuncionario");
}
function abrirServicoProduto(){
    servicoProduto = document.body.classList.toggle("menuServicoProduto");
}
function abrirCliente(){
    cliente = document.body.classList.toggle("menuCliente");
}
function abrirChamado(){
    chamado =  document.body.classList.toggle("menuChamado");
}
function abrirRelatorio(){
    relatorio  =  document.body.classList.toggle("menuRelatorio");
}
