<%-- 
    Document   : index.jsp
    Created on : 17/04/2016, 10:31:39
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="_css/estilo-login.css" rel="stylesheet"/>
        <script src="_js/formatoJS.js" type="text/javascript"></script>
        <title> 5aBlack </title>
    </head>
    <body>
        <div class="formul">
            <header>
               
                <h1>Login</h1>
            </header>

            <div class="mensagem alerta"></div>

            <form action="inicial/home.jsp" class="pessoal" method="post">

                <fieldset class="login">

                    <div class="campo obrigatorio">
                        <label for="cpf">CPF</label>
                        <input type="text" id="cpf" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" placeholder="___.___.___-__" >
                    </div>

                    <div class="campo obrigatorio">
                        <label for="senha">Senha</label>
                        <input type="password" id="senha" name="senha"/>
                    </div>
                    
                    

                </fieldset>
                <div class="btns">
                    <button type="submit">Fazer Login</button>
                    Esqueci minha Senha
                </div>
            </form>
        </div>
        <div id="lista" class="listagem"></div>
         <div class="logotipo"><img id="logo-login" src="_img/logotipo-grande.png"></div>

        <%--  
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
