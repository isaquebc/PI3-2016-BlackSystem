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
        
        <title>5aBlack - Relatorio</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
        <h1 id="t">relatorio</h1>
        <form action="GerarRelatorioServlet" method="post" accept-charset="UTF-8">
            <fieldset id="campos-relatorio"> 
                <div class="campos-relatorio">
                    <div class="campo tipo-relatorio">
                        <label>Tipo de Relatório</label>
                        <select name="tipoRelatorio" id="tipo-relatorio">
                            <option value="">Selecione</option>
                            <option value="venda">Vendas</option>
                            <option value="cliente">Cliente</option>
                            <option value="funcionario">Funcionario</option>
                            <option value="produto">Produto</option>
                            <option value="pedido">Pedido</option>
                        </select>
                    </div>
                    <div class="campo periodo">
                        <label>Periodo de </label>
                        <input type="date" id="data-inicial" for="data-inicial" name="data-inicial">
                        <label>à</label>
                        <input type="date" id="data-final" for="data-final" name="data-final">
                    </div>
                </div> 

            </fieldset>
            <input type="submit" value="Inserir" id="inserir"/>

        </form>
        
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
