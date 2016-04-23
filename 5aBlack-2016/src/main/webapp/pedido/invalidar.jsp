<%-- 
    Document   : invalidar
    Created on : 18/04/2016, 19:50:41
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/estilo-buscar.css" rel="stylesheet"/>
        <title>5aBlack - Invalidar Pedido</title>
    </head>
    <body>
       
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
        <form action="InvalidarPedidoServlet" method="post" accept-charset="UTF-8">
            <fieldset id="pesquisa"> 
                <div class="campo pesquisa">
                    <input type="number" for="campo-pesquisa" id="campo-pesquisa" placeholder="Digite o numero do pedido">
                    <input type="submit" value="Pesquisar"  />
                </div> 
                
            </fieldset>

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