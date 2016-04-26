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


        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.blue_grey-light_blue.min.css" />  

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
        <title> 5aBlack </title>
    </head>
    <body>
        <header class="mdl-layout__header mdl-layout__header--waterfall">
            <h1><img id="logo-login" src="_img/logotipo-grande.png"></h1>
        </header>
        <main id="main-layout" class="mdl-layout__content">
            <div id=container>
                <form action="inicial/home.jsp" method="post">
                    <fieldset>
                        <legend><h1>Login</h1></legend>
                        <div class="mdl-textfield mdl-js-textfield">

                            <label class="mdl-textfield__label" for="cpf">CPF</label>
                            <input type="text" class="mdl-textfield__input" id="cpf" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" />
                        </div>
                        <div class="mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="senha">Senha</label>
                            <input class="mdl-textfield__input" type="password" name="senha"/>

                        </div>

                    </fieldset>
                    <button type="submit" class="mdl-button mdl-js-button mdl-js-ripple-effect">Entrar</button>

                    <span><a href="#" class="mdl-navigation__link">Esqueceu a Senha?</a></span>
                </form>
            </div>
        </main>

    </body>
    <%--  
                    <c:forEach items="${lista}" var="pessoa">
                    <h1>${pessoa.nome}</h1>
                    <p>id: ${pessoa.id}</p>
                    <p>e-mail: ${pessoa.email}</p>
                    <p>Telefone: ${pessoa.telefone}</p>
                    <p>Data Nascimento: <fmt:formatDate value="${pessoa.dtNascimento}" pattern="dd/MM/yyyy" /></p>
                    </c:forEach>
            
        </body>
    --%>
</html>
