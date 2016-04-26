<%-- 
    Document   : gerar
    Created on : 18/04/2016, 19:50:07
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/estilo-formulario.css" rel="stylesheet"/>
        
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.blue_grey-light_blue.min.css" />  

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
        <script src="../_js/formatoJS.js" type="text/javascript"></script>
        <title>5aBlack - Gerar Pedido</title>
    </head>
    <body>

        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  

        <main id="main-layout" class="mdl-layout__content">
            <div class="roupa" id="container">
                <form action="GerarPedidoServlet" method="post" accept-charset="UTF-8">
                    <fieldset> 
                        <legend><h4>Gerar Pedido</h4></legend>
                        <div class="campo tipo-peca mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="tipo-peca">Tipo de Peça</label>
                            <select class="mdl-textfield__input" name="peca" id="peca" for="peca">
                                <option value=""></option>
                                <option value="camiseta">Camiseta</option>
                                <option value="calca">Calça</option>
                                <option value="camiseta">Camiseta</option>
                                <option value="camiseta">Camiseta</option>
                                <option value="camiseta">Camiseta</option>
                            </select>
                        </div>
                        <div class="campo tipo-tecido mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="tecido">Tipo de Tecido</label>
                            <select class="mdl-textfield__input" name="tipoTecido" id="tipo-tecido">
                                <option value=""></option>
                                <option value="camiseta">Moletom</option>
                                <option value="camiseta">Algodão</option>
                                <option value="camiseta">Seda</option>
                                <option value="camiseta">Elastano</option>
                                <option value="camiseta">Camiseta</option>
                            </select>
                        </div>
                        <div class="campo tipo-lavagem mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="lavagem">Tipo de Lavagem</label>
                            <select class="mdl-textfield__input" name="tipoLavagem" id="tipo-lavagem">
                                <option value=""></option>
                                <option value="camiseta">A seco</option>
                                <option value="camiseta">Simples</option>
                            </select>
                        </div>
                        <div class="campo quantidade-peca mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="quantidade">Quantidade</label>
                            <input type="number" class="mdl-textfield__input" name="quantidadePeca" id="quantidade">
                        </div>
                        <div class="campo cor mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="cor">Cor</label>
                            <select class="mdl-textfield__input" name="cor" id="cor" >
                                <option value=""></option>
                                <option value="camiseta">Azul</option>
                                <option value="camiseta">Amarelo</option>
                            </select>
                        </div>
                        <div class="campo data-retirada mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="retirada">Data de retirada</label>
                            <input type="date" class="mdl-textfield__input" name="quantidadePeca" id="data-retirada">
                        </div>
                    </fieldset>
                    <button type="submit" id="inserir" class="mdl-button mdl-js-button mdl-js-ripple-effect">Inserir</button>
                </form>
            </div>
        </main>
        <%--
            
            AQUI A GENTE VAI GERAR A LISTA DE PEDIDOS COM O ID INDICADO!!
             <c:forEach items="${lista}" var="pessoa">
             <h1>${pessoa.nome}</h1>
             <p>id: ${pessoa.id}</p>
             <p>e-mail: ${pessoa.email}</p>
             <p>Telefone: ${pessoa.telefone}</p>
             <p>Data Nascimento: <fmt:formatDate value="${pessoa.dtNascimento}" pattern="dd/MM/yyyy" /></p>
             </c:forEach>
            
        --%>
    </body>
</html>
