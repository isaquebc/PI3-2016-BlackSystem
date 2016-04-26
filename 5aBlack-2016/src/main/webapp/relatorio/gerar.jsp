<%-- 
    Document   : gerar
    Created on : 18/04/2016, 20:20:41
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/estilo-relatorio.css" rel="stylesheet"/>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.blue_grey-light_blue.min.css" />  

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>

        <title>5aBlack - Relatorio</title>
    </head>
    <body>

        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        <main id="main-layout" class="mdl-layout__content">
            <div id=container>

                <form action="GerarRelatorioServlet" method="post" accept-charset="UTF-8">
                    <fieldset id="campos-relatorio"> 
                        <legend><h1>Relatório</h1></legend>
                        <div class="mdl-textfield mdl-js-textfield">
                            <label>Tipo de Relatório:</label>
                            <select class="mdl-textfield__input" name="tipoRelatorio" id="tipo-relatorio">
                                <option value="">Selecione</option>
                                <option value="venda">Vendas</option>
                                <option value="cliente">Cliente</option>
                                <option value="funcionario">Funcionario</option>
                                <option value="produto">Produto</option>
                                <option value="pedido">Pedido</option>
                            </select>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield">
                            <label for="cpf">Periodo:</label>
                            <input type="date" class="mdl-textfield__input" id="data-inicial" for="data-inicial" name="data-inicial"/>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield">
                            <label>à</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield">

                            <input type="date" class="mdl-textfield__input" id="data-final" for="data-final" name="data-final"/>
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
