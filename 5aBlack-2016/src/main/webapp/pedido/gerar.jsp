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
        <title>5aBlack - Gerar Pedido</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
        <h1 id="t">Pedido</h1>
        <form action="GerarPedidoServlet" method="post" accept-charset="UTF-8">
            <fieldset id="Roupa"> 
                <div class="roupa">
                    <div class="campo tipo-peca">
                        <label>Tipo de Peça</label>
                        <select name="tipoPeca" id="tipo-peca">
                            <option value="">Selecione</option>
                            <option value="camiseta">Camiseta</option>
                            <option value="calca">Calça</option>
                            <option value="camiseta">Camiseta</option>
                            <option value="camiseta">Camiseta</option>
                            <option value="camiseta">Camiseta</option>
                        </select>
                    </div>
                    <div class="campo tipo-tecido">
                        <label>Tipo de Tecido</label>
                        <select name="tipoTecido" id="tipo-tecido">
                            <option value="">Selecione</option>
                            <option value="camiseta">Moletom</option>
                            <option value="camiseta">Algodão</option>
                            <option value="camiseta">Seda</option>
                            <option value="camiseta">Elastano</option>
                            <option value="camiseta">Camiseta</option>
                        </select>
                    </div>
                    <div class="campo tipo-lavagem">
                        <label>Tipo de Lavagem</label>
                        <select name="tipoLavagem" id="tipo-lavagem">
                            <option value="">Selecione</option>
                            <option value="camiseta">A seco</option>
                            <option value="camiseta">Simples</option>
                        </select>
                    </div>
                    <div class="campo quantidade-peca">
                        <label>Quantidade</label>
                        <input type="number" name="quantidadePeca" id="quantidade-peca">
                    </div>
                    <div class="campo cor">
                        <label>Cor</label>
                        <select name="cor" id="cor" >
                            <option value="">Selecione</option>
                            <option value="camiseta">Azul</option>
                            <option value="camiseta">Amarelo</option>
                        </select>
                    </div>
                    <div class="campo data-retirada">
                        <label>Data de retirada</label>
                        <input type="date" name="quantidadePeca" id="data-retirada">
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
