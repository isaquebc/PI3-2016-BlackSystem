<%-- 
    Document   : alterar
    Created on : 18/04/2016, 20:20:25
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>5aBlack - Buscar Pedido</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
      
        
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